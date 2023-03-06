/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.techt.inventorymanagementsystem.models;

import com.techt.inventorymanagementsystem.exceptions.InvalidItemIdException;
import com.techt.inventorymanagementsystem.exceptions.InvalidItemQuantity;

/**
 *
 * @author Daksh
 */
public class Item {
    private String id;
    private String name;
    private String description;
    private Integer quantity;

    public Item(String id, String name, String description, Integer quantity) throws InvalidItemQuantity {
        
        // here as well, we need to check if the qty is negative;
        
        if(quantity<0){
            throw new InvalidItemQuantity();
        }
        
        this.id = id;
        this.name = name;
        this.description = description;
        this.quantity = quantity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) throws InvalidItemQuantity {
        // lets check if the quantity is negative, throw an exception
        if(quantity<0){
            throw new InvalidItemQuantity();
        }
        this.quantity = quantity;
    }
    
    
    
    
}
