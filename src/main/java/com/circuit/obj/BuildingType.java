/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.circuit.obj;

/**
 *
 * @author Marvin
 */
public enum BuildingType {
    
     OWNED("Owned"),
    RENTED("Rented");
    
    private final String name;
    
    private BuildingType(String s)
    {
        name = s;
    }
    
    public String toString()
    {
        return name;
    }
    
}
