package com.it.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.it.entity.Category;
import com.it.entity.Product;

public interface CategoryRepo extends CrudRepository<Category, Integer> {
	
//	List<Category> findAll();
	
	Page<Category> findAll(Pageable pageable);

}
