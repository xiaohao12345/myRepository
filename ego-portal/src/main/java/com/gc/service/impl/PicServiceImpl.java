package com.gc.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gc.mapper.PicMapper;
import com.gc.pojo.Pic;
import com.gc.service.PicService;
@Service
public class PicServiceImpl implements PicService{
	@Resource
	private PicMapper picMapper;
	@Override
	public List<Pic> show() {
		return picMapper.selAll();
	}

}
