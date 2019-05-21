package com.codegym.service;

import com.codegym.model.Product;
import com.codegym.repository.ProductRepository;
import com.codegym.repository.ProductRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProductServiceImpl implements ProductService{


    @Autowired
    ProductRepository productRepository;

    @Override
    public List<Product> listProduct() {
        return productRepository.listProduct();
    }
}
