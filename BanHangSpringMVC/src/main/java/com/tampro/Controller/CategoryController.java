package com.tampro.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tampro.Model.Category;
import com.tampro.Model.Product;
import com.tampro.Service.CategoryService;
import com.tampro.Service.ProductService;

@Controller
public class CategoryController {

	@Autowired
	CategoryService cService;
	@Autowired
	ProductService productService;
	

	
	@RequestMapping("getCategory")
	public String getCategory(ModelMap map,@RequestParam("id")int idCategory,@RequestParam("idtype")int typeProduct) // id category va kieu product 
	{
		List<Category> listcate = cService.getAllCategory();
		map.addAttribute("list", listcate); // lay ra tat ca cac category
		
		List<Product> listProduct = productService.getAllProductByIdCategoryAndTypeProduct(idCategory, typeProduct);
		map.addAttribute("listProduct", listProduct); // lay ra tat ca san pham cua mot category va kieu product
		
		List<Product> listProduct1 = productService.getAllProductByIdCategory(idCategory);
		map.addAttribute("listProduct1", listProduct1); // lay ra tat ca san pham cua mot category
		
		Category ct = cService.getCategory(idCategory);
		map.addAttribute("namecate", ct); // lay ra  category bang id category
		

		
		return "product"; // tra ve trang san pham
	}
	
	
	@RequestMapping("getCategory1")  // khac nhau o cho cai tren co tryen vao typeproduct va xu li no , cai duoi chi 1
	public String getCategory1(ModelMap map,@RequestParam("id")int idCategory) // id category
	{
		List<Category> listcate = cService.getAllCategory();
		map.addAttribute("list", listcate); // lay ra tat ca cac category
		
		List<Product> listProduct1 = productService.getAllProductByIdCategory(idCategory);
		map.addAttribute("listProduct", listProduct1);// lay ra tat ca san pham cua mot category
		
		Category ct = cService.getCategory(idCategory);
		map.addAttribute("namecate", ct); // lay ra  category bang id category
		
		
		
		
		return "product";// tra ve trang san pham
	}
	
}
