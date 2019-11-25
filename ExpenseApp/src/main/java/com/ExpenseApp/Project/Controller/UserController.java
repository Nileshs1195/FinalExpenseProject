package com.ExpenseApp.Project.Controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ExpenseApp.Project.CustomException.UserNotFoundException;
import com.ExpenseApp.Project.Service.IUserService;
import com.ExpenseApp.Project.pojo.User;

@RestController
@RequestMapping("/user")
public class UserController
{	
	@Autowired
	private IUserService userService;
	
	/**
	 * Method used for user registration
	 * @param user details (user object)
	 * @return status string
	 */
	@PostMapping("/register")
	public ResponseEntity<String> registerUser(@RequestBody User user)
	{
		try 
		{		
		if(user.getPassword().equals(user.getConfirmPassword()))
		{
			return new ResponseEntity<String>(userService.registerUser(user),HttpStatus.OK);
		}
		return new ResponseEntity<String>("password dosen't match",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		catch(Exception e)
		{
			return new ResponseEntity<String>("Registeration failed", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/**
	 * Method used for login user
	 * @param String emailId and password
	 * @return User Details (Entire Object)
	 */
	@GetMapping("/loginuser")
	public User loginUser(@RequestBody User user)
	{
		String email=user.getEmail();
		String password=user.getPassword();
		try
		{
		User userData=userService.loginUser(email,password);
		return userData;
		}
		catch(Exception e)
		{
			throw new UserNotFoundException("");
		}
	}
	
	/**
	 * Method used to get registered users list
	 * @param No any parameter provided
	 * @return List of registered Users
	 */
	
	@GetMapping("/usersList")
	public List<User> usersList()
	{
		return userService.usersList();
	}
	
}
