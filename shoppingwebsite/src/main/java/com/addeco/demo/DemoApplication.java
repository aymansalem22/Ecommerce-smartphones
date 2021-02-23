package com.addeco.demo;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.addeco.demo.entity.Customer;
import com.addeco.demo.entity.Manufacturer;
import com.addeco.demo.entity.Product;
import com.addeco.demo.entity.ShopCart;
import com.addeco.demo.repository.CustomerRepository;
import com.addeco.demo.repository.ManuFacturerRepository;
import com.addeco.demo.repository.ProductRepository;
import com.addeco.demo.repository.ShopCartRepository;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
/****/
	@Autowired
	CustomerRepository customrepository;

	@Autowired
	ManuFacturerRepository manurepository;

	@Autowired
	ProductRepository productrepositoy;

	@Autowired
	ShopCartRepository shopcartrepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Customer customer1 = new Customer("ayman", "cl rio escudo", "a@a", "1234", "633258741", "aymansalem");
		Manufacturer amazon=new Manufacturer("84277777","apple","cl madrid plaza",1000);
		manurepository.save(amazon);
		Product product1 = new Product("Iphone 12", "new versions with 8 ram", 3, 500.05,amazon);
		Product product2 = new Product("Iphone 11", "new versions with 6 ram", 2, 400.05,amazon);
		Product product3 = new Product("Iphone 10", "new versions with 4 ram", 4, 350.05,amazon);
		Product product4 = new Product("Iphone 9", "new versions with 4 ram", 6, 300.15,amazon);
		List<Product> products = Arrays.asList(product1, product2, product3, product4);
		
		amazon.setProducts(products);
		
		productrepositoy.saveAll(products);

		ShopCart shopcart = new ShopCart();
		customer1.setShopcart(shopcart);
		shopcart.setProduct(products);
		customrepository.save(customer1);
		shopcartrepository.save(shopcart);			


		

	}

}
