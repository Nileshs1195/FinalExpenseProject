package com.ExpenseApp.Project.pojo;

import java.util.*;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "expense")
public class Expense 
{	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int expense_id;
	private String expense_type;
	private double expense_amount;	
	
	@Temporal(TemporalType.DATE)
	private Date expensedate;
	
	/**
	 * @ManyToOne 
	 * Mapping from Multiple Expenses to one user 
	 */
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "userid")
	@JsonIgnore
	private User user;
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	/**
	 * @ManyToOne  
	 * Mapping from Multiple Expenses to one category 
	 * 
	 */
	@ManyToOne(cascade = CascadeType.ALL) 
	@JoinColumn(name = "categoryId")
	@JsonIgnore
	private Category category;
	public int getExpense_id() {
		return expense_id;
	}

	public void setExpense_id(int expense_id) {
		this.expense_id = expense_id;
	}

	public String getExpense_type() {
		return expense_type;
	}

	public void setExpense_type(String expense_type) {
		this.expense_type = expense_type;
	}

	public double getExpense_amount() {
		return expense_amount;
	}

	public void setExpense_amount(double expense_amount) {
		this.expense_amount = expense_amount;
	}
	@Temporal(TemporalType.DATE)
	public Date getExpensedate() {
		return expensedate;
	}

	public void setExpensedate(Date expensedate) {
		this.expensedate = expensedate;
	}

	public Expense(int expense_id, String expense_type, double expense_amount, Date expensedate) {
		super();
		this.expense_id = expense_id;
		this.expense_type = expense_type;
		this.expense_amount = expense_amount;
		this.expensedate = expensedate;
	}

	public Expense() {
		super();
	}

	@Override
	public String toString() {
		return "Expense [expense_id=" + expense_id + ", expense_type=" + expense_type + ", expense_amount="
				+ expense_amount + ", expensedate=" + expensedate + "]";
	}	
	
}
	