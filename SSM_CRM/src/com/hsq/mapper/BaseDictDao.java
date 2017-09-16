package com.hsq.mapper;

import java.util.List;

import com.hsq.bean.BaseDict;

public interface BaseDictDao {
	public List<BaseDict> selectBaseDictByCode(String code); 

}
