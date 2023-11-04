package com.todoapp.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SayHelloController {
	
	
//	@RequestMapping("/say-hello")
//	@ResponseBody
//	public String sayHello() {
//		StringBuffer sb = new StringBuffer();
//		sb.append("<html>");
//		sb.append("<head>");
//		sb.append("<title> My First HTML Page </title>");
//		sb.append("</head>");
//		sb.append("<body> My First HTML page with body </body>");
//		sb.append("</html>");
//		
//		return sb.toString();
//	}
	
	
	@RequestMapping("/say-hello")
	public String sayHello() {
		return "SayHello";
	}
}