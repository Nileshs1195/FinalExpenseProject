package com.ExpenseApp.Project.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.ExpenseApp.Project.pojo.Expense;

@Repository
@Transactional
public class ExpenseDaoImpl implements IExpenseDao
{
	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public String addExpense(Expense expense)
	{	
		entityManager.persist(expense);
		return "Expense Added Successfully";
	}
	

	@Override
	public Expense getExpense(int expenseid) {
		String jpql= "select e from Expense e where e.expense_id=:eid";
		Expense expense=entityManager.createQuery(jpql,Expense.class).setParameter("eid",expenseid).getSingleResult();
		
		return expense;
	}

	@Override
	public List<Expense> getExpenseList(Expense expense)
	{
		String jpql="select e from Expense e ";
		return entityManager.createQuery(jpql,Expense.class).getResultList();
	}
	
	@Override
	public List<Object> getMonthlyExpense() 
	{
		
		//String jpql="select e.userid,e.expense_amount,e.expensedate from expense e ";
		String jpql="select e.expense_amount from Expense e ";
		return entityManager.createQuery(jpql,Object.class).getResultList();
	
	}

	
	
	
public List<Object> getUsersMonthlyExpense(Integer id)
{
				String jpql="select e.expense_amount from Expense e where userid=:cid";
				//String jpql="select userid,e.expense_amount from Expense e where userid=:cid group by userid";
				return entityManager.createQuery(jpql,Object.class).setParameter("cid",id).getResultList();

				
	/*			String jpql="select a.userid,a.expense_id, a.expense_amount from expense a, expense b"   
				+"where a.userid=b.userid and a.userid=:cid group by expense_id";

				select a.userid,a.expense_id, a.expense_amount from expense a, expense b   
				where a.userid=b.userid and a.userid=101 group by expense_id;
	*/
}
	
	
	
	
	
	
	
	
//	@Override
//	public List<Object> getMonthlyExpense() {
//		String jpql="select sum(e.expense_amount) from Expense e group by userid";
//		return entityManager.createQuery(jpql).getResultList();
//	
//	}	
}