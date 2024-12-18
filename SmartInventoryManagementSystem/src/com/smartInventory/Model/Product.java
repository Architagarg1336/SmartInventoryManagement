package com.smartInventory.Model;

// This file contains my product details, attributes , getters and setters

public class Product {

    private String productId;
    private String productName;
    private int productQuantity;
    private int ProductThreshhold;    // minimum quantity before threshhold is triggered

    public Product(String productId,String productName, int productQuantity , int threshhold){
        this.productId = productId;
        this.productName = productName;
        this.productQuantity = productQuantity;
        this.ProductThreshhold = threshhold;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName(){
        return productName;
    }

    public void setProductName(String productName){
        this.productName = productName;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public int getProductThreshhold() {
        return ProductThreshhold;
    }

    public void setProductThreshhold(int productThreshhold) {
        this.ProductThreshhold = productThreshhold;
    }

    public boolean isBelowThreshhold(){
        return productQuantity<ProductThreshhold;
    }

    @Override
    public String toString(){
        return "Product ID :" +  productId +
                ", Product Name :" + productName +
                ", Product Quantity : " + productQuantity +
                ", Product ThreshHold : " + ProductThreshhold ;
    }
}
