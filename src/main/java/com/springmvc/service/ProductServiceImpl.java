package com.springmvc.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springmvc.model.Product;
import com.springmvc.model.Product.ProductCategory;

@Service("productService")
@Transactional
public class ProductServiceImpl implements ProductService {
	
	private static final AtomicLong counter = new AtomicLong();

	private static List<Product> products;
	
	static{
		products = populateProducts();
	}

	@Override
	public Product findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	private static List<Product> populateProducts() {
		List<Product> products = new ArrayList<Product>();
		products.add(new Product(counter.incrementAndGet(), "Arroz", ProductCategory.Grocery));
		products.add(new Product(counter.incrementAndGet(), "Detergente", ProductCategory.Cleaning));
		products.add(new Product(counter.incrementAndGet(), "Batedeira", ProductCategory.Electronic));
		products.add(new Product(counter.incrementAndGet(), "Creme Dental", ProductCategory.Hygiene));
		products.add(new Product(counter.incrementAndGet(), "Milho", ProductCategory.Grocery));
		products.add(new Product(counter.incrementAndGet(), "Lâmpada", ProductCategory.Electronic));
		return products;
	}

	@Override
	public Product findByDescription(String description) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveProduct(Product product) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateProduct(Product product) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteProductById(long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Product> findAllProducts() {
		return products;
	}

	@Override
	public void deleteAllPRoducts() {
		// TODO Auto-generated method stub

	}

}
