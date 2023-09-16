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
public class ProductController {
	 
	@Autowired //searches for the object of ProductService and inject into service variable
	private ProductService service;
	
	
	//----------------------------Product_APIs--------------------------------

	
	@PostMapping("api/products/{category_id}")
	public String addProduct(@RequestBody @Valid Product e, @PathVariable int category_id) {
		if(e.getName().contains(" ")) {
			throw new InvalidNameException(); //if name contains any space then it will throw InvalidNameException
		}
		else {
			service.add(e, category_id);
			return "Data Added";
		}
	}
	
	@GetMapping("api/products/{id}")
	public Product getProductById(@PathVariable int id){
		Product e = service.getById(id);
		return e;
	}
	
//	@GetMapping("api/products")
//	public List<Product> allProduct(){
//		return service.findAllRecords();
//	}
	
	@GetMapping("api/products")
	public Page<Product> allProduct(@RequestParam(defaultValue = "1") int page,
	                                @RequestParam(defaultValue = "2") int sizePerPage){
	    Pageable pageable = PageRequest.of(page, sizePerPage);
	    return service.findAllRecords(page, sizePerPage);
	}

	@PutMapping("api/products")
	public String updateProduct(@RequestBody Product e) {
		service.update(e);
		return "Data Updated";
	}
	
	@DeleteMapping("api/products/{id}")
	public String deleteProduct(@PathVariable("id") int id) {
		service.deleteRecordById(id);
		return "Data Deleted";
	}	
}
