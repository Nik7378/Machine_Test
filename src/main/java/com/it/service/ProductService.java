package com.it.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.it.dao.CategoryRepo;
import com.it.dao.ProductRepo;
import com.it.entity.Category;
import com.it.entity.Product;
import com.it.exception.ResourceNotFoundException;

@Component
public class ProductService {
	
	@Autowired
	private ProductRepo repo;
	
	@Autowired
	private CategoryRepo catRepo;
	
	public void add(Product e, int category_id) {
		Category cat = this.catRepo.findById(category_id).orElseThrow(()-> new ResourceNotFoundException());
		e.setCategory(cat);
//		Product save = this.repo.save(e);
		repo.save(e);
	}

	public void update(Product e) {
		repo.save(e);
	}

	public void deleteRecordById(int id) {
		repo.deleteById(id);
	}

	public Product getById(int id) {
		Product e= repo.findById(id).get();
		return e;
	}
	
//	public List<Product> findAllRecords(){
//		List<Product> list = repo.findAll();
//		return list;
//	}

	public Page<Product> findAllRecords(int page, int sizePerPage){
		Pageable pageable = PageRequest.of(page, sizePerPage);
		Page<Product> list = repo.findAll(pageable);
		return list;
	}
	
	public void deleteAllRecords() {
		repo.deleteAll();
	}	
}