package com.demo.SpringRest.Service;

import java.util.List;

import com.demo.SpringRest.beans.Product;



public interface ProductService {

	List<Product> viewProducts();

	boolean addProduct(int pid, String pname, int qty, double price);

	Product getProduct(int pid);

	boolean deleteProduct(int pid);

	

}
