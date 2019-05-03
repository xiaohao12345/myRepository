package com.gc.mapper;

import java.util.List;

import com.gc.pojo.Pic;

public interface PicMapper {
	int addPic(Pic pic);
	List<Pic> selAll();
}
