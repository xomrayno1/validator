package com.tampro.Controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tampro.Model.Category;
import com.tampro.Model.User;
import com.tampro.Service.CategoryService;
import com.tampro.Service.ProductService;
import com.tampro.Service.ProfileService;
import com.tampro.Service.UserService;
import com.tampro.Validator.UserValidator;

@Controller
public class UserController {
//SELECT field1, field2 FROM table_name LIMIT start, limit  
//select count(product_id)  from product where category_id = ?; tinh tong san pham 
	@Autowired
	CategoryService cService;
	@Autowired
	ProductService productService;
	@Autowired
	UserService userService;
	@Autowired
	ProfileService profileService;
	@Autowired
	UserValidator userValidate;

	@RequestMapping("/login")
	public String login(ModelMap map,HttpSession session) {

		if(session.getAttribute("user")!=null)
		{
			return "redirect:trang-chu";
		}
		else
		{
			List<Category> list = cService.getAllCategory();
			map.addAttribute("list", list);
			map.addAttribute("user", new User());
		}

		return "login";
	}

	@RequestMapping("/dang-nhap")
	public String login(ModelMap map, @ModelAttribute("user") User us, HttpSession session, BindingResult error) {

		List<Category> list = cService.getAllCategory();
		map.addAttribute("list", list);
		User user = userService.getUserByUsername(us.getUsername());
		boolean kt = true;
		if (user == null) // ko co user nao trong csdl
		{
			userValidate.validate(us, error, kt);
			if (error.hasErrors()) {
				return "login"; // ta ko nen redirect , vi redirect no se tra ve controller login
				// khi do no tao ra 1 cai user moi va atribute den form login nen ko xuat hien
				// cai error, vi the tra chi tra ve view login no kem theo err luon
			}
			return "login";
		} else // co user
		{
			if (user.getPassword().equals(us.getPassword())) {

				session.setAttribute("user", user);
				session.setMaxInactiveInterval(60); // time out 30s tu out session
				if (user.getRole().equals("user")) {
					if (profileService.getProfileByIdUser(user.getIdUser()) == null) {
						return "redirect:them-thong-tin-ca-nhan";
					}
					return "redirect:trang-chu";
				} else {

					return "redirect:/admin/index";
				}

			} else {
				userValidate.validate(us, error, kt);
				if (error.hasErrors()) {
					return "login"; // ta ko nen redirect , vi redirect no se tra ve controller login
					// khi do no tao ra 1 cai user moi va atribute den form login nen ko xuat hien
					// cai error, vi the tra chi tra ve view login no kem theo err luon
				}
				return "login";
			}

		}

	}

	@RequestMapping("/logout")
	public String logout(ModelMap map, HttpSession session) {

		session.removeAttribute("user");
		session.removeAttribute("listcartitem");

		return "redirect:trang-chu";
	}

	@RequestMapping("/dang-ki")
	public String register(ModelMap map) {

		List<Category> list = cService.getAllCategory();
		map.addAttribute("list", list);
		map.addAttribute("user", new User());

		return "register";
	}
	
	@RequestMapping("/register")
	public String register(ModelMap map,@ModelAttribute("user")User us,BindingResult result ) {

		boolean kt = true; // co user
		if(userService.getUserByUsername(us.getUsername())==null)
		{
			kt= false; // userchua dc tao
		}
		userValidate.validate1(us, result, kt);
		if(result.hasErrors())
		{
			return "register";
		}
		userService.addUser(us);

		return "redirect:login";
	}
	
	@RequestMapping("/doi-mat-khau")
	public String editpassword(HttpSession session) {
		if(session.getAttribute("user")==null)
		{ 
			return "redirect:login"; // neu chua dang nhap
		}



		return "editpassword";
	}
	@RequestMapping("/edit")
	public String editpassword(ModelMap map,@RequestParam("newpassword")String newpassword,
			@RequestParam("reppassword")String reppassword,HttpSession session ) {
		User us = (User) session.getAttribute("user"); // lay ra duoc user
		if(newpassword.length()==0)
		{
			map.addAttribute("mess", "Khong Thanh Cong, mat khau ko trung");
			return "editpassword"; 
			
		}
			
		
		if(newpassword.equals(reppassword))
		{
			us.setPassword(newpassword);
			userService.updateUser(us);
			map.addAttribute("mess", "Doi Mat Khau Thanh Cong ");
			
		}
		else
		{
			
			map.addAttribute("mess", "Khong Thanh Cong, mat khau ko trung");
			
		}

		return "editpassword";
	}

	
	
	
}
