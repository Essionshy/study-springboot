package com.tingyu.study.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AccountController {
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String index() {
		return "index";
	}
	
	
	/*
	 * @RequestMapping(value="/login",method=RequestMethod.GET) public String
	 * login() { return "login"; }
	 */

	@ResponseBody
	@RequestMapping(value="/level1/{id}",method=RequestMethod.GET)
	public String  level1(@PathVariable("id")Integer id) {
		String reuslt=null;
		switch(id) {
			case 1:
				reuslt= "罗汉拳";
				break;
			case 2: 
				reuslt= "武当剑法";
				break;
			case 3:
				reuslt= "全真剑法";
				break;
			default:
				break;
		}
		return reuslt;		
	}
	@ResponseBody
	@RequestMapping(value="/level2/{id}",method=RequestMethod.GET)
	public String  level2(@PathVariable("id")Integer id) {
		String reuslt=null;
		switch(id) {
			case 1:
				reuslt= "太极拳";
				break;
			case 2: 
				reuslt= "七伤拳";
				break;
			case 3:
				reuslt= "梯云纵";
				break;
			default:
				break;
		}
		return reuslt;		
	}

	@ResponseBody
	@RequestMapping(value="/level3/{id}",method=RequestMethod.GET)
	public String  level3(@PathVariable("id")Integer id) {
		String reuslt=null;
		switch(id) {
			case 1:
				reuslt= "葵花宝典";
				break;
			case 2: 
				reuslt= "龟派气功";
				break;
			case 3:
				reuslt= "独孤九剑";
				break;
			default:
				break;
		}
		return reuslt;		
	}
	
}
