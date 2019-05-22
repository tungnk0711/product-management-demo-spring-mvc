package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.model.ProductForm;
import com.codegym.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
public class ProductController {

    // thu muc luu tru file tren server
    private static String UPLOAD_LOCATION = "/Users/nguyenkhanhtung/Documents/JAVABOOTCAMP/product-manager-demo-spring-mvc/src/main/webapp/WEB-INF/resources/image/";



    @Autowired
    ProductService productService;

    @GetMapping(value = "/list/{name:[a-z]+}")
    public ModelAndView listProduct(@PathVariable String name){

        String res = name;

        ModelAndView modelAndView = new ModelAndView("/index");
        List<Product> productList = productService.listProduct();

        modelAndView.addObject("listProduct", productList);

        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView create(){

        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("productform", new ProductForm());

        return modelAndView;
    }

    @PostMapping("/save-product")
    public ModelAndView saveProduct(@ModelAttribute ProductForm productform){

        // lay ten file
        MultipartFile multipartFile = productform.getImage();
        String fileName = multipartFile.getOriginalFilename();


        // luu file len server
        try {
            FileCopyUtils.copy(productform.getImage().getBytes(), new File(UPLOAD_LOCATION + fileName));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        // tao doi tuong de luu vao db
        Product product = new Product(productform.getId(), productform.getName(), productform.getPrice(), fileName);

        // luu vao db
        //productService.save(productObject);

        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("product", new Product());

        return modelAndView;
    }










}
