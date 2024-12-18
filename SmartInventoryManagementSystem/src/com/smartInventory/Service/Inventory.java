package com.smartInventory.Service;

// Here in this class i will be adding, deleting and viewing my product and checking for shortage of product

import java.util.*;
import com.smartInventory.Model.Product;
public class Inventory {

    private HashMap<String, Product> products;  //storing products with product id as key

    public Inventory(){
        products = new HashMap<>();
    }


    // Add products

    public boolean addProduct(Product product){

        if(products.containsKey(product.getProductId())){
            return false;
        }

        products.put(product.getProductId(),product);
        return true;
    }

    // Deleting a product

    public boolean deleteProduct(String productID){

        if(!products.containsKey(productID)){
            return false;
        }

        products.remove(productID);
        return true;
    }

    //Retrieve all products in inventory


    public HashMap<String, Product> getProducts() {
        return products;
    }

    // Checking for prodcuts below their threshold and adding them in map

    public HashMap<String, Product> getProductsBelowThreshHold(){

        // creating a map to store all products with low threshold ie which are going to be out of stock
        HashMap<String, Product> lowStockProducts = new HashMap<>();

        for(Map.Entry<String,Product>entry : products.entrySet()){
            Product product = entry.getValue();

            if(product.isBelowThreshhold()){
                lowStockProducts.put(entry.getKey(),product);
            }
        }
        return lowStockProducts;
    }
}
