package com.ExpenseApp.Project.pojo;

import java.util.*;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Category")
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int categoryId;
	private String categoryName;
	private String categoryDesc;
	
	 						
	/**
	 * @OneToMany 
	 * Mapping from one category to Multiple Expenses
	 */
	@OneToMany(mappedBy = "category",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Expense> expense;
	public List<Expense> getExpense()
	{
		return expense;
	}
	public void setExpense(List<Expense> expense) {
		this.expense = expense;
	}
	
//	@ManyToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "userid")
//	@JsonIgnore
//	private User user;
//	
//	public User getUser() {
//		return user;
//	}
//	public void setUser(User user) {
//		this.user = user;
//	}
	public Category()
	{
		super();
	}
	
	public Category(int categoryId, String categoryName, String categoryDesc)
	{
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.categoryDesc = categoryDesc;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getCategoryDesc() {
		return categoryDesc;
	}
	public void setCategoryDesc(String categoryDesc) {
		this.categoryDesc = categoryDesc;
	}
	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", categoryName=" + categoryName + ", categoryDesc="
				+ categoryDesc + "]";
	}
	
	
	
}
