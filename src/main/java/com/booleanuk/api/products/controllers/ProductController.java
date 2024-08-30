package com.booleanuk.api.products.controllers;

import com.booleanuk.api.products.models.Product;
import com.booleanuk.api.products.repositories.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("products")
public class ProductController {
    private ProductRepository repository;

    public ProductController() {
        this.repository = new ProductRepository();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product create(@RequestBody Product product) {
        return this.repository.create(product);
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return this.repository.getAll();
    }

    @GetMapping("{id}")
    public Product getSpecificProduct(@PathVariable int id) {
        return this.repository.getSpecific(id);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Product update(@PathVariable int id, @RequestBody Product product) {
        return this.repository.update(id, product);
    }

    @DeleteMapping("{id}")
    public Product delete(@PathVariable int id) {
        return this.repository.delete(id);
    }

}
