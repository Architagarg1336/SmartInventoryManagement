package com.smartInventory.UI;
import com.smartInventory.Model.Product;
import com.smartInventory.Service.Inventory;

import java.util.*;
import java.sql.SQLOutput;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

     Inventory inventory = new Inventory();
     Scanner scanner = new Scanner(System.in);

     // sample data;
        inventory.addProduct(new Product("1","Laptop",10,5));
        inventory.addProduct(new Product("2","Phone",5,3));
        inventory.addProduct(new Product("3","Tab",15,10));

        while(true){

            System.out.println("\n-- Smart Inventory Management System --");
            System.out.println("1. Add Product");
            System.out.println("2, View all products");
            System.out.println("3. Remove Product");
            System.out.println("4. Check product below threshold");
            System.out.println("5. Exit");
            System.out.println("Enter your choice");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice){
                case 1:
                    //Add products
                    System.out.println("Enter product Id: ");
                    String productId = scanner.nextLine();
                    System.out.println("Enter product name: ");
                    String name = scanner.nextLine();
                    System.out.println("Enter product quantity: ");
                    int quantity = scanner.nextInt();
                    System.out.println("Enter product threshold: ");
                    int threshold = scanner.nextInt();
                    scanner.nextLine();

                    Product newProduct = new Product(productId,name,quantity,threshold);
                    if(inventory.addProduct(newProduct)){
                        System.out.println("Product added Successfully");
                    }else{
                        System.out.println("Product with this ID already exists");
                    }
                    break;
                case 2:

                    // View all products
                    System.out.println("\n All Products");
                    inventory.getProducts().forEach((id, product)-> System.out.println(product));
                    break;

                case 3:
                    // Remove Product

                    System.out.println("Enter product ID to remove: ");
                    String removeId = scanner.nextLine();
                    if(inventory.deleteProduct(removeId)){
                        System.out.println("Product removed successfully");
                    }else{
                        System.out.println("Product ID not found");
                    }
                    break;

                case 4:
                    System.out.println("\n Products below threshold");
                    inventory.getProductsBelowThreshHold().forEach((id,product)-> System.out.println(product));
                    break;

                case 5:
                    //Exit
                    System.out.println("Exiting....");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choic e please choose again");

            }
        }

    }
}
