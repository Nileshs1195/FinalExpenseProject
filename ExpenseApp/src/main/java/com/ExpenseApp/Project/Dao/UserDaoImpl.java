package com.ExpenseApp.Project.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.ExpenseApp.Project.pojo.User;


@Repository
@Transactional
public class UserDaoImpl implements IUserDao
{	
	@PersistenceContext
	private EntityManager entitytManager;
	
	
	public String registerUser(User user)
	{
		entitytManager.persist(user);
		return "Successfully Registered";
	}	
	
	/**
	 * All Methods Queries written using Criteria API
	 */
	
	@Override
	public User loginUser(String userEmailId, String userPassword)
	{
		CriteriaBuilder cb=entitytManager.getCriteriaBuilder();
		CriteriaQuery<User> cq=cb.createQuery(User.class);
		Root<User> user=cq.from(User.class);
		
		Predicate emailPredicate=cb.equal(user.get("email"),userEmailId);
		Predicate passwordPredicate=cb.like(user.get("password"),userPassword);
		
		cq.where(emailPredicate,passwordPredicate);
		TypedQuery<User> query=entitytManager.createQuery(cq);		
		return query.getSingleResult();
	}

	@Override
	public List<User> usersList()
	{
		CriteriaBuilder cb=entitytManager.getCriteriaBuilder();
		CriteriaQuery<User> cq=cb.createQuery(User.class);
		Root<User> users=cq.from(User.class);
		CriteriaQuery<User> select=cq.select(users);
		TypedQuery<User> tq=entitytManager.createQuery(select);
		List<User> users_List=tq.getResultList();
		return users_List;
	}

	}
	
	
/* String jpql query
	@Override
	public User loginUser(String email, String password)
	{
		String jpql="Select u from User u where u.email=:em and u.password=:pwd";
		User user=entitytManager.createQuery(jpql,User.class).setParameter("em", email).setParameter("pwd", password).getSingleResult();
		return user;
	}
*/
