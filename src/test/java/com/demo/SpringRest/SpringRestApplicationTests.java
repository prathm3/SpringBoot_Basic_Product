package com.demo.SpringRest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.demo.SpringRest.Service.ProductService;
import com.demo.SpringRest.Service.ProductServiceImpl;
import com.demo.SpringRest.beans.Product;
import com.demo.SpringRest.dao.ProductDao;


@RunWith(SpringRunner.class)
@SpringBootTest
class SpringRestApplicationTests {

	@InjectMocks
	private ProductServiceImpl service;
	
	@Mock
	private ProductDao dao;
	
	@Test
	public void getProducts() {
		// dummy input
		when(dao.findAll()).thenReturn(Stream.of(new Product(234, "monaco", 31, 32.0), new  Product(1234, "apple", 375, 120.0)).collect(Collectors.toList()));
		//real output
		List<Product> list = service.viewProducts();
		//checking
		assertEquals(2, list.size());
	}
	@Test
	public void getProductById() {
		
		//when(dao.findById(237)).thenReturn(new Product(237, "no", 90, 90));
		assertEquals(1,  service.getProduct(237));
	}
	@Test
	public void saveProduct() {
		Product p = new Product(786, "Bread", 67, 9876);
		when(dao.save(p)).thenReturn(p);
		boolean b = service.addProduct(786, "Bread", 67, 9876);
		assertEquals(true, b);
	}
	//@Ignore
	@Test
	public void deleteUserTest() {
		Product user = new Product(999, "Pranya", 33, 55);
		service.deleteProduct(999);
		verify(dao, times(1)).deleteById(999);;
	}

}
