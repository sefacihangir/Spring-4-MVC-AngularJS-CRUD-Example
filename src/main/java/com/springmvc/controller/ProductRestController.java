package com.springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

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
	
	@RequestMapping(value = "/product/", method = RequestMethod.POST)
	public ResponseEntity<Void> createProduct(@RequestBody Product product, UriComponentsBuilder ucBuilder){
	    System.out.println("Creating Product " + product.getDescription());
	    
	    if(productService.isProductExist(product)){
		System.out.println("A Product with description " + product.getDescription() + " already exist");
		return new ResponseEntity<Void>(HttpStatus.CONFLICT);
	    }
	    
	    productService.saveProduct(product);
	    
	    HttpHeaders headers = new HttpHeaders();
	    headers.setLocation(ucBuilder.path("/product/{id}").buildAndExpand(product.getId()).toUri());
	    return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

}
