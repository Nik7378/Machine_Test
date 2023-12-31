package com.it.cntrl;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.it.entity.Product;
import com.it.entity.Category;
import com.it.exception.InvalidNameException;
import com.it.service.CategoryService;
import com.it.service.ProductService;

@RestController
@CrossOrigin(origins="http://localhost:8080")
public class CategoryController {
	

	@Autowired //searches for the object of CategoryService and inject into service variable
	private CategoryService cat_service;
	
	
	//----------------------------Category APIs--------------------------------
	
	
	@PostMapping("api/categories")
	public String addCategory(@RequestBody @Valid Category e) {
		if(e.getName().contains(" ")) {
			throw new InvalidNameException(); //if name contains any space then it will throw InvalidNameException
		}
		else {
			cat_service.add(e);
			return "Data Added";
		}
	}
	
	@GetMapping("api/categories/{id}")
	public Category getCategoryById(@PathVariable int id){
		Category e = cat_service.getById(id);
		return e;
	}
	
//	@GetMapping("api/categories")
//	public List<Category> allCategory(){
//	    return cat_service.findAllRecords();
//	}

	@GetMapping("api/categories")
	public Page<Category> allCategory(@RequestParam(defaultValue = "1") int page,
	                                @RequestParam(defaultValue = "2") int sizePerPage){
	    Pageable pageable = PageRequest.of(page, sizePerPage);
	    return cat_service.findAllRecords(page, sizePerPage);
	}

	@PutMapping("api/categories")
	public String updateCategory(@RequestBody Category e) {
		cat_service.update(e);
		return "Data Updated";
	}
	
	@DeleteMapping("api/categories/{id}")
	public String deleteCategory(@PathVariable("id") int id) {
		cat_service.deleteRecordById(id);
		return "Data Deleted";
	}	
}