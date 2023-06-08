/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project2;

/**
 *
 * @author alihabibi
 */
public class practiceday extends dates{ // subclass of dates
    
    public practiceday(String date) { // getting the date using super function
        super(date);
    }
    
    //it also overrides the "toString" method to return "Practice in the date of: " followed by the date.
    @Override
    public String toString() 
    {
        return "Practice in the date of: "+date;
    }
}
    
    
   
