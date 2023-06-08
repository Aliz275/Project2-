/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project2;

/**
 *
 * @author alihabibi
 */
public class gameday extends dates{ // subclass of dates
    
    public gameday(String date) // to get the date
    {
        super(date);
    }
    
    // It overrides the "toString" method to return "Game day in: " followed by the date.
    @Override
    public String toString()
    {
        return "Game day in: "+date;
    }
}
