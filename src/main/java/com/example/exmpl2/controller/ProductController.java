package com.example.exmpl2.controller;

import com.example.exmpl2.database.Database;
import com.example.exmpl2.model.Product;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/cart")
public class ProductController {

    private static List<Product> productList = Database.createDatabase();

    @GetMapping("/")
    public List<Product> getProducts(){
        return productList;
    }
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable int id){
        return productList.stream().filter(product -> product.getId() == id).findAny().get();
    }
    @PostMapping("/products")
    public Product addProduct(@RequestBody Product product){
        productList.add(product);
        return product;
    }
    @PutMapping("/products/{id}")
    public List<Product> updateProduct(@RequestBody Product productToUpdate){
        Product existingProduct = productList.stream().filter(product -> product.getId() == productToUpdate.getId()).findAny().get();

        productList.remove(existingProduct);
        existingProduct.setId(productToUpdate.getId());
        existingProduct.setName(productToUpdate.getName());
        productList.add(existingProduct);

        return productList;
    }

    @DeleteMapping("/products/{id}")
    public List<Product> removeProduct(@PathVariable int productToDeleteId){
        Product existingProduct = productList.stream().filter(product -> productToDeleteId == product.getId()).findAny().get();
        productList.remove(existingProduct);
        return productList;
    }
}
