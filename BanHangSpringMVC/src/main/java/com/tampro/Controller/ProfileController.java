package com.tampro.Controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tampro.Model.Category;
import com.tampro.Model.Profile;
import com.tampro.Service.CategoryService;
import com.tampro.Service.ProductService;
import com.tampro.Service.ProfileService;
import com.tampro.Service.UserService;

@Controller
public class ProfileController {

	@Autowired
	CategoryService cService;
	
	@Autowired
	ProductService productService;
	
	@Autowired
	UserService userService;
	@Autowired
	ProfileService profileService;
	
	@RequestMapping("/them-thong-tin-ca-nhan")
	public String profile(ModelMap map,HttpSession session)
	{
		if(session.getAttribute("user")==null)
		{
			return "redirect:login";
		}
		else
		{
			List<Category> listcate  = cService.getAllCategory();
			map.addAttribute("list", listcate);// lay ra tat ca cac category
			map.addAttribute("profile", new Profile());
			return "addprofile";
		}
	}
	@RequestMapping("/them-thong-tin")
	public String profile(ModelMap map,HttpSession session,@ModelAttribute("profile")Profile pf)
	{
		if(session.getAttribute("user")==null)
		{
			return "redirect:login";
		}
		else
		{
			profileService.addProfile(pf);
			
			return "redirect:trang-chu";
		}
	}
	
	@RequestMapping("/thong-tin-chi-tiet")
	public String profile(ModelMap map,HttpSession session,@RequestParam("iduser") int iduser)
	{
		if(session.getAttribute("user")==null)
		{
			return "redirect:login";
		}
		else
		{
			List<Category> listcate  = cService.getAllCategory();
			map.addAttribute("list", listcate);// lay ra tat ca cac category
			
			Profile profile = profileService.getProfileByIdUser(iduser);
			map.addAttribute("profile", profile);
			
			return "profile";
		}
	}
	
	@RequestMapping("/sua-thong-tin")
	public String updateprofile(ModelMap map,HttpSession session,@RequestParam("idprofile")int idProfile)
	{
		if(session.getAttribute("user")==null)
		{
			return "redirect:login";
		}
		else
		{
			Profile profile = profileService.getProfile(idProfile);
			map.addAttribute("profile", profile);
			
			return "updateprofile";
		}
	}
	@RequestMapping("/update")
	public String updateprofile(ModelMap map,HttpSession session,@ModelAttribute("profile")Profile pf)
	{
		if(session.getAttribute("user")==null)
		{
			return "redirect:login";
		}
		else
		{
			profileService.updateProfile(pf);
			List<Category> listcate  = cService.getAllCategory();
			map.addAttribute("list", listcate);// lay ra tat ca cac category
			
			Profile profile = profileService.getProfileByIdUser(pf.getIdUser());
			map.addAttribute("profile", profile);
			
			return "profile";
		}
	}
	
}
