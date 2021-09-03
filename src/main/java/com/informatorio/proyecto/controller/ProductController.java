package com.informatorio.proyecto.controller;

import com.informatorio.proyecto.entity.Product;
import com.informatorio.proyecto.repository.ProductRepository;
import com.informatorio.proyecto.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

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
