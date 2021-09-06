package com.informatorio.proyecto.controller;

import com.informatorio.proyecto.entity.Product;
import com.informatorio.proyecto.repository.ProductRepository;
import com.informatorio.proyecto.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/product")
public class ProductController {

    private ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @PostMapping
    public ResponseEntity<?> createProduct(@Valid @RequestBody Product product) throws CartException {
        return new ResponseEntity<>(productRepository.save(product), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> findProduct(@RequestParam("startWith") String startWith) throws CartException {
        return new ResponseEntity<>(productRepository.findForName(startWith)), HttpStatus.CREATED);
    }

    @Autowired
    private ProductRepository repository;

    @RequestMapping(value = "/products", method = RequestMethod.GET)

    public @ResponseBody Iterable<Product> findProducts() {
        return repository.findAll();
    }

    @Autowired
    private HelloService helloService;

    @GetMapping(value = "/saludar")

    public @ResponseBody String saludar() {
        return helloService.saludar();
    }
}




















