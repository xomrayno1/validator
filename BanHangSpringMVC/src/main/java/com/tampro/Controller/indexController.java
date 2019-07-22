package com.tampro.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tampro.Model.CartItem;
import com.tampro.Model.Category;
import com.tampro.Model.Contact;
import com.tampro.Model.Product;
import com.tampro.Model.View;
import com.tampro.Service.CategoryService;
import com.tampro.Service.ProductService;
import com.tampro.Service.ViewService;

@Controller
public class indexController {

	
	@Autowired
	CategoryService cService;
	@Autowired
	ProductService productService;
	@Autowired
	ViewService viewService;
	@Autowired
	MailSender mailSender;
	
	@RequestMapping("/trang-chu")
	public String index(ModelMap map)
	{
		List<Category> list  = cService.getAllCategory();
		map.addAttribute("list", list);
		
		List<View> listView = viewService.get4ViewAll(); // 4 id co luot xem nhieu nhat
		//	
		if(!listView.isEmpty())
		{
			List<Product> listproduct = new ArrayList<Product>();
			for(View view : listView)
			{
				Product product = productService.getProductById(view.getIdProduct());
				listproduct.add(product);
			}
			map.addAttribute("productview", listproduct);
			
		}
		

		
			return "trangchu";
	}
	
	@RequestMapping("/contact")
	public String contact(ModelMap map)
	{
		
		List<Category> list  = cService.getAllCategory();
		map.addAttribute("list", list);

		map.addAttribute("contact", new Contact());
		
		
		return "contact";
	}
	@RequestMapping("/gui-mail")
	public String contact(ModelMap map,@ModelAttribute("contact") Contact contact,HttpSession session)
	{
				
		
		List<Category> list  = cService.getAllCategory();
		map.addAttribute("list", list);
		CartItem cartItem = new  CartItem();
		
		List<CartItem> listOb = (List<CartItem>)session.getAttribute("listcartitem");
		String text ="";
		if(listOb.isEmpty())
		{
			text="";
		}
		else
		{
			for(CartItem cart : listOb)
			{
		 text =text + "Ten San Pham : "+cart.getProduct().getNameProduct()+"  So Luong -"+cart.getQuantity()+" - Gia Tong/sanpham -"+cart.getUnitPrice()+" \n";
			}
		}
		String mailtext ="Don Hang Order : "+"\n"+text;
		
		SendMail(contact.getSDT(),"xomrayno5@gmail.com",contact.getSubject(),contact.getYourMessage(),mailtext,contact.getYourName());
		          // email nhan         , email gui          , tieu de             , noi dung
		 
		session.removeAttribute("listcartitem");
		
		return "redirect:trang-chu";
	}
	
	
	
	
	public void SendMail(String sdt, String to, String subject , String content,String text,String name)
	{
		
		
		
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		
		mailMessage.setTo(to);
		mailMessage.setSubject(subject);
		mailMessage.setText(content+"\n Ten :"+name+"\n So Dien Thoai Lien He :"+sdt+"\n"+text);
		mailSender.send(mailMessage);
	}
	
	
	
	
	
}
