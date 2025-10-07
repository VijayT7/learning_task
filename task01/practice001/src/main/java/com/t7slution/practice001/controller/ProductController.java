package com.t7slution.practice001.controller;


import com.t7slution.practice001.model.Product;
import com.t7slution.practice001.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService service;

    // instead of Autowired we can use constructor bean
//    public ProductController(ProductService service) {
//        this.service = service;
//    }

    @GetMapping("/products")
    public List<Product> getProductList(){
        return service.getProducts();
    }

    @GetMapping("/products/{productId}")
    public Product getProductById(@PathVariable int productId){
        return service.getProductById(productId);
    }

    @PostMapping("/products")
    public void addProduct(@RequestBody Product product){
        System.out.println("add product    "+ product.toString());
        service.addProduct(product);
    }

    @PutMapping("/products")
    public void updateProduct(@RequestBody Product product){
        service.updateProduct(product);
    }

    @DeleteMapping("/products/{productId}")
    public void deleteProduct(@PathVariable int productId){
        service.deleteProduct(productId);
    }

}
