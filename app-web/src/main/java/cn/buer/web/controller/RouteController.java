package cn.buer.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RouteController {
	@RequestMapping("index")
	public String index(){
		
		
		return "index";
	}
	@RequestMapping("home")
	public String home(){
		return "home";
	}
	@RequestMapping("add")
	public String add(){
		return "add";
	}
	@RequestMapping("list")
	public String list(){
		return "list";
	}
}
