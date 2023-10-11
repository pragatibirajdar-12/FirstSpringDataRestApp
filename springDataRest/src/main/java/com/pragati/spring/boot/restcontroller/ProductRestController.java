package com.pragati.spring.boot.restcontroller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pragati.spring.boot.entity.Product;
import com.pragati.spring.boot.repos.ProductRepo;
//This class illustrates How to use REST API methods
//to check how we did check o/p src/main/resources/Spring Boot Rest Application o-p.postman_collection
@RestController
@RequestMapping("/products")
public class ProductRestController {  //this class will acts as Restful End point for our application
		
	@Autowired
	ProductRepo repo;
	
	
	@GetMapping   //This is used for HTTP GET verb/method, By Default spring will convert/revert data in json
	public Iterable<Product> getProducts(){  //This Iterable<Product> can be converted to List if we want to
		return repo.findAll(); //findAll() returns Iterable values,  
		
		//after running the Application Go to postman and type localhost:8080/products you will get response in body About whatever you have in DB
		//sample o/p 
	/*	
	{
        "id": 1,
        "name": "suraj",
        "description": "I love the product",
        "price": 300.0
    },
    {
        "id": 2,
        "name": "Abhu",
        "description": "Not Much",
        "price": 599.0
    },
    {
        "id": 3,
        "name": "Abhus",
        "description": "Not Mucsh",
        "price": 599.0
    }
    */
	}
	
	@PostMapping  //This is to use HTTP post method if we need to save anything 
	public Product saveProduct(@RequestBody Product product){ //@requestbody used for telling that there is object we are passing
		return repo.save(product);  //Crudrepo method to save 
		//use Post method in PostMan and then go to body and select raw and in dropdown click JSON and then pass the json and send
		
	}
	
	@PutMapping  //This is to use HTTP post method if we need to Update anything 
	public Product updateProduct(@RequestBody Product product){ //@requestbody used for telling that there is object we are passing
		return repo.save(product);  //Crudrepo method to save is smart enough to check new and exisiting records
		//use Post method in PostMan and then go to body and select raw and in dropdown click JSON and then pass the json and send
		
	}
	
	@GetMapping("/{id}") //this is to tell that we are getting some data like this
	public Product findProductByID(@PathVariable Long id) { //this annotation used to get the data that is there in URL
		Optional<Product> idData = repo.findById(id);  
		Product product2=new Product();
		if (idData.isPresent()) {
			 product2= idData.get();
			
		}
		
		return product2;
	}
	
	@DeleteMapping("/del/{id}") //this type we can define
	public String DeleteProductByID(@PathVariable Long id) {
		repo.deleteById(id);  //simple crud repo method
		
		return "Data with ID "+id+" Deleted successfully"; //response  Cool! isn't it
		
	}
	
}
