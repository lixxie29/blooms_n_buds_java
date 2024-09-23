package com.lix.java_flower_app.rest.controller;

import com.lix.java_flower_app.rest.models.Product;
import com.lix.java_flower_app.rest.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductRepo productRepo;

    @GetMapping(value = "/products")
    public List<Product> getProducts(){
        return productRepo.findAll();
    }

    @PostMapping(value = "/products/save")
    public String createProduct(@RequestBody Product product){
        productRepo.save(product);
        return ">>> created product";
    }

    @PutMapping("/products/update/{id}")
    public String updateProduct(@PathVariable Long id, @RequestBody Product product){
        Product updatedProduct = productRepo.findById(id).get();
        updatedProduct.setName(product.getName());
        updatedProduct.setPrice(product.getPrice());
        updatedProduct.setDescription(product.getDescription());
        productRepo.save(updatedProduct);
        return ">>> updated product";
    }

    @DeleteMapping("/products/delete/{id}")
    public String deleteProduct(@PathVariable Long id){
        Product deleteProduct = productRepo.findById(id).get();
        productRepo.delete(deleteProduct);
        return ">>> deleted product with id: "+ id;
    }
}
