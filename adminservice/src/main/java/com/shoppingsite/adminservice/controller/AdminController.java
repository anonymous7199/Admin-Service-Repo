package com.shoppingsite.adminservice.controller;






import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shoppingsite.adminservice.model.Product;
import com.shoppingsite.adminservice.service.AdminService;



@RestController
@RequestMapping("/admin/products")
public class AdminController {
	@Autowired
	AdminService adminService;
	
	
	@GetMapping("/")
	public Product[] getallProducts(){
		return adminService.getAllProducts();
	}
	
	
	@GetMapping(value = "/getproductbyid/{id}")
	public Product getProductById(@PathVariable(value="id") long id) {
		return adminService.getProductById(id);

	}
	
	@PostMapping("/addproduct")
	public Product addProduct(@RequestBody Product product) {
		return adminService.addProduct(product);
		
	}

	@DeleteMapping("/deleteproduct/{id}")
	public String deleteProduct(@PathVariable("id") long id) {
		adminService.deleteProduct(id);
		return "Product deleted by Admin";
	}
	
	@PutMapping("/updateproduct/{id}")
	public void updateProduct(@RequestBody Product product, @PathVariable("id") long id) {
		adminService.updateProduct(product, id);
	}
	
	@GetMapping("/getproductbyname/{name}")
	public Product getproductbyname(@PathVariable(value="name")String name) {
		return adminService.getProductByName(name);
	}
	
	@GetMapping("/getproductsbyname/{name}")
	public Product[] getproductsbyname(@PathVariable(value = "name")String name){
		return adminService.getProductsbyname(name);
	}
	
	@GetMapping("/getproductsbyprice/{price}")
	public Product[] getproductsbyprice(@PathVariable(value = "price")double price){
		return adminService.getProductsbyprice(price);
	}
}
