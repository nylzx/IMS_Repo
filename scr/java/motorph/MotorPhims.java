/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.motorph.motorphims;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
/**
 *
 * @author vhal9
 */
public class MotorPHIMS {

    public static void main(String[] args) throws IOException, InterruptedException {
        motorPHMenu();
    }
    
     public static String spacingInfo (String inputString, int length)
    {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(' ');
        }

        return inputString + sb.substring(inputString.length())  ;

    }
    
 
     private static void motorPHMenu() throws InterruptedException, IOException  {
         
    
        System.out.println("==================================");
        System.out.println("Loading....");
        Thread.sleep(1500);
        System.out.println("Welcome to MotorPH Inventory Management System");
        Thread.sleep(1500);
        System.out.println("==================================");
        System.out.println("Please select from the menu..");
        System.out.println("==================================");
        System.out.println("1. View Products");
        System.out.println("2. View Product Details");
        System.out.println("3. ...");
        System.out.println("4. ...");
     
        
        Scanner opt = new Scanner(System.in);
        System.out.println("==================================");
        Thread.sleep(1500);       
        System.out.print("Enter your selection..: ");
        String select = opt.nextLine();     
        System.out.println("You selected option #" + select);
        selectOpt(select);
        opt.close();
      
    }
     
       private static void selectOpt(String select) throws IOException, InterruptedException {
        switch (select) {
            case "1":
                allProducts();
           
                break;
            case "2":
                productDetails();
                break;
//            case "3":
//                employeeDetails();
//                break;
//            case "4":
//                viewGrossEarnings();
//                break;
//            case "5":
//                viewNetEarnings();
//                break;
          // If inputted wrong information //
            default:
                System.out.println("You entered an incorrect option.");
                Thread.sleep(1500);
                System.out.println("Exiting now......Goodbye");
                break;
        }  
    } 
       
        private static void allProducts() throws IOException, InterruptedException {

       
        List<Products> ProductsList = Products.ProductsList();
         System.out.println(spacingInfo("Date Entered",20) + spacingInfo("Stock Label",20) + spacingInfo("Brand",20) + spacingInfo("Engine Number",20)+ spacingInfo("Status",20));
        for(Products products : ProductsList)
        {
            String Brand =  spacingInfo(products.getBrand(),20);
            String stockLabel = spacingInfo("[" + products.getStockLabel() + "]",20);
            String dateEntered = spacingInfo(products.getDateEntered(),20);
            String engineNumber = spacingInfo(products.getEngineNum(),20);
            String Status = spacingInfo(products.getStatus(),20);
          
                System.out.println(dateEntered + stockLabel + Brand + engineNumber + Status);
        
        }   
        
        System.out.println("==================================");
        System.out.println("Please select from the menu..");
        System.out.println("==================================");
        System.out.println("1. Sort By Brands");
        System.out.println("2. Sort by Date (Descending)");
        System.out.println("3. Sort by Date (Ascending)");
        System.out.println("4. Add Product");
        System.out.println("5. Delete Product");
        System.out.println("6. Exit");
        
        Scanner opt = new Scanner(System.in);
        System.out.println("==================================");      
        System.out.print("Enter your selection..: ");
        String select2 = opt.nextLine();     
        System.out.println("You selected option #" + select2);
        selectOpt2(select2);
        opt.close();
        
    }
        private static void selectOpt2(String select2) throws IOException, InterruptedException {
        switch (select2) {
            case "1":
                sortByBrand();
                break;
            case "2":
                sortByDateDescending();
                break;
            case "3":
                sortByDateAscending();
                break;
            case "4":
                addProduct();
                break;
            case "5":
                deleteProduct();
                break;
            case "6":
                return;
             
          // If inputted wrong information //
            default:
                System.out.println("You entered an incorrect option.");
                Thread.sleep(1500);
                System.out.println("Exiting now......Goodbye");
                break;
        }  
    } 
        
        private static void productDetails() throws IOException {
       
        int MAX_ATTEMPTS = 3;
        int attempts = 0;
        boolean cont = true;
  
        while (cont) {
        Scanner scan = new Scanner(System.in);
       
        System.out.print("Enter Engine Number: ");
        String lookup = scan.nextLine();
        attempts++;
        
       
        if (attempts==MAX_ATTEMPTS) { System.out.println("You have reached the max attempt!"); break; }
            List<Products> ProductsList = Products.ProductsList();
        
        Products product =  ProductsList.stream().filter(prd -> prd.getEngineNum().equals(lookup)).findAny().orElse(null);
     
        
        boolean found = false;
        if (product!=null)
        {
                String dateEntered = product.getDateEntered();
                String stockLabel = product.getStockLabel();
                String Brand = product.getBrand();
                String engineNum = product.getEngineNum();
                String Status = product.getStatus();
                 
                System.out.println("*=================*PRODUCT DETAILS*=================*");
                System.out.print("Date Entered: " + dateEntered); System.out.println("     " + "Stock Label: " + stockLabel);
                System.out.print("Brand: " + Brand); System.out.println("     " + "Engine Number: " +  engineNum); 
                System.out.println("     " + "Status: " + Status);
                System.out.println("*=================*=============*=================*");
                System.out.println("Thank you for using the MotorPH Inventory Management System!");
                
                break;
        }
        else
        {
                   System.out.println("Invalid Engine Number...");   
        }
         cont = !found; 
        }
    }
        
        private static void sortByBrand() throws IOException, InterruptedException {
        
            List<Products> ProductsList = Products.ProductsList();
            
            Comparator <Products> compareByBrand = (Products o1, Products o2)-> o1.getBrand().compareTo(o2.getBrand());
            
            Collections.sort(ProductsList, compareByBrand);
            
            System.out.println(spacingInfo("Date Entered",20) + spacingInfo("Stock Label",20) + spacingInfo("Brand",20) + spacingInfo("Engine Number",20)+ spacingInfo("Status",20));
        for(Products products : ProductsList)
        {
            String Brand =  spacingInfo(products.getBrand(),20);
            String stockLabel = spacingInfo("[" + products.getStockLabel() + "]",20);
            String dateEntered = spacingInfo(products.getDateEntered(),20);
            String engineNumber = spacingInfo(products.getEngineNum(),20);
            String Status = spacingInfo(products.getStatus(),20);
          
                System.out.println(dateEntered + stockLabel + Brand + engineNumber + Status);
        
        } 
        
        System.out.println("==================================");
        System.out.println("Please select from the menu..");
        System.out.println("==================================");
        System.out.println("1. Sort By Brands");
        System.out.println("2. Sort by Date (Descending)");
        System.out.println("3. Sort by Date (Ascending)");
        System.out.println("4. Add Product");
        System.out.println("5. Delete Product");
        System.out.println("6. Exit");
        
        Scanner opt = new Scanner(System.in);
        System.out.println("==================================");      
        System.out.print("Enter your selection..: ");
        String select2 = opt.nextLine();     
        System.out.println("You selected option #" + select2);
        selectOpt2(select2);
        opt.close();
            
       
  
        }
        
        private static void sortByDateDescending() throws IOException, InterruptedException {
        
           List<Products> ProductsList = Products.ProductsList();
            
            Comparator <Products> compareByDate = (Products o1, Products o2)-> o1.getDateEntered().compareTo(o2.getDateEntered());
            
            Collections.sort(ProductsList, compareByDate.reversed());
            
            System.out.println(spacingInfo("Date Entered",20) + spacingInfo("Stock Label",20) + spacingInfo("Brand",20) + spacingInfo("Engine Number",20)+ spacingInfo("Status",20));
        for(Products products : ProductsList)
        {
            String Brand =  spacingInfo(products.getBrand(),20);
            String stockLabel = spacingInfo("[" + products.getStockLabel() + "]",20);
            String dateEntered = spacingInfo(products.getDateEntered(),20);
            String engineNumber = spacingInfo(products.getEngineNum(),20);
            String Status = spacingInfo(products.getStatus(),20);
          
                System.out.println(dateEntered + stockLabel + Brand + engineNumber + Status);
        
        }      
        
        System.out.println("==================================");
        System.out.println("Please select from the menu..");
        System.out.println("==================================");
        System.out.println("1. Sort By Brands");
        System.out.println("2. Sort by Date (Descending)");
        System.out.println("3. Sort by Date (Ascending)");
        System.out.println("4. Add Product");
        System.out.println("5. Delete Product");
        System.out.println("6. Exit");
        
        Scanner opt = new Scanner(System.in);
        System.out.println("==================================");      
        System.out.print("Enter your selection..: ");
        String select2 = opt.nextLine();     
        System.out.println("You selected option #" + select2);
        selectOpt2(select2);
        opt.close();
        
        }
        
        private static void sortByDateAscending() throws IOException, InterruptedException {
        
           List<Products> ProductsList = Products.ProductsList();
            
            Comparator <Products> compareByDate = (Products o1, Products o2)-> o1.getDateEntered().compareTo(o2.getDateEntered());
            
            Collections.sort(ProductsList, compareByDate);
            
            System.out.println(spacingInfo("Date Entered",20) + spacingInfo("Stock Label",20) + spacingInfo("Brand",20) + spacingInfo("Engine Number",20)+ spacingInfo("Status",20));
        for(Products products : ProductsList)
        {
            String Brand =  spacingInfo(products.getBrand(),20);
            String stockLabel = spacingInfo("[" + products.getStockLabel() + "]",20);
            String dateEntered = spacingInfo(products.getDateEntered(),20);
            String engineNumber = spacingInfo(products.getEngineNum(),20);
            String Status = spacingInfo(products.getStatus(),20);
          
                System.out.println(dateEntered + stockLabel + Brand + engineNumber + Status);
        
        }
        
        System.out.println("==================================");
        System.out.println("Please select from the menu..");
        System.out.println("==================================");
        System.out.println("1. Sort By Brands");
        System.out.println("2. Sort by Date (Descending)");
        System.out.println("3. Sort by Date (Ascending)");
        System.out.println("4. Add Product");
        System.out.println("5. Delete Product");
        System.out.println("6. Exit");
        
        Scanner opt = new Scanner(System.in);
        System.out.println("==================================");      
        System.out.print("Enter your selection..: ");
        String select2 = opt.nextLine();     
        System.out.println("You selected option #" + select2);
        selectOpt2(select2);
        opt.close();
        
        }
        
        private static void addProduct() throws IOException, InterruptedException {
        
        try {
        
        FileWriter obj = new FileWriter("src\\MotorPHInventoryDataMarch2023.csv", true);
       
        Scanner opt = new Scanner(System.in);
        System.out.println("==================================");      
        System.out.print("Enter date today (dd/mm/yyyy): ");
        String Date = opt.nextLine();
        System.out.print("New or Old?: ");
        String stockLabel = opt.nextLine();
        System.out.print("Brand Name: ");
        String Brand = opt.nextLine();
        System.out.print("Engine Number: ");
        String enginNumber = opt.nextLine();
        System.out.print("Status (Sold or On-Hand): ");
        String status = opt.nextLine();
        
       
        obj.write(Date + "," + stockLabel + "," + Brand + "," + enginNumber + "," + status);  
        opt.close();
        obj.close();
        
        }
        catch (IOException e) {
        
        }
        
        System.out.println("==================================");
        System.out.println("Please select from the menu..");
        System.out.println("==================================");
        System.out.println("1. Sort By Brands");
        System.out.println("2. Sort by Date (Descending)");
        System.out.println("3. Sort by Date (Ascending)");
        System.out.println("4. Add Product");
        System.out.println("5. Delete Product");
        System.out.println("6. Exit");
        
        Scanner opt = new Scanner(System.in);
        System.out.println("==================================");      
        System.out.print("Enter your selection..: ");
        String select2 = opt.nextLine();     
        System.out.println("You selected option #" + select2);
        selectOpt2(select2);
        opt.close();
        
        
        }
        
        private static void deleteProduct() throws IOException, InterruptedException {
        
        List<Products> ProductsList = Products.ProductsList();
        
        Scanner opt = new Scanner(System.in);
        System.out.print("Give me the engine number to delete");
        System.out.print("========================DISCLAIMER========================");
        System.out.print("This will delete all data connected to this engine number");
        System.out.print("==========================================================");
        System.out.print("Engine Number: ");
        String lookup = opt.nextLine();
        var x = ProductsList.stream().filter(prd -> prd.getEngineNum().equals(lookup)).findAny().orElse(null);
        
        if(x!=null){
          ProductsList.remove(x);
          
          FileWriter obj = new FileWriter("src\\MotorPHInventoryDataMarch2023.csv");
          
        for(Products y : ProductsList)
        {
           obj.write(y.getDateEntered() + "," + y.getStockLabel() + "," + y.getBrand() + "," + y.getEngineNum() + "," + y.getStatus() + "\n");  
        
        }
    
        obj.close();
        }
        else{
         
        System.out.println("This Product has already been deleted");
            
        }
        
        }
        
        
        
}
