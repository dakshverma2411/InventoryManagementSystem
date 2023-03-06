/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.techt.inventorymanagementsystem.services;

/**
 *
 * @author Daksh
 */
public class IdGenerationService {
    
    private static Integer counter = 0;
    
    public String getNewId(){
        
        // currently using a normal variable to create ids, 
        // in an complex application we can use hashing and timestamp techniques to generate new IDs
        // assuming the application is single threaded. if application is multiple threaded (simultaneous updation of inventory by multiple users), locks should be used
        counter++;
        return counter.toString();
    }
    
}
