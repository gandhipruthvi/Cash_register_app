package com.humber.service;

import java.util.List;
import java.util.Optional;

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
        return (List<Order>) orderRepository.findAllByOrderByDateDesc();
    }

    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }
    
    public void updateOrderStatus(long id, String status) {
        Optional<Order> optional = orderRepository.findById(id);
        Order order = null;
        if (optional.isPresent()) {
        	order = optional.get();
        } else {
            throw new RuntimeException("Order not found");
        }
        order.setStatus(status);
        orderRepository.save(order);
    }
}
