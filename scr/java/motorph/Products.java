/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.motorph.motorphims;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
//import java.time.LocalDate;
//import java.time.LocalTime;
//import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vhal9
 */
public class Products {
    
    private String dateEntered;
    private String stockLabel;
    private String Brand;
    private String engineNum;
    private String status;
    
    public void setDateEntered(String dateEntered) {
        this.dateEntered = dateEntered;
    }
    
    public String getDateEntered(){
        
        return dateEntered;
    }
    
    public void setStockLabel(String stockLabel) {
        this.stockLabel = stockLabel;
    }
    
    public String getStockLabel(){
        
        return stockLabel;
    }
    
    public void setBrand(String Brand) {
        this.Brand = Brand;
    }
    
    public String getBrand(){
        
        return Brand;
    }
    
    public void setEngineNum(String engineNum) {
        this.engineNum = engineNum;
    }
    
    public String getEngineNum(){
        
        return engineNum;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    public String getStatus(){
        
        return status;
    }
    
    public static List<Products> ProductsList() {

        try {

            String filePath = "src\\MotorPHInventoryDataMarch2023.csv";
            BufferedReader br = new BufferedReader(new FileReader(filePath));

//            DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy"); // FORMAT FOR DATE
////        DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("HH:mm");      // FORMAT FOR TIME

            String str;
            List<Products> ProductsList = new ArrayList<>();

            while ((str = br.readLine()) != null) {

                var values = str.split(",");

                var Products = new Products();
                Products.setDateEntered(values[0]);
                Products.setStockLabel(values[1]);
                Products.setBrand(values[2]);
                Products.setEngineNum(values[3]);
                Products.setStatus(values[4]);

                ProductsList.add(Products);

            }
            return ProductsList;
        } catch (IOException e) {
            return null;

        }
      
    } 
    
    
}
