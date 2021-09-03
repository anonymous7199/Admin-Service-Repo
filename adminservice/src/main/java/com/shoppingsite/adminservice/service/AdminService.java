package com.shoppingsite.adminservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.shoppingsite.adminservice.model.Product;

@Service
public class AdminService {
	@Autowired
	RestTemplate restTemplate;
	
	String url_productservice = "http://localhost:9001/products";

	public Product getProductById(long id) {
		
		Product p = restTemplate.getForObject(url_productservice+"/getproductbyid/"+id, Product.class);
		
		System.out.println(p);
		return new Product(p.getId(),p.getName(),p.getDescription(),p.getPrice());
		
	}


	public Product addProduct(Product product) {
		
		Product addproduct = restTemplate.postForObject(url_productservice+"/addproduct", product, Product.class);
		return addproduct;
	}


	public void deleteProduct(long id) {
		restTemplate.delete(url_productservice+"/deleteproduct/"+id);
		
	}


	public void updateProduct(Product product, long id) {
	
		restTemplate.put(url_productservice+"/updateproduct/"+id,product,Product.class);
		
	}


	public Product[] getAllProducts() {
		
		ResponseEntity<Product[]> allproducts = restTemplate.getForEntity(url_productservice, Product[].class);

		return allproducts.getBody();
		
	}


	public Product getProductByName(String name) {
		Product p = restTemplate.getForObject(url_productservice+"/getproductbyname/"+name, Product.class);
		
		return new Product(p.getId(),p.getName(),p.getDescription(),p.getPrice());
	}


	public Product[] getProductsbyname(String name) {
		
		ResponseEntity<Product[]> allproducts = restTemplate.getForEntity(url_productservice+"/getproductsbyname/"+name, Product[].class);

		return allproducts.getBody();
	}


	public Product[] getProductsbyprice(double price) {
		
		ResponseEntity<Product[]> allproducts = restTemplate.getForEntity(url_productservice+"/getproductsbyprice/"+price, Product[].class);

		return allproducts.getBody();
	}


	
	
}
