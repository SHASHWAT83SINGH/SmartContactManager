package com.smart.controller;


import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.smart.dao.UserRepository;
import com.smart.entities.Contact;
import com.smart.entities.User;


@Controller
@RequestMapping("/user")

public class UserController {
	@Autowired
	private UserRepository userRepository;
	@ModelAttribute
	public void addcommondata(Model m,Principal principal)
	{
		String UserName =principal.getName();
		System.out.println("USERNAME"  +UserName);
		User user = userRepository.getUserByUserName(UserName);
		System.out.println("USER"  +  user);
		m.addAttribute("user",user);
	}
	
	@RequestMapping("/index")
	public String DashBoard(Model model,Principal principal)
	{ 
		return "normal/user_dashboard";
	}
	//OPEN ADD FORM HANDLER
	@GetMapping("/add-contact")
	public String  openAddContactForm(Model model)
	{
		model.addAttribute("title","add contact");
		model.addAttribute("contact", new Contact());
		return "normal/add_contact_form";
	}
	
	//Processing add Contact Form
	@PostMapping("/process-contact")
	public String processContact(@ModelAttribute Contact contact,Principal principal)
	{
		String name = principal.getName();
		User user =this.userRepository.getUserByUserName(name);
		user.getContacts().add(contact);
		this.userRepository.save(user);
		
		System.out.println("DATA"+contact);
		System.out.println("Added to the database");
		return "normal/add_contact_form";
	}

}
