package com.ExpenseApp.Project.Controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ExpenseApp.Project.CustomException.CategoryNotFoundException;
import com.ExpenseApp.Project.Service.CategoryServiceImpl;
import com.ExpenseApp.Project.Service.ICategoryService;
import com.ExpenseApp.Project.dto.CategoryDto;
import com.ExpenseApp.Project.pojo.Category;

@RestController
@RequestMapping("/category")
public class CategoryController

{	
	@Autowired
	ICategoryService categoryService;
	
	
	/**
	 * Method used to add Category 
	 * @param Category Object
	 * @return status string
	 */
	@PostMapping("/addcategory")
	public ResponseEntity<String> addCategory(@Valid @RequestBody CategoryDto categorydto)
	{	
		return new ResponseEntity<String>(categoryService.addCategory(categorydto),HttpStatus.OK);
	} 
	
	/**
	 * Method used get Category List 
	 * @param No parameter
	 * @return Category List 
	 */	
	@GetMapping("/categorylist")
	public ResponseEntity<List<Category>> getCategoryList()
	{
		return new ResponseEntity<List<Category>>(categoryService.getCategoryList(),HttpStatus.OK);
	}
	
	
	/**
	 * Method used get specific Category 
	 * @param Integer id
	 * @return Category Details if id is valid or returns and Exception
	 */	
	@GetMapping("/categorylist/{id}")
	public Optional<Category> getCategoryById(@PathVariable Integer id)
	{
		try
		{
		Optional<Category> categoryData=categoryService.getCategoryById(id);
		if(categoryData==null)
		{
			throw new CategoryNotFoundException("Category Not In Stock");
		}
		return categoryData;
		}
		
		catch (Exception e) 
		{
			throw new CategoryNotFoundException("Category Not Found");
		}
	}
	
	
	/**
	 * Method used to get CategoryType 
	 * @param categoryId and categoryName
	 * @return Category Details (Category Object)
	 */
	@PostMapping("/categoryType")
	public Optional<Category> getCategoryByIdAndName(@RequestBody Category category)
	{
		Integer id=category.getCategoryId();
		String name=category.getCategoryName();
		return categoryService.getCategoryByIdAndName(id,name);
	}
}