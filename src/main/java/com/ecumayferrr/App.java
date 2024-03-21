package com.ecumayferrr;

import java.util.List;

import com.ecumayferrr.entity.Producto;
import com.ecumayferrr.repository.ProductRepository;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class App {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(App.class, args);
        var repository = context.getBean(ProductRepository.class);

        List<Producto> products = List.of(
                new Producto(null, "product2", 6.99, 2),
                new Producto(null, "product1", 5.99, 1),
                new Producto(null, "product3", 7.99, 4),
                new Producto(null, "product4", 8.99, 2),
                new Producto(null, "product5", 8.99, 2),
                new Producto(null, "product6", 8.99, 2)
        );
        repository.saveAll(products);
	}

}
