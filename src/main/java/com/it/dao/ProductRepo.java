package com.it.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.it.entity.Product;

public interface ProductRepo extends CrudRepository<Product, Integer> {
	
//	List<Product> findAll();

	Page<Product> findAll(Pageable pageable);
}
