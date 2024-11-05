package org.doanvinh.doantrongvinhse.Controler;

import org.doanvinh.doantrongvinhse.Model.Product;
import org.doanvinh.doantrongvinhse.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getProducts() {
        return new ResponseEntity<>(productService.getProducts(), HttpStatus.OK);
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable int id) {
        if (productService.getProductById(id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(productService.getProductById(id), HttpStatus.OK);
        }
    }

    @PostMapping("/products")
    public void addProduct(@RequestBody Product product) {
        System.out.println(product);
        productService.addProduct(product);
        System.out.println("Product added!");
    }

    @PutMapping("/products")
    public void updateProduct(@RequestBody Product product) {
        productService.updateProduct(product);
        System.out.println("Update successful!");
    }

    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable int id) {
        productService.deleteProduct(id);
        System.out.println("Product deleted!");
    }

}
