/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project2;

/**
 *
 * @author alihabibi
 */
public class PlayersInfo {
    
    private String name;
    private String Position;
    private String PerformanceData;
    
    public PlayersInfo(String name, String position, String Performance) // getting the name, position and the performance of the players.
    {
        this.name = name;
        this.Position = position;
        this.PerformanceData = Performance;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    
    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return Position;
    }

    public void setPosition(String Position) {
        this.Position = Position;
    }

    
    public String getPerformanceData() {
        return PerformanceData;
    }

    public void setPerformanceData(String PerformanceData) {
        this.PerformanceData = PerformanceData;
    }
    
    @Override
    public String toString()  // String to display each method
    {
        return "Player's name: "+name+"\n"+
                "Players Position: "+Position+"\n"+
                "Players Performance Data: "+PerformanceData+"\n\n";
    }
    
}
