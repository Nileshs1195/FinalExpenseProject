package com.ExpenseApp.Project.Service;

import java.util.List;
import java.util.Optional;

import com.ExpenseApp.Project.dto.CategoryDto;
import com.ExpenseApp.Project.pojo.Category;

public interface ICategoryService
{
	
	public String addCategory(CategoryDto categorydto);

	public List<Category> getCategoryList();

	public Optional<Category> getCategoryById(int cid);

	public Optional<Category> getCategoryByIdAndName(Integer id, String name);

	
}
