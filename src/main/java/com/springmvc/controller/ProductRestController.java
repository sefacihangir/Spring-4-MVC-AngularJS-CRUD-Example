package com.springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springmvc.model.Product;
import com.springmvc.service.ProductService;

@RestController
public class ProductRestController {
	
	@Autowired
	ProductService productService;
	
	@RequestMapping(value= "/product/", method = RequestMethod.GET)
	public ResponseEntity<List<Product>> listAllProducts(){
		List<Product> products = productService.findAllProducts();
		
		if(products.isEmpty()){
			return new ResponseEntity<List<Product>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
			
	}

}
