package com.tampro.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tampro.Model.Category;
import com.tampro.Model.Product;
import com.tampro.Model.View;
import com.tampro.Service.CategoryService;
import com.tampro.Service.ProductService;
import com.tampro.Service.ViewService;

@Controller
public class ProductController {
	

	@Autowired
	CategoryService cService;
	@Autowired
	ProductService productService;
	@Autowired
	ViewService viewService;
	
	@RequestMapping("/single") // xem mot san pham 
	public String single(ModelMap map,@RequestParam("idProduct")int idProduct,@RequestParam("id")int id) // truyen idproduct va id category
	{
		
		
		Product product = productService.getProductById(idProduct); // lay ra san pham voi tu id san pham
		map.addAttribute("product", product);
		List<Category> listcate = cService.getAllCategory();
		map.addAttribute("list", listcate);   // lay ra tat ca cac category
		List<Product> listProduct1 = productService.getAllProductByIdCategory(id);
		map.addAttribute("listProduct1", listProduct1);  // lay ra danh sach san pham cua  mot category
		
		View getView =viewService.getViewByIdProduct(idProduct); // xem thu co chua

		if(getView==null)//chua co
		{
			View view = new View();
			view.setCountView(1); 
			view.setIdProduct(idProduct);
			viewService.addView(view);	
		}
		else
		{
			View view = getView;
			view.setCountView(view.getCountView()+1);
			viewService.updateViewById(view);
		}
		getView =viewService.getViewByIdProduct(idProduct);
		map.addAttribute("view", getView.getCountView());
		
		List<View> listView = viewService.get4ViewAll(); // 4 id co luot xem nhieu nhat
		//	
		if(!listView.isEmpty())
		{
			List<Product> listproduct = new ArrayList<Product>();
			for(View view : listView)
			{
				Product productP = productService.getProductById(view.getIdProduct());
				listproduct.add(productP);
			}
			map.addAttribute("productview", listproduct);
			
		}
		
		

		return "single";
	}

	
	
	
	
	@RequestMapping("/product") // controller san pham
	public String product(ModelMap map,@RequestParam("pageid") int page)
	{
		List<Category> listcate  = cService.getAllCategory();
		map.addAttribute("list", listcate);// lay ra tat ca cac category
		//List<Product> listProduct = productService.getAllProduct();
		//map.addAttribute("listProduct", listProduct);// lay ra tat ca cac san pham
		
		//1 trang co 8 san pham 
		int countProduct = productService.GetCountProduct();
		int coutPage = 0;
		
		int frist = 0,last = 0;	
		if(countProduct <= 8) // neu so luong be hon 8 hoac = 8 , thi hien thi 1 trang
		{
			frist = 0;     // frist bang 0 , bat dau = 1  lay ra so luong count nghia , la tat ca san pham
			last = countProduct;

			coutPage=1;
		}
		else  // neu nhieu hon 8 san pham 
		{
			frist = (page -1 ) *  8; // trang 1,1-1 * 8 = 0-> 8 bat dau bang 1, trang 2 , 2-1*8 = 8->8 , bat dau = 9 lay ra 8 hang
			last = 8;
			int chiaduoc = countProduct / 8 ; // 9 chia 8  =1 
			int chiadu = countProduct % 8;
			coutPage = chiaduoc;
			if(chiadu>0)
			{
				++coutPage;
			}
		}
		List<Product> listProductNav = productService.getProductNav(frist, last);
		
		 map.addAttribute("listProduct", listProductNav);
		 //tinh xem co bao nhiu trang 
		 map.addAttribute("coutPage", coutPage);
		 
		
		return "product";
	}
	
	@RequestMapping("/tim-kiem") // controller san pham
	public String Search(ModelMap map,@RequestParam("nameproduct") String nameproduct)
	{
		List<Category> listcate  = cService.getAllCategory();
		map.addAttribute("list", listcate);// lay ra tat ca cac category
		
		List<Product> listProduct = productService.getAllProductBySearch(nameproduct);
		map.addAttribute("listProduct", listProduct);
		
		return "product";
	}
	

}
