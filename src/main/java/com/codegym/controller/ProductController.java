package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.ProductService;
import com.codegym.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ProductController {


    @Autowired
    ProductService productService;

    @RequestMapping("/products")
    public ModelAndView listProductksdshdfkhskfhs(){

        ModelAndView modelAndView = new ModelAndView("/index");
        List<Product> productList = productService.listProduct();

        modelAndView.addObject("listProduct", productList);

        return modelAndView;
    }
}
