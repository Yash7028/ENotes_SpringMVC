package com.becoder.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.becoder.dao.UserDao;
import com.becoder.entity.User;

@Controller
public class HomeController {
	@Autowired
	private UserDao userDao;

	@RequestMapping(path = "/home")
	public String home() {
		return "home";
	}
	
	@RequestMapping(path = "/login")
	public String login() {
		return "login";
	}
	@RequestMapping(path = "/register")
	public String register() {
		return "register";
	}
	
	
	@RequestMapping(path = "/registerUser", method = RequestMethod.POST)
	public String registerUser(@ModelAttribute User user,HttpSession session) {
		 System.out.println("Starting user registration");
	        userDao.saveUser(user);
	        System.out.println("User registration done");
	        System.out.println(user); // This should print the user details
	        session.setAttribute("msg", "Registered successfully!");
		return "redirect:/register";
	}
	
	@RequestMapping(path = "/loginUser" , method = RequestMethod.POST)
	public String loginUser(@RequestParam("email") String em,@RequestParam("password") String pwd, HttpSession session) {
		User user = userDao.login(em, pwd);
		if(user != null ) {
		session.setAttribute("userObj", user);
		return "redirect:/home";
		}else {
			session.setAttribute("msg", "password or email invalid!");
			return "redirect:/login";
		}
	}
	
	
}
