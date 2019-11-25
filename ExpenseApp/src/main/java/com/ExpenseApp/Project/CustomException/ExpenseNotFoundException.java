package com.ExpenseApp.Project.CustomException;

public class ExpenseNotFoundException extends RuntimeException
{
	public ExpenseNotFoundException(String errorMessage)
	{
		super(errorMessage);
	}
}
