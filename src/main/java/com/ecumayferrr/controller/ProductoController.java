package com.ecumayferrr.controller;

import java.util.List;

import com.ecumayferrr.entity.Producto;
import com.ecumayferrr.repository.ProductRepository;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//Con @RequestMapping le decimos que este constructor va a escuchar en esa pagina es decir en la url.
@Controller
@RequestMapping("/products")
public class ProductoController {
	
	//Se puede llamar con @Autowired pero es mejor a traves del constructor, facilita el testinh MOCK
	private ProductRepository productRepository;

	public ProductoController(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	//No trabajamos con ApiRest entonces vamos a devolver todo lo que sea timing y estos Strings van a hacer los 
	//archivos html que vamos a tener en resources templates (la ruta de abajo).
	//Model es una clase que es la que va a permitir CARGAR DATOS y aqui es donde entramos en el modelo vista control
	//GetMapping spring nos va a cargar los modelos automaticamente. http://localhost:8080/products con el metodo GET
	@GetMapping
	public String findAll(Model model) {
		
		//Ha difrenecia de la otra manera (anterior commit v1.2) aqui se carga una lista y obtenemos todos los produuctos.
		List <Producto> productos = this.productRepository.findAll();
		
		model.addAttribute("products", productos);
		return "product-list";
	}
	
}
