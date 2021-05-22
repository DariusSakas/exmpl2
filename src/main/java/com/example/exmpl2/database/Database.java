package com.example.exmpl2.database;

import com.example.exmpl2.model.Product;

import java.util.ArrayList;
import java.util.List;

public class Database {
    public static List<Product> createDatabase() {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product(1,"Daktariska desra"));
        productList.add(new Product(2,"Grietine"));
        productList.add(new Product(3,"Salotos"));
        productList.add(new Product(4,"Selenos"));
        productList.add(new Product(5,"Vistiena"));

        return productList;
    }
}
