package com.tampro.Controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tampro.Model.CartItem;
import com.tampro.Model.Category;
import com.tampro.Model.Order;
import com.tampro.Model.User;
import com.tampro.Service.CartItemService;
import com.tampro.Service.CategoryService;
import com.tampro.Service.OrderService;
import com.tampro.Service.ProductService;
import com.tampro.Service.ProfileService;

@Controller
public class OrderController {
	
	@Autowired
	ProfileService profileService;
	@Autowired
	CartItemService cartitemService;
	@Autowired 
	OrderService orderService;
	@Autowired
	ProductService productService;
	@Autowired 
	CategoryService cService;


	
	
	
	@RequestMapping("order")
	public String total(ModelMap map,HttpSession session,@RequestParam("total") int total)
	{
		// thanh toan
		User us = (User) session.getAttribute("user");

		if(us==null) //  ko dang nhap thi ve login
		{
			List<Category> list  = cService.getAllCategory();
			map.addAttribute("list", list);
			map.addAttribute("user", new User());
			map.addAttribute("mess", "thanh toan nhanh");
			
			return "login";
		
		}
		else // dang nhap roi
		{
			if(profileService.getProfileByIdUser(us.getIdUser())==null) // neu ko co thong tin 
			{
				return "redirect:them-thong-tin-ca-nhan"; // thi tra ve trang them thong tin
			}
			else /// neu co roi thi add vao csdl
			{
				List<CartItem> listCart =(List<CartItem>) session.getAttribute("listcartitem"); // lay ra listcart
				
				
				for(CartItem cart : listCart) // chay listcart
				{
					cartitemService.addCartItemDAO(cart); // luu cartitem vao csdl roi lay key ra 
					Order od = new Order(); // tao ra od 
					od.setIdUser(us.getIdUser()); //set iduser dat hang 
					od.setIdCartItem(cart.getIdCartItem()); // key sau khi tra ve	
					orderService.addOrder(od);
				}
			}
		}
	
		
		map.addAttribute("mess", "Thanh Toan Thanh Cong");
	    //thanh toan thanh cong roi	, neu ma thanh cong thi ta add vao de biet so luong
		// thanh toan xog roi thi ta  chac chan co gia tri list cart
		

		session.removeAttribute("listcartitem");
		
		return "checkout";
	}

}
