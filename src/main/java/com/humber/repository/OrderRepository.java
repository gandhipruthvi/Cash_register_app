package com.humber.repository;

import com.humber.model.Order;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {
	List<Order> findAllByOrderByDateDesc();
}
