package org.shupeyko.controllers;

import org.shupeyko.data.Product;
import org.shupeyko.services.IProductsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class ProductsController {

    private IProductsService iProductsService;

    public ProductsController(IProductsService iProductsService) {
        this.iProductsService = iProductsService;
    }

    // Приветствие: url - http://localhost:8080/eshop/hello

    @GetMapping("/hello")
    public String helloWork() {
        return "Hello, Igor!";
    }

    //- http://localhost:8080/eshop/products
    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return iProductsService.getItems();
    }

    @PostMapping("/products")
    public void addNewProduct(@RequestBody Product product) {
        iProductsService.add(product);
    }

    // - http://localhost:8080/eshop/products/1
    @GetMapping("/products/{id}")
    public Optional<Product> getProductById(@PathVariable AtomicLong id) {
        return iProductsService.findById(id);
    }

    // - http://localhost:8080/eshop/remove
    @DeleteMapping("/products/remove/")
    public void deleteAll() {
        iProductsService.removeAll();
    }

    // - http://localhost:8080/eshop/remove_id/1
    @DeleteMapping("/products/remove_id/{id}")
    public boolean deletingId(@PathVariable AtomicLong id) {
        return iProductsService.removeId(id);
    }

}

