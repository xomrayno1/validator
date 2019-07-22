package com.tampro.Validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.tampro.Model.User;

@Component
public class UserValidator implements Validator{ // chon cai cua spring fame

	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return User.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors,boolean kt) {
		User us = (User) target;
		if(kt==true)
		{
			errors.rejectValue("password", "username.err.password.err");
		}
		
		
		
	}

	public void validate1(Object target, Errors errors,boolean kt) {
		// TODO Auto-generated method stub
		User us = (User) target;
		if(us.getUsername().length() > 0 && us.getPassword().length() >0) // chuoi co ki tu 
		{
			if(kt==true)
			{
				errors.rejectValue("password", "username.true");
			}
		}
		if(us.getUsername().length()==0|| us.getPassword().length()==0) // ko co ki tu 
		{
			errors.rejectValue("password", "username.err");
		}
		
	}
	
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		
	}
	

}
