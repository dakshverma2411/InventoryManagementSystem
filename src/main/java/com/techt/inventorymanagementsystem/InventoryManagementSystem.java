/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.techt.inventorymanagementsystem;

import com.techt.inventorymanagementsystem.exceptions.InvalidItemIdException;
import com.techt.inventorymanagementsystem.exceptions.InvalidItemQuantity;
import com.techt.inventorymanagementsystem.models.Inventory;
import com.techt.inventorymanagementsystem.models.Item;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Daksh
 */
public class InventoryManagementSystem {
    
    static Scanner sc = new Scanner(System.in);
    
    private static void printItem(Item item){
        System.out.println("Name: "+item.getName());
        System.out.println("Description: "+item.getDescription());
        System.out.println("Id: "+item.getId());
        System.out.println("Quantity: "+item.getQuantity());
    }
    
    private static String takeInput(String msg){
        System.out.print(msg+": ");
        String input = sc.nextLine();
        return input;
    }
    
    private static void makeLine(){
        System.out.println("----------------------------------");
    }
    

    public static void main(String[] args) {
        // console based code
        
        // run an infinite loop
        Inventory inventory = Inventory.getInstance();
        
        
        while(true){
            try{
            String operation = takeInput("Type add/remove/update/get/getall/exit");
            if(operation.equals("add")){
                String name = takeInput("Name");
                String description = takeInput("Description");
                Integer qty = Integer.parseInt(takeInput("Qty"));
                Item item = inventory.addItem(name, description, qty);
                printItem(item);
                makeLine();
            }
            else if(operation.equals("remove")){
                String id = takeInput("Id");
                inventory.removeItem(id);
                
            }
            else if(operation.equals("update")){
                String id = takeInput("Id");
                String name = takeInput("Name");
                String description = takeInput("Description");
                Integer qty = Integer.parseInt(takeInput("Qty"));
                Item item = inventory.updateItem(id, name, description, qty);
                printItem(item);
                makeLine();
                
            }
            else if(operation.equals("get")){
                String id = takeInput("Id");
                Item item = inventory.getItem(id);
                printItem(item);
                makeLine();
                
                
            }
            else if(operation.equals("getall")){
                
                List<Item> items = inventory.getInventory();
                System.out.println(items.size()+" item found. ");
                for(Item item: items){
                    printItem(item);
                    makeLine();
                }
                
            }
            else if(operation.equals("exit")){
                break;
            }
            }
            catch(InvalidItemIdException e){
                System.out.println("ERROR Invalid Item Id");
            }
            catch(InvalidItemQuantity e){
                System.out.println("ERROR Invalid Item Quantity");
            }
        }
        
    }
}

