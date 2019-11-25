package com.ExpenseApp.Project.Dao;

import java.util.List;

import com.ExpenseApp.Project.pojo.Expense;

public interface IExpenseDao
{
	String addExpense(Expense expense);

	Expense getExpense(int expenseid);

	List<Expense> getExpenseList(Expense expense);

	List<Object> getMonthlyExpense();

	List<Object> getUsersMonthlyExpense(Integer id);
	
}
