package com.hsq.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hsq.bean.BaseDict;
import com.hsq.mapper.BaseDictDao;
@Service
public class BaseDictServiceImpl implements BaseDictService {
@Autowired
private BaseDictDao baseDictDao;
	public List<BaseDict> selectBaseDictByCode(String code) {
		List<BaseDict> selectBaseDictByCode = baseDictDao.selectBaseDictByCode(code);
		
		
		return selectBaseDictByCode;
	}

}
