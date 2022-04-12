package com.humber.service;

import com.humber.model.Product;
import com.humber.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getALlProduct() {
        return (List<Product>) productRepository.findAll();
    }

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }



}
