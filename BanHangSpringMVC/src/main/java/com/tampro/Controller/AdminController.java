package com.tampro.Controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.tampro.Model.Join;
import com.tampro.Model.Order;
import com.tampro.Model.Product;
import com.tampro.Model.User;
import com.tampro.Model.View;
import com.tampro.Service.CartItemService;
import com.tampro.Service.OrderService;
import com.tampro.Service.ProductService;
import com.tampro.Service.UserService;
import com.tampro.Service.ViewService;
import com.tampro.Validator.UserValidator;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	UserService userService;
	@Autowired
	UserValidator userValidator;
	@Autowired
	ProductService productService;
	@Autowired
	CartItemService cartItemService;
	@Autowired
	OrderService orderService;
	@Autowired
	ViewService viewService;
	
	public boolean CheckSessionAdmin(HttpSession session)
	{
		User us  = (User) session.getAttribute("user");
		if(us==null)
		{
			return false;
		}
		else
		{
			if(us.getRole().equals("user"))
			{
				return false;
			}
			else
			{
				return true;
			}
		}	
	}
	
	


	
	
	@RequestMapping("/index")
	public String admin(HttpSession session,ModelMap map)
	{
		if(CheckSessionAdmin(session))
		{
			
			List<View> listView = viewService.get4ViewAll(); // 4 id co luot xem nhieu nhat
			//	
			if(!listView.isEmpty())
			{
				List<Product> listproduct = new ArrayList<Product>();
				for(View view : listView)
				{
					Product product = productService.getProductById(view.getIdProduct());
					product.setcountView(view.getCountView());
					listproduct.add(product);
					
				}
				map.addAttribute("productview", listproduct);
				
			}
			return "index";
		}
		else
		{
			return "redirect:/admin/login";
		}
		
	}
	

	@RequestMapping("/them-san-pham")
	public String AddProduct(ModelMap map,HttpSession session)
	{
	
		if(CheckSessionAdmin(session))
		{
			map.addAttribute("product", new Product());
			return "addproduct"; //admin
		}
		else
		{
			return "redirect:/admin/login";
		}

	}
	@RequestMapping("/addproduct")
	public String AddProduct(ModelMap map,@ModelAttribute("product")Product product,HttpSession session) throws IOException
	{
		if(CheckSessionAdmin(session)==false)
		{
			return "redirect:/admin/login";
		}
		if((product.getMultipartFile().isEmpty()==true)||product.getIdCategory()==0||product.getNameProduct().length()==0)
		{
			map.addAttribute("mess", "dien day du thong tin");
			return "addproduct"; 
		}
		
		
		MultipartFile multipartFile = product.getMultipartFile();
		File file = new File("C:\\Users\\Admin\\eclipse-workspace\\BanHangSpringMVC\\src\\main\\webapp\\resources\\images\\"+multipartFile.getOriginalFilename());
		FileOutputStream fileOutputStream = new FileOutputStream(file);
		fileOutputStream.write(multipartFile.getBytes());
		product.setImagesProduct("images/"+multipartFile.getOriginalFilename());
		fileOutputStream.close();
	
		productService.addProduct(product);
		
		map.addAttribute("product", new Product());
		map.addAttribute("mess", "them thanh cong");
		return "addproduct"; 

	}
	
	@RequestMapping("/them-tai-khoan")
	public String adduser(ModelMap map,HttpSession session)
	{
		if(CheckSessionAdmin(session)==false)
		{
			return "redirect:/admin/login";
		}

		map.addAttribute("userr", new User());	
		return "adduser";
		
      // tra ve form login
	}
	
	@RequestMapping("/adduser") // form logic
	public String adduser(ModelMap map,@ModelAttribute("userr")User us,BindingResult result,HttpSession session)
	{
		
		if(CheckSessionAdmin(session)==false)
		{
			return "redirect:/admin/login";
		}
		if(us.getUsername().length()==0||us.getPassword().length()==0||us.getRole()==null)
		{
			map.addAttribute("mess", "dien day du thong tin");
			return "adduser"; 
		}
		
		User user =userService.getUserByUsername(us.getUsername());
		if(user!=null || us.getPassword().length()==0)// da co trong csdl
		{
			map.addAttribute("userr", new User());
			map.addAttribute("mess", "dang ki khong thanh cong");
			return "adduser";
		}
		else
		{
			userService.addUser(us);
			map.addAttribute("mess", "them thanh cong");
			map.addAttribute("userr", new User());	
			return "adduser";
		}
		
			

	}
	@RequestMapping("/logout")
	public String Logout(ModelMap map,HttpSession session)
	{
		session.removeAttribute("user");
		
		return "redirect:/admin/login";
	}
	@RequestMapping("/login") // tra ve form dang nhap
	public String Login(ModelMap map,HttpSession session)
	{
		if(CheckSessionAdmin(session))
		{
			return "redirect:/admin/index";
		}
		map.addAttribute("user", new User());
		return "loginadmin";
	}
	@RequestMapping("/dang-nhap") //logic dang nhap
	public String Login(ModelMap map,@ModelAttribute("user")User us,HttpSession session)
	{
		
		User user = userService.getUserByUsername(us.getUsername());
		if(user==null)
		{
			return "redirect:/admin/login";
		}
		else // khac null
		{
			if(user.getPassword().equals(us.getPassword()))
			{
				if(user.getRole().equals("admin")) // role la admin
				{
					session.setAttribute("user", user);
					return "redirect:/admin/index";
				}
				else
				{
					return "redirect:/admin/login";
				}
			}
			else
			{
				return "redirect:/admin/login";
			}
		}

	
		
	}
	
	
	
	
	
	@RequestMapping("/alluser")
	public String alluser(ModelMap map,HttpSession session)
	{
		if (CheckSessionAdmin(session)) {
			List<User> listUser = userService.getAllUser();
			map.addAttribute("listuser", listUser);	
			return "alluser";
		}
		else
		{
			return "redirect:/admin/login";
		}
		
	}
	
	@RequestMapping("/allproduct")
	public String allproduct(ModelMap map,HttpSession session)
	{
		if (CheckSessionAdmin(session)) {
			List<Product> listProduct = productService.getAllProduct();
			map.addAttribute("listproduct", listProduct);
			
			return "allproduct";
		}
		else
		{
				return "redirect:/admin/login";
			
		}
		
		
	}
	@RequestMapping("/xoa-san-pham")
	public String product(ModelMap map,HttpSession session,@RequestParam("idproduct") int id)
	{
		if (CheckSessionAdmin(session)) {
			productService.deleteProduct(id);
			
			map.addAttribute("mess", "xoa thanh cong");
			List<Product> listProduct = productService.getAllProduct();
			map.addAttribute("listproduct", listProduct);
			return "allproduct";
		}
		else
		{
				return "redirect:/admin/login";
			
		}
	}
	
	@RequestMapping("/bill")
	public String bill(ModelMap map,HttpSession session)
	{
		if (CheckSessionAdmin(session)) {
			List<Join> cartjoin= cartItemService.getList();
			map.addAttribute("bill", cartjoin);
			
			
			return "bill";
		}
		else
		{
				return "redirect:/admin/login";
			
		}
	}
	@RequestMapping("/bill-chi-tiet")
	public String bill(ModelMap map,HttpSession session,@RequestParam("idproduct") int idProduct )
	{
		if (CheckSessionAdmin(session)) {
			Product product = productService.getProductById(idProduct);
			map.addAttribute("product", product);
			
			return "chitiet";
		}
		else
		{
				return "redirect:/admin/login";
			
		}
	}
	@RequestMapping("/xoa-bill")
	public String deletebill(ModelMap map,HttpSession session,@RequestParam("idorder") int idorder )
	{
		if (CheckSessionAdmin(session)) {
			Order od = orderService.getOrder(idorder);
			orderService.deleteOrder(idorder); 
			cartItemService.DeleteCartItem(od.getIdCartItem());
			List<Join> cartjoin= cartItemService.getList();
			map.addAttribute("bill", cartjoin);
			map.addAttribute("mess", "Chap Nhan bill");
			return "bill";
		}
		else
		{
				return "redirect:/admin/login";
			
		}
	}
	
	
	

}
