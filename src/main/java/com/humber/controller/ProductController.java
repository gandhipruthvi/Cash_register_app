package com.humber.controller;

import com.humber.model.Product;
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

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getAllProducts() {
        //productService.getALlProduct();
        return "home";
    }

    @RequestMapping(value = "/newProductForm", method = RequestMethod.GET)
    public String showNewProductForm(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        List<String> options = new ArrayList<String>();
        options.add("Devices and Electronics");
        options.add("Books and Reading");
        options.add("Groceries & Drinks");
        model.addAttribute("options", options);
        return "addProductForm";
    }

    @RequestMapping(value = "/addProduct", method = RequestMethod.POST)
    public String addProduct(@ModelAttribute("product") Product product, Model model) {
        productService.saveProduct(product);
        return "home";
    }

}
