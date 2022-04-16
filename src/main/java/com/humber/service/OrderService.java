package com.humber.service;

import java.util.List;

import javax.transaction.Transactional;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.humber.model.Order;
import com.humber.model.Product;
import com.humber.repository.OrderRepository;
 
@Service
@Transactional
public class OrderService {
 
    @Autowired
    private OrderRepository orderRepository;
     
    public List<Order> getAllOrders() {
        return (List<Order>) orderRepository.findAll();
    }

    public Order saveProduct(Order order) {
        return orderRepository.save(order);
    }
}
