package com.gc.service;

import java.util.List;

import com.gc.pojo.Pic;

public interface PicService {
	int addPic(Pic pic);
	List<Pic> show();
}
