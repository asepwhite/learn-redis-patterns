package learn.kvstore.cacheaside.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import learn.kvstore.cacheaside.model.Product;
import learn.kvstore.cacheaside.service.ProductService;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/products/getByDisplayName")
    public ResponseEntity<Object> getMobileDataProvider(@RequestParam String displayName) {
        List<Product> searchedProduct = productService.searchProductsByDisplayName(displayName);
        return ResponseEntity.status(HttpStatus.OK).body(searchedProduct);
    }
}
