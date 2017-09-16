package com.hsq.dao;

import java.util.List;

import com.hsq.dto.Category;

public interface ICategory {
public List<Category> findAllCategory()throws Exception;
}
