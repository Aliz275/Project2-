/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project2;

/**
 *
 * @author alihabibi
 */
public abstract class dates {
    protected String date;
    
    public dates (String date) // to get the date
    {
        this.date = date;
    }
    
    public String getDate()
    {
        return this.date;
    }
    
    @Override
    public abstract String toString(); // abstract method to be used for the subclasses
}
