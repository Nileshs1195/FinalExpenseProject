package com.ExpenseApp.Project.Service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.ExpenseApp.Project.pojo.Expense;

public interface IExpenseService
{
	public String addExpense(Expense expense);

	public Expense getExpense(int expenseid);

	public List<Expense> getExpenseList(Expense expense);

	public List<Object> getMonthlyExpense();

	public List<Object> getUsersMonthlyExpense(Integer id);

	
}
