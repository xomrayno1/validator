package com.tampro.Exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class ExceptionN {

	
	@ExceptionHandler(NoHandlerFoundException.class)
	public String Exception(Exception e)
	{
		System.out.println(e);
		return "err";
	}

	

}
