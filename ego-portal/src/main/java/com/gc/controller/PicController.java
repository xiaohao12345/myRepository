package com.gc.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gc.service.PicService;

@Controller
public class PicController {
	@Resource
	private PicService picServiceImpl;
 	@RequestMapping("/")
	public String show(HttpServletRequest req){
 		req.setAttribute("list", picServiceImpl.show());
		return "main.jsp";
	}
}
