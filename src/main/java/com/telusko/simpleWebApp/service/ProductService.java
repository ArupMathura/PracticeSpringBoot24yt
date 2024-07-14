package com.telusko.simpleWebApp.service;

import com.telusko.simpleWebApp.model.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
@Service
public class ProductService {
    List<Product> products = new ArrayList<>(Arrays.asList(
            new Product(101, "OnePlus", 35000),
            new Product(102, "iPhone", 70000),
            new Product(103, "macbook", 100000)
    ));

    public List<Product> getProducts() {
        return products;
    }

    public Product getProductById(int prodId) {

        return products.stream()
                .filter(p -> {
                    log.info("Checking product with prodId: {}", p.getProdId());
                    log.info("Checking product with prodId: {}", prodId);
                    return p.getProdId() == prodId;
                })
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Product with id " + prodId + " not found"));
    }

    public void addProduct(Product product) {
        System.out.println(product);
        products.add(product);
    }

    public void updateProduct(Product product) {
        int index = 0;
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getProdId() == product.getProdId()) {
                index = i;
            }
        }
        products.set(index, product);
    }
}
