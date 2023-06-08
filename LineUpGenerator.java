/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project2;

import java.util.Random;

/**
 *
 * @author alihabibi
 */
public class LineUpGenerator {
    
    public void generator(){
          Random rand = new Random();
    
          int[] lineup = new int[3]; // array of 3
          int randomNumber = rand.nextInt(3); // random number 0 to 2
        
        // If the random number is 0, generate a 4-3-3 formation
        if (randomNumber == 0) {
            lineup[0] = 4;
            lineup[1] = 3;
            lineup[2] = 3;
        }
        // If the random number is 1, generate a 5-3-2 formation
        if (randomNumber == 1)
        {
            lineup[0] = 5;
            lineup[1] = 3;
            lineup[2] = 2;
        }
        else
            //if the random number is 3, generate a 4-4-2 formation   
        {
            lineup[0] = 4;
            lineup[1] = 4;
            lineup[2] = 2;
        }
        // Print the generated lineup
        System.out.println("Lineup: " + lineup[0] + "-" + lineup[1] + "-" + lineup[2]);
    }
}
