package com.it.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.it.dao.ProductRepo;
import com.it.entity.Product;

@Component
public class ProductService {
	
	@Autowired
	private ProductRepo repo;
	
	public Product getById(int id) {
		Product e= repo.findById(id).get();
		return e;
	}
	
	public List<Product> findAllRecords(int page, int sizePerPage){
		Pageable pageable = PageRequest.of(page, sizePerPage);
		List<Product> list = repo.findAll(pageable);
		return list;
	}
	
	public void add(Product e) {
		repo.save(e);
	}

	public void update(Product e) {
		repo.save(e);
	}

	public void deleteRecordById(int id) {
		repo.deleteById(id);
	}

	public void deleteAllRecords() {
		repo.deleteAll();
	}	
}