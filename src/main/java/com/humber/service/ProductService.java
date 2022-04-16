package com.humber.service;

import com.humber.model.Product;
import com.humber.repository.ProductRepository;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProduct() {
        return (List<Product>) productRepository.findAll();
    }

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public void delete(Long id) {
        productRepository.deleteById(id);
    }
    
    public List<Product> getByName(String name) {
    List<Product> list = (List<Product>) productRepository.findAll();
    List<Product> newList = new ArrayList();
    for (Product product : list) {
        if(product.getName().equalsIgnoreCase(name)) {
            newList.add(product);
        }
    }
    return newList;
    }
    
    public List<Product> getByCategory(String category) {
    List<Product> list = (List<Product>) productRepository.findAll();
     List<Product> newList = new ArrayList();
    for (Product product : list) {
        if(product.getCategory().equalsIgnoreCase(category)) {
            newList.add(product);
        }
    }
    return newList;
    }

    public Product getProductById(long id) {
        Optional<Product> optional = productRepository.findById(id);
        Product product = null;
        if (optional.isPresent()) {
            product = optional.get();
        } else {
            throw new RuntimeException("Country not found for id :: " + id);
        }
        return product;
    }
}
