package com.gc.controller;

import java.io.File;
import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.gc.pojo.Pic;
import com.gc.service.PicService;

@Controller
public class PicControler {
	@Resource
	private PicService picServiceImpl;
	
	@RequestMapping("addPic")
	public String addPic(MultipartFile mf,HttpServletRequest req){
		try {
			FileUtils.copyInputStreamToFile(mf.getInputStream(),new File(req.getServletContext().getRealPath("images"),mf.getOriginalFilename()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Pic pic = new Pic();
		pic.setPath(mf.getOriginalFilename());
		int index = picServiceImpl.addPic(pic);
		if(index>0){
			return "redirect:/show";
		}else{
			return "/addPic.jsp";
		}
	}
	@RequestMapping("show")
	public String show(HttpServletRequest req){
		req.setAttribute("list", picServiceImpl.show());
		return "show.jsp";
	}
}
