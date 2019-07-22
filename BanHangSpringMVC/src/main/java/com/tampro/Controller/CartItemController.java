package com.tampro.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tampro.Model.CartItem;
import com.tampro.Model.Category;
import com.tampro.Model.Product;
import com.tampro.Model.User;
import com.tampro.Service.CategoryService;
import com.tampro.Service.ProductService;

@Controller
public class CartItemController {
	
	@Autowired
	ProductService productService;
	@Autowired
	CategoryService cService;
	

	@RequestMapping("them-gio-hang")
	public String CartItem(ModelMap map , HttpSession session,@RequestParam("idproduct") int idProduct) {
		
		
		User us = (User) session.getAttribute("user");
		
				
			List<CartItem> listOb = (List<CartItem>)session.getAttribute("listcartitem");
			if(listOb==null)//ko co gi het  , gio ko co gi ta tao mot gio moi
			{
				Product product = productService.getProductById(idProduct);
				CartItem cartItem = new CartItem();
				cartItem.setProduct(product);
				cartItem.setQuantity(1);
				cartItem.setUnitPrice(product.getPriceProduct()*1);
				List<CartItem> listCartItem = new ArrayList<CartItem>();
				listCartItem.add(cartItem);
				session.setAttribute("listcartitem", listCartItem);
			}
			else // gio da co hang . 2 truong hop : 1 la hang vua vao  gio vao them cai thu 2 , va hang vao tiep theo chua co trong gio
			{
				boolean kt= true;
				Product product = productService.getProductById(idProduct);
				List<CartItem> listCartItem = listOb;
				for(CartItem  cart : listOb )
				{
					if(cart.getProduct().getIdProduct()==product.getIdProduct()) //kiem tra san pham trong gio hang co giong vs id nguoi khac mua tiep ko
					{
						cart.setQuantity(cart.getQuantity()+1); // cap nhat lai so luong
						cart.setUnitPrice(product.getPriceProduct()*cart.getQuantity());// lay so luong x voi gia ra so tien  
						kt =false; // cho false;
					}
				}
				if(kt==true)
				{
					CartItem cartItem = new CartItem();
					cartItem.setProduct(product);
					cartItem.setQuantity(1);
					cartItem.setUnitPrice(product.getPriceProduct() *1);
					listCartItem.add(cartItem);
				}
				session.setAttribute("listcartitem", listCartItem);
					
			}
			return "redirect:checkout";
			
		

	}
	
	@RequestMapping("them-gio-hang1")
	public String CartItem(ModelMap map , HttpSession session,@RequestParam("idproduct") int idProduct,@RequestParam("quantity")int quantity) {
		
		
		User us = (User) session.getAttribute("user");
		
				
			List<CartItem> listOb = (List<CartItem>)session.getAttribute("listcartitem");
			if(listOb==null)//ko co gi het  , gio ko co gi ta tao mot gio moi
			{
				Product product = productService.getProductById(idProduct);
				CartItem cartItem = new CartItem();
				cartItem.setProduct(product);
				cartItem.setQuantity(quantity);
				cartItem.setUnitPrice(product.getPriceProduct()*quantity);
				List<CartItem> listCartItem = new ArrayList<CartItem>();
				listCartItem.add(cartItem);
				session.setAttribute("listcartitem", listCartItem);
			}
			else // gio da co hang . 2 truong hop : 1 la hang vua vao  gio vao them cai thu 2 , va hang vao tiep theo chua co trong gio
			{
				boolean kt= true;
				Product product = productService.getProductById(idProduct);
				List<CartItem> listCartItem = listOb;
				for(CartItem  cart : listOb )
				{
					if(cart.getProduct().getIdProduct()==product.getIdProduct()) //kiem tra san pham trong gio hang co giong vs id nguoi khac mua tiep ko
					{
						cart.setQuantity(cart.getQuantity()+quantity); // cap nhat lai so luong
						cart.setUnitPrice(product.getPriceProduct()*cart.getQuantity());// lay so luong x voi gia ra so tien  
						kt =false; // cho false;
					}
				}
				if(kt==true)
				{
					CartItem cartItem = new CartItem();
					cartItem.setProduct(product);
					cartItem.setQuantity(quantity);
					cartItem.setUnitPrice(product.getPriceProduct() *quantity);
					listCartItem.add(cartItem);
				}
				session.setAttribute("listcartitem", listCartItem);
					
			}
			return "redirect:checkout";
			
		

	}
	
	
	@RequestMapping("/checkout")
	public String Checkout(ModelMap map) {
		
		List<Category> listcate = cService.getAllCategory();
		map.addAttribute("list", listcate); // lay ra tat ca cac category
	
		return "checkout";
	}
	@RequestMapping("/closecart")
	public String CloseCart(ModelMap map,@RequestParam("idproduct") int idProduct,HttpSession session) {
		
		Product product = productService.getProductById(idProduct);
		List<CartItem> listCartItem = (List<CartItem>) session.getAttribute("listcartitem");
		
		for(CartItem cart : listCartItem) // tat ca danh sach
		{
			if(cart.getProduct().getIdProduct()==product.getIdProduct()) // neu trong gio hang co product thi ra remove cart tai do
			{
				listCartItem.remove(cart);
				return "redirect:trang-chu";
			}
		}
		
		return "redirect:trang-chu";
	}
	
	
	
}
