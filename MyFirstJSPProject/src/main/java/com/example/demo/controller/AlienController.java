package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.Alien;
import com.example.demo.repository.AlienRepo;

@Controller
public class AlienController {
	
	@Autowired
	AlienRepo alienRepo;
	
	@RequestMapping("/")
	public String home() {
		return "home.jsp";
	}
	
	@RequestMapping("/addAlien")
	public String save(Alien alien) {
		
		alienRepo.save(alien);
		return "home.jsp";
	}
	
	@RequestMapping("/getAlien/{id}")
	@ResponseBody
	public Optional<Alien> getAlien(@PathVariable int id) {
		
		
		return alienRepo.findById(id);
	}
	
	@RequestMapping("/getAliens")
	@ResponseBody
	public List<Alien> getAliens() {
		
		
		return alienRepo.findAll();
	}

}
