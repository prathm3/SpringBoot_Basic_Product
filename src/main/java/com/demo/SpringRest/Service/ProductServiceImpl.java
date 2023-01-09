package com.demo.SpringRest.Service;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.SpringRest.beans.Product;
import com.demo.SpringRest.dao.ProductDao;



@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
   private ProductDao pdao;

	public List<Product> viewProducts() {
		return pdao.findAll();
	}

	public boolean addProduct(int pid, String pname, int qty, double price) {
		Product p = pdao.save(new Product(pid, pname, qty, price));
		return p != null;
	}

	public Product getProduct(int pid) {
		Optional<Product> op = pdao.findById(pid);
		
		return op.orElse(null);
	}

	public boolean deleteProduct(int pid) {
		pdao.deleteById(pid);
		return true;
	}
   

}
