package com.ExpenseApp.Project.Service;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;

import com.ExpenseApp.Project.pojo.User;

public interface IUserService
{

	public String registerUser(User user);

	public User loginUser(String email, String password);
	
	public List<User> usersList();

	


}
