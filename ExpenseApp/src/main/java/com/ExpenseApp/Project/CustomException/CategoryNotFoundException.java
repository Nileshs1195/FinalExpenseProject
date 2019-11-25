package com.ExpenseApp.Project.CustomException;

public class CategoryNotFoundException extends RuntimeException
{
	private static final long serialVersionUID = 1L;
	public CategoryNotFoundException(String errorMessage)
	{
		super(errorMessage);
	}
	
}
