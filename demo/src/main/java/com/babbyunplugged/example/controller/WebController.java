package com.babbyunplugged.example.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.babbyunplugged.example.entity.Greeting;
import com.babbyunplugged.example.entity.User;

@Controller
public class WebController {

	/*
	 * Simple method returning string as response
	 */
	@GetMapping("/hello")
	@ResponseBody
	public String test() {
		return "hello";
	}
	
	/*
	 * Using path variable
	 */
	@GetMapping("/hello/{name}")
	@ResponseBody
	public String usingPathVariable(@PathVariable("name") String name) {
		return "hello,"+name;
	}
	
	/*
	 * Using path variable as a map Same we can apply on @RequestParam
	 * http://localhost:8080/hello/rahul/13
	 */
	@GetMapping("/hello/{name}/{age}")
	@ResponseBody
	public String getPathVariableAsMap(@PathVariable Map<String,String> map) {
		return "hello,"+map.get("name")+" - "+map.get("age");
	}
	
	/*method accepting a request parameter and passing parameter to template greeting.html
	 * http://localhost:8080/greeting?name=prashant
	 * http://localhost:8080/greeting
	 */
	@GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
		List<User> users = Arrays.asList(new User(name,"prashantgenial@gmail.com","INDIA"),new User("Amit Gupta","amit.gupta@gmail.com","USA"),new User("Rahul Gupta","rahulg@gmail.com","INDIA"));
        model.addAttribute("name", name);
        model.addAttribute("users", users);
        return "greeting";
    }
	
	//Displaying form
	 @GetMapping("/greeting1")
	    public String greetingForm(Model model) {
	        model.addAttribute("greeting", new Greeting());
	        return "greeting1";
	    }

	 //Handling submittion of form
	    @PostMapping("/greeting1")
	    public String greetingSubmit(@ModelAttribute Greeting greeting) {
	        return "result";
	    }
}
