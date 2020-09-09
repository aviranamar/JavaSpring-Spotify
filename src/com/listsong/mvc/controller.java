package com.listsong.mvc;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes("user")
public class controller {
	
	@Autowired
	manager managero;

	tempuser tempUser = new tempuser();
	
	@RequestMapping("/")
	public String startPage(Model model) {
		// Create a user object
		user User = new user();

		// Add the user object as a model attribute
		model.addAttribute("user", User);
		return "signup";
	}
	
	@RequestMapping("/signup")
	public String mainPage(Model model) {
		// Create a user object
		user User = new user();

		// Add the user object as a model attribute
		model.addAttribute("user", User);
		return "signup";
	}
	
	@RequestMapping("/checkLogin")
	public String check(@ModelAttribute("user") user User,SessionStatus sessionStatus) {
		tempUser.copyme(User);
		if(User.getUserName().equals("")
				||User.getLastName().equals("")
				||User.getPassword().equals("")) {
			return "signup";
		}
		System.out.println(User);
		return "changeDetail";
	}
	
	@RequestMapping("/changeDetail")
	public String changedetailPage(@ModelAttribute("user") user User,SessionStatus sessionStatus) {
		if(User.getUserName().equals("")
				||User.getLastName().equals("")
				||User.getPassword().equals("")) {
			User.copyme(tempUser);
		}
			else {
				tempUser.copyme(User);
			}
		System.out.println(User);
		return "changeDetail";
	}
	
	@RequestMapping("/songslist")
	public String songslist(HttpServletRequest request) {
		managero.songlist(request);		 
		return "songslist";
	}
	
	@RequestMapping("/mysongs")
	public String mysongs(HttpServletRequest request) {
		managero.mysongs(request);
		return "mysongs";
	}
	
	
	@RequestMapping("/mysongspre")
	public String mysongsPre(HttpServletRequest request) {
		managero.mysongspre(request);
		return "mysongs";
	}
	
	@RequestMapping("/exit")
	public String ExitPage(SessionStatus sessionStatus) {
		sessionStatus.setComplete();
		return "exit";
	}
}
