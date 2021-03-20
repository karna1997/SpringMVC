package com.jbk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jbk.pojo.User;
import com.jbk.service.UserService;


@Controller
public class UserController {
	@Autowired
	UserService service;

	@RequestMapping("/loginpage")
	public String openLoginpage() {
		System.out.println("Login controller called");
		return "login";// page name login_page.jsp
	}
	@RequestMapping("/register")
	public String registerUser() {
		System.out.println("Register controller called");
		return "Register";// page name login_page.jsp
	}
	
	@RequestMapping("/login")
	public ModelAndView checkLoginCredentials(@ModelAttribute User user){
		
		System.out.println(user.getUserEmail());
		System.out.println(user.getUserPassword());
		
		 boolean result=service.checkLoginCredentials(user);
		ModelAndView mv= new ModelAndView();
		List<User>userlist=service.getUserlist();
		 if(result){
			 mv.addObject("list", userlist);
			 mv.addObject("msg", "Login Successful..!!");
			 mv.setViewName("home");
		 }else{
			 mv.addObject("msg", "Check Your Credentials..!!");
			 mv.setViewName("login");
		 }
		 
		 return  mv;
	}
	@RequestMapping("/delete")
	public ModelAndView deleteUser(@RequestParam("id") int id){
	 boolean result= service.deleteUser(id);
	 
	  ModelAndView mv= new ModelAndView();
		List<User>userlist=service.getUserlist();
		 if(result){
			 mv.addObject("list", userlist);
			 mv.addObject("msg", "Record Deleted Successfully..!!");
			 mv.setViewName("home");
		 }else{
			 mv.addObject("msg", "Check Your Credentials..!!");
			 mv.setViewName("login");
		 }
		 
		 return  mv;

}
	@RequestMapping("/update")
	public ModelAndView getDatabyId(@RequestParam int id){
		ModelAndView mv= new ModelAndView();
		User user=service.getDatabyId(id);
		if(user!=null){
			mv.addObject("user", user);
			 mv.setViewName("update");
			 
		}else{
			List<User>userlist=service.getUserlist();
			 mv.addObject("list", userlist);
			 mv.setViewName("home");
		}
		return mv;
	}
	@RequestMapping("/edit")
	
	public ModelAndView updateUser(@ModelAttribute User user){
		
		ModelAndView mv= new ModelAndView();
		boolean result=service.updateUser(user);
		
		if(result){
			List<User> userlist=service.getUserlist();
			mv.addObject("list",userlist);
			mv.setViewName("home");
		}
		
		return mv;
	}
	@RequestMapping("/save")
	public ModelAndView addUser(@ModelAttribute User user){
	 ModelAndView mv= new ModelAndView();
	boolean result=service.addUser(user);//
	if(result){
		List<User> userlist = service.getUserlist();
		mv.addObject("list", userlist);
		mv.addObject("msg", "Data inserted Successfully..!!");
		mv.setViewName("home");
	}else{
		mv.addObject("msg1", "Something went wrong..!!");
		mv.setViewName("Register");
		
	}
	return mv;
}
}

