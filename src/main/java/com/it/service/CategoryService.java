package com.it.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.it.dao.CategoryRepo;
import com.it.entity.Category;
import com.it.entity.Product;

@Component
public class CategoryService {
	
	@Autowired
	private CategoryRepo repo;
	
	public Category getById(int id) {
		Category e= repo.findById(id).get();
		return e;
	}
	
//	public List<Category> findAllRecords(){
//		List<Category> list = repo.findAll();
//		return list;
//	}

	public Page<Category> findAllRecords(int page, int sizePerPage){
		Pageable pageable = PageRequest.of(page, sizePerPage);
		Page<Category> list = repo.findAll(pageable);
		return list;
	}
	
	public void add(Category e) {
		repo.save(e);
	}

	public void update(Category e) {
		repo.save(e);
	}

	public void deleteRecordById(int id) {
		repo.deleteById(id);
	}
}