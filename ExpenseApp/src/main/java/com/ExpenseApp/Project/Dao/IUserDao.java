package com.ExpenseApp.Project.Dao;


import java.util.List;

import com.ExpenseApp.Project.pojo.User;


public interface IUserDao
{

	String registerUser(User user);

	User loginUser(String email, String password);

	List<User> usersList();


}
