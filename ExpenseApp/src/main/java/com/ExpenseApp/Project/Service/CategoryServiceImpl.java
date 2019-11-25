package com.ExpenseApp.Project.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.ExpenseApp.Project.CustomException.CategoryNotFoundException;
import com.ExpenseApp.Project.Dao.ICategoryDao;
import com.ExpenseApp.Project.Repository.CategoryRepository;
import com.ExpenseApp.Project.dto.CategoryDto;
import com.ExpenseApp.Project.pojo.Category;

@Service
public class CategoryServiceImpl implements ICategoryService
{
	@Autowired
	private CategoryRepository categoryRepository;
	
	public String addCategory(CategoryDto categorydto)
	{	
		Category cmodel=new Category();
		cmodel.setCategoryId(categorydto.getCategoryId());
		cmodel.setCategoryName(categorydto.getCategoryName());
		cmodel.setCategoryDesc(categorydto.getCategoryDesc());
		
		String categoryName=cmodel.getCategoryName();
		categoryRepository.save(cmodel);
		 return categoryName+ " Category Added in Stock";
	}
	
	public List<Category> getCategoryList() 
	{	
		return categoryRepository.findAll();
	}
	
	public Optional<Category> getCategoryById(int cid)
	{
		Optional<Category> categoryData=categoryRepository.findByCategoryId(cid);
		
		return categoryData;
	}
	
	public Optional<Category> getCategoryByIdAndName(Integer id, String name)
	{
		return categoryRepository.findByCategoryIdAndCategoryName(id,name);
	}
}
