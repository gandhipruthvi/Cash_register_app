package com.humber.controller;

import com.humber.model.Order;
import com.humber.model.Product;
import com.humber.service.OrderService;
import com.humber.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@Autowired
    private ProductService productService;

	// PRUTHVI
	@RequestMapping(value = "/order_home", method = RequestMethod.GET)
	public String getAllOrders(Model model) {
		List<Order> listOrders = orderService.getAllOrders();
		model.addAttribute("listOrders", listOrders);
		return "order_home";
	}

	@RequestMapping(value = "/newOrderForm", method = RequestMethod.GET)
	public String newOrderForm(Model model) {
		Order order = new Order();
		model.addAttribute("order", order);
		List<Product> listProducts = productService.getAllProduct();
        model.addAttribute("listProducts", listProducts);
		return "addOrderForm";
	}
	
	@RequestMapping(value = "/addOrder", method = RequestMethod.POST)
    public String addOrder(@ModelAttribute("order") Order order, Model model) {
		orderService.saveOrder(order);
        return "redirect:/order_home";
    }
}
