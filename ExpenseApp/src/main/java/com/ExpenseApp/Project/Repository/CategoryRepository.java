package com.ExpenseApp.Project.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ExpenseApp.Project.pojo.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>
{
	Optional<Category> findByCategoryIdAndCategoryName(@Param("id") Integer id,@Param("name") String name);

	Optional<Category> findByCategoryId(@Param("cid") Integer cid);

}
