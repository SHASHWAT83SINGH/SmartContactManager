package com.smart.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.smart.dao.UserRepository;
import com.smart.entities.User;
import com.smart.helper.Message;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class HomeController {
	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping("/")
	public String home(Model  m)
	{
		m.addAttribute("title","Home-Smart contact manager");
		return "home";
	}
	@RequestMapping("/about")
	public String about(Model  m)
	{
		m.addAttribute("title","About-Smart contact manager");
		return "about";
	}
	@RequestMapping("/signup")
	public String signup( @ModelAttribute User user, Model  m)
	{
		m.addAttribute("title","About-Smart contact manager");
	//	m.addAttribute("user",new User()); hamne modelattribute ka use kar liya hai isi liye isse comment kar diya hai...
		System.out.println(user);
		return "signup";
	}
	
	//Handler for registering user
	@PostMapping("/do_register")
	public String registerUser (@Valid @ModelAttribute("user") User user,BindingResult result1,@RequestParam(value="agreement", defaultValue="false")boolean agreement, Model m,HttpSession session)
	
	{
		try {
			if(!agreement)
			{
				System.out.println("you have not agreed the terms and condition");
				throw new Exception("you have not agreed the terms and condition");
			}
			if(result1.hasErrors())
			{
				System.out.println("ERROR" +result1.toString());
				m.addAttribute("user",user);
				return "signup";
			}
			
			user.setRole("ROLE_USER");
			user.setEnabled(true);
		
			
			System.out.println("Agreement"+agreement);
			System.out.println("USER"+user);
			User result = this.userRepository.save(user);
			
			
			m.addAttribute("user",new User());
			session.setAttribute("message", new Message("Successfully Registerd", "alert-sucess"));
		
		return "signup";
			
		}catch(Exception e)
		{
		e.printStackTrace();
		m.addAttribute("user",user);
		session.setAttribute("message", new Message("Something went Wrong!!"+e.getMessage(), "alert-danger"));
		}
		return "signup";
	}

}
