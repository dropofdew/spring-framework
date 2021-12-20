package com.fia.formula1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class UserController {
	@RequestMapping("/user")
	@ResponseBody
	public Map<String, Object> query() {
		Map<String, Object> map = new HashMap<>();
		map.put("key", "value");
		System.out.println("UserController querying......");
		return map;
	}
}
