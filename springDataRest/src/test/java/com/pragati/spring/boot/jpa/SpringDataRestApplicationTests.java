package com.pragati.spring.boot.jpa;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.pragati.spring.boot.entity.Product;
import com.pragati.spring.boot.repos.ProductRepo;

@SpringBootTest
class SpringDataRestApplicationTests {

	//@Autowired
	//ApplicationContext context;

	@Autowired
	ProductRepo repo;

	// @Test //if you comment this annotation this method will not work
	public void saveProduct() {
		// This is to illustrate how to save in Db, I use mariaDB but you can configure
		// for anything
		Product product = new Product();
		product.setId(3L); // L to indicate Long value
		product.setName("Abhus");
		product.setDescription("Not Mucsh");
		product.setPrice(599.3);

		repo.save(product);

	}

	// @Test
	public void getReadProduct() {

		Optional<Product> idData = repo.findById(1L);

		// This step is for optional
		if (idData.isPresent()) {
			Product product2 = idData.get();
			System.out.println(product2);
		}

	}

	//@Test
	public void updateProduct() {

		Optional<Product> idData = repo.findById(1L);
		Product product2 = null;
		// This step is for optional
		if (idData.isPresent()) {
			product2 = idData.get();
			System.out.println(product2);
		}

//		Now to update the product we got 

		product2.setDescription("I love the product");

		repo.save(product2); // here it will check the value and update automatically

	}

	//@Test
	public void getAllProduct() {

		repo.findAll().forEach(p -> {
			System.out.println(p); //This is the Lambda Expression which loops over products
		});

	}
	
	//@Test
	public void finderMethod() {
		System.out.println("finder method");
		System.out.println(repo.findByName("Abhu"));
	}

	@Test
	void contextLoads() {
	}

}
