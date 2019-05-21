package com.codegym.repository;

import com.codegym.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryImpl implements ProductRepository{

    List<Product> productList = new ArrayList<>();
    {
        productList.add(new Product(1,"Samsung",90));
        productList.add(new Product(2,"Iphone",100));
        productList.add(new Product(3,"BlackBerry",120));
    }


    @Override
    public List<Product> listProduct() {
        return productList;
    }
}
