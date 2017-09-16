package com.hsq.service;

import java.util.List;

import com.hsq.bean.BaseDict;

public interface BaseDictService {
	public List<BaseDict> selectBaseDictByCode(String code); 
}
