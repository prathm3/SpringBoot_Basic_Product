package com.demo.SpringRest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.demo.SpringRest.Service.ProductService;
import com.demo.SpringRest.beans.Product;

@Controller
@RequestMapping("/products")
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@GetMapping("/")
	public ModelAndView viewProducts() {
		
		List<Product> plist = productService.viewProducts();
		
		
		return new ModelAndView("display" , "plist", plist);
	}
	@PostMapping("/add")
	public ModelAndView addProduct(@RequestParam("pid") int pid, @RequestParam("pname") String pname, @RequestParam("qty") int qty, @RequestParam("price") double price) {
		boolean added = productService.addProduct(pid, pname, qty, price);
		if(added) {
			return new ModelAndView("redirect:/products/");
		}else {
			return new ModelAndView("redirect:/products/");
		}
	}
	
	@GetMapping("/editProduct/{pid}")
	public ModelAndView updateProduct(@PathVariable("pid") int pid) {
		Product p = productService.getProduct(pid);
		if(p != null) {
			return new ModelAndView("display","p", p);
		}else {
			return new ModelAndView("redirect:/products/");
		}
	}
	@GetMapping("/deleteProduct/{pid}")
	public ModelAndView deleteProduct(@PathVariable("pid") int pid) {
		boolean p = productService.deleteProduct(pid);
		if(p) {
			return new ModelAndView("redirect:/products/");
		}else {
			return new ModelAndView("redirect:/products/");
		}
	}
	
	

}
