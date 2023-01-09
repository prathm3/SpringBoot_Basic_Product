package com.demo.SpringRest.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.SpringRest.beans.Product;

public interface ProductDao extends JpaRepository<Product, Integer>{

}
