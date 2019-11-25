package com.ExpenseApp.Project.CustomException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ExpenseApp.Project.pojo.Category;

@ControllerAdvice
public class GlobalExceptionController 
{
	@ExceptionHandler(value=CategoryNotFoundException.class)
	public ResponseEntity<Object> categoryException(CategoryNotFoundException categoryException)
	{
		return new ResponseEntity<Object>("Category Not Found", HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(ExpenseNotFoundException.class)
	public ResponseEntity<Object> expenseException(ExpenseNotFoundException expenseException)
	{
		return new ResponseEntity<Object>("Expense not found, not added in stock",HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<Object> userLoginException(UserNotFoundException userLoginException)
	{
		return new ResponseEntity<Object> ("Invalid Credentials",HttpStatus.NOT_FOUND);
	}
}

