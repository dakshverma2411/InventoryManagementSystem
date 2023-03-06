/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.techt.inventorymanagementsystem.models;

import com.techt.inventorymanagementsystem.exceptions.InvalidItemIdException;
import com.techt.inventorymanagementsystem.exceptions.InvalidItemQuantity;
import com.techt.inventorymanagementsystem.services.IdGenerationService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Daksh
 */
public class Inventory {
    
    private static Inventory instance = null;
    
    public static Inventory getInstance(){
        if(instance == null){
            instance = new Inventory();
        }
        return instance;
    }
    
    private IdGenerationService idGenerationService = null;
    
    // we should use map since it will perform search, insertion and deletion in O(1) time
    // key is the id, value is the item
    private Map<String, Item> items;
    

    // constructors are private in singleton pattern
    private Inventory() {
        idGenerationService = new IdGenerationService();
        items = new HashMap<>();
    }
    
    
    
    // returns the item added
    public Item addItem(String name, String description, Integer quantity) throws InvalidItemQuantity{
        
        // create a new id
        String id = idGenerationService.getNewId();
        Item item = new Item(id, name, description, quantity);
        // we need a container to store the items.
        items.put(id, item);
        return item;
    }
    
    public void removeItem(String itemId) throws InvalidItemIdException{
        // check if item exists;
        if(items.containsKey(itemId)){
            items.remove(itemId);
            return;
        }
        // if item is not present, throw exception
        throw new InvalidItemIdException();
    }
    
    // return updated Item
    public Item updateItem(String itemId, String name, String description, Integer quantity) throws InvalidItemIdException, InvalidItemQuantity{
        // check if the item already exists, otherwise throw error
        if(items.containsKey(itemId)){
            Item item = getItem(itemId);
            item.setName(name);
            item.setDescription(description);
            item.setQuantity(quantity);
            items.put(itemId, item);
            return item;
        }
        // if item is not present, throw exception
        throw new InvalidItemIdException();
    }
    
    
    public Item getItem(String itemId) throws InvalidItemIdException{
        // check if item exists;
        if(items.containsKey(itemId)){
            return items.get(itemId);
        }
        // throw exception if not found
        throw new InvalidItemIdException();
    }
    
    public List<Item> getInventory(){
        // convert the values stored in the hashmap in list
        return new ArrayList<>(items.values());
    }
    
}

// lets write some unit tests for our code. 
