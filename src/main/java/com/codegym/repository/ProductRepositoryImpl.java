package com.codegym.repository;

import com.codegym.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryImpl implements ProductRepository{

    List<Product> productList = new ArrayList<>();
    {
        productList.add(new Product(1,"Samsung",90,"image a"));
        productList.add(new Product(2,"Iphone",100,"image b"));
        productList.add(new Product(3,"BlackBerry",120,"image c"));
    }


    @Override
    public List<Product> listProduct() {
        return productList;
    }
}
