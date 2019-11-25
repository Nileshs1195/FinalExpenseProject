              package com.ExpenseApp.Project.Dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ExpenseApp.Project.Repository.CategoryRepository;
import com.ExpenseApp.Project.pojo.Category;

@Repository
@Transactional
public class CategoryDaoImpl implements ICategoryDao
{
	@PersistenceContext
	EntityManager entityManager;
	
	@Autowired
	CategoryRepository categoryRepository;

	/**
	 * Here Category Dao layer does not contain any method.
	 * All methods are replaced by Query Methods of JPA Respository
	 * Custom methods are in CategoryRepository      
	 */
	
	/*	 
	 @Override
	public Category getCategoryById(int cid)
	{
		String jpql="Select c from Category c where c.categoryId=:id";
		//Category category=entityManager.createQuery(jpql,Category.class).setParameter("id", cid)getSingleResult();
		Category category=entityManager.createQuery(jpql,Category.class).setParameter("id", cid).getSingleResult();
		
		return category;
	}
	*/
}