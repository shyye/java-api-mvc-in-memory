package com.booleanuk.api.products.repositories;

import com.booleanuk.api.products.controllers.ProductController;
import com.booleanuk.api.products.models.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository {
    private int idCounter = 4;
    private List<Product> products;

    public ProductRepository() {
        this.products = new ArrayList<>() {
            {
                add(new Product(1,"How to build API's", "Book", 1500));
                add(new Product(2,"Hello World", "Book", 42));
                add(new Product(3,"Book #3", "Book", 350));
            }
        };
    }

    // Create
    public Product create(Product product) {
        Product newProduct = new Product(
                this.idCounter++,
                product.getName(), product.getCategory(), product.getPrice());

        this.products.add(product);
        return product;
    }

    //Get all
    public List<Product> getAll(){
        return this.products;
    }

    // Get specific
    public Product getSpecific(int id) {
        return products.stream().
                filter(p -> p.getId() == id).
                findFirst().orElse(null);
    }

    // Update
    public Product update(int id, Product product) {
        Product originalProdut = getSpecific(id);
        if (originalProdut == null) {
            return null;
        }

        int index = this.products.indexOf(originalProdut);
        Product updatedProduct = new Product(
                originalProdut.getId(),
                product.getName(), product.getCategory(), product.getPrice()
        );
        this.products.set(index, updatedProduct);
        return updatedProduct;
    }

    // Delete
    public Product delete(int id) {
        Product product = getSpecific(id);
        if (product == null) {
            return null;
        }
        this.products.remove(product);
        return product;
    }

}
