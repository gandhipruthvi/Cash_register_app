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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;
    
    //MIKHAIL
    @RequestMapping(value = "/product_home", method = RequestMethod.GET)
    public String getAllProducts(Model model) {
        List<Product> listProducts = productService.getAllProduct();
        model.addAttribute("listProducts", listProducts);
        return "product_home";
    }
    @RequestMapping("/deleteByID/{id}")
    public String deleteCountry(@PathVariable(name="id")Long id) {
        productService.delete(id);
        
        return "redirect:/product_home";
    }
    @GetMapping("/openProductByName")
    public String openProductByName(Model model) {
        return "get_by_name";
    }
    @GetMapping("/openProductByCategory")
    public String openProductByCategory(Model model) {
        List<String> options = new ArrayList<String>();

        options.add("Devices and Electronics");
        options.add("Books and Reading");
        options.add("Groceries & Drinks");

        model.addAttribute("options", options);
        return "get_by_category";
    }
    @GetMapping("/getProductByName")
    public String getProductByName(@RequestParam(name="name")String name, Model model) {
        List<Product> products = productService.getByName(name);
        model.addAttribute("products", products);
        return "show_product";
    }
        @GetMapping("/getProductByCategory")
    public String getProductByCategory(@RequestParam(name="category")String category, Model model) {
        List<Product> products = productService.getByCategory(category);

        model.addAttribute("products", products);

        return "show_product";
    }
    
    //TIMUR
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
        return "redirect:/product_home";
    }

    @RequestMapping(value = "/products/{id}", method = RequestMethod.GET)
    public String showUpdate(@PathVariable( value = "id") String id, Model model) {

        // get event from the service
        Product product = productService.getProductById(Long.valueOf(id));
        model.addAttribute("product", product);
        List<String> options = new ArrayList<String>();
        options.add("Devices and Electronics");
        options.add("Books and Reading");
        options.add("Groceries & Drinks");
        model.addAttribute("options", options);
        return "edit_product";
    }

    @RequestMapping(value = "/products/restock/{id}", method = RequestMethod.GET)
    public String showRestock(@PathVariable( value = "id") String id, Model model) {

        // get event from the service
        Product product = productService.getProductById(Long.valueOf(id));
        model.addAttribute("product", product);
        return "restock";
    }
    
    //PRUTHVI
    
}
