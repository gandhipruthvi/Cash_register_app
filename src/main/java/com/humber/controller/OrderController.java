package com.humber.controller;

import com.humber.model.Order;
import com.humber.model.Product;
import com.humber.service.OrderService;
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
    
    //MIKHAIL
    @RequestMapping(value = "/order_home", method = RequestMethod.GET)
    public String getAllOrders(Model model) {
        List<Order> listOrders = orderService.getAllOrders();
        model.addAttribute("listProducts", listOrders);
        return "order_home";
    }
//    @RequestMapping("/deleteByID/{id}")
//    public String deleteCountry(@PathVariable(name="id")Long id) {
//        orderService.delete(id);
//        
//        return "redirect:/home";
//    }
//    @GetMapping("/openProductByName")
//    public String openProductByName(Model model) {
//        return "get_by_name";
//    }
//    @GetMapping("/openProductByCategory")
//    public String openProductByCategory(Model model) {
//        List<String> options = new ArrayList<String>();
//
//        options.add("Devices and Electronics");
//        options.add("Books and Reading");
//        options.add("Groceries & Drinks");
//
//        model.addAttribute("options", options);
//        return "get_by_category";
//    }
//    @GetMapping("/getProductByName")
//    public String getProductByName(@RequestParam(name="name")String name, Model model) {
//        List<Product> products = orderService.getByName(name);
//        model.addAttribute("products", products);
//        return "show_product";
//    }
//        @GetMapping("/getProductByCategory")
//    public String getProductByCategory(@RequestParam(name="category")String category, Model model) {
//        List<Product> products = orderService.getByCategory(category);
//
//        model.addAttribute("products", products);
//
//        return "show_product";
//    }
    
    //TIMUR
//    @RequestMapping(value = "/newProductForm", method = RequestMethod.GET)
//    public String showNewProductForm(Model model) {
//        Product product = new Product();
//        model.addAttribute("product", product);
//        List<String> options = new ArrayList<String>();
//        options.add("Devices and Electronics");
//        options.add("Books and Reading");
//        options.add("Groceries & Drinks");
//        model.addAttribute("options", options);
//        return "addProductForm";
//    }
//    @RequestMapping(value = "/addProduct", method = RequestMethod.POST)
//    public String addProduct(@ModelAttribute("product") Product product, Model model) {
//        orderService.saveProduct(product);
//        return "redirect:/home";
//    }
    
    //PRUTHVI
    
}
