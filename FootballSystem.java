/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project2;

/**
 *
 * @author alihabibi
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author alihabibi
 */
public class FootballSystem {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        ArrayList<PlayersInfo> players = new ArrayList<PlayersInfo>();
        
        //adding players to the list
        players.add(new PlayersInfo("Ali","Striker"," injured"));
        players.add(new PlayersInfo("John","Midfielder","Recovering.."));
        players.add(new PlayersInfo("Farred","Defender","Ready"));

        
        //making a new team
        Team team = new Team("team1",players);
        
        //calling the practiceday class within the dates class
        dates prac = new practiceday("08/11/24");
        
        //calling the gameday class within the dates class
        dates gameday = new gameday("06/12/24");
      
       // linup generator 
      LineUpGenerator gen = new LineUpGenerator();
      gen.generator();
      
      Scanner scan = new Scanner(System.in);
      int quit = 0;
     
      
      
      
         while (quit == 0) {
            try {
                System.out.println("");
                System.out.println("Choose an option");
                System.out.println("1. Team Roaster");
                System.out.println("2. Team Practice day");
                System.out.println("3. Team game day");
                System.out.println("4. Team game/practice day booking");
                System.out.println("5. Team game/practice day cancellation");
                System.out.println("6. Check booking details");
                System.out.println("7. Show more information about team game time and the number of people");
                System.out.println("8. Quit");

                int input = scan.nextInt();
                switch (input) {
                    case 1:
                        System.out.println("Current lineup:");
                        System.out.println(team.getRoster());

                        System.out.println("Do you want to choose a player from the available players? (Type 'y')\nTo register a player, type 'n'");
                        System.out.println("To remove a player from the roaster (type 'r')");
                        String newplayer = scan.next();

                        if ("y".equalsIgnoreCase(newplayer)) {
                            System.out.println("What position does the player require? (Defender, Midfielder, Striker, GoalKeeper)");
                            String position = scan.next();

                            if ("Defender".equalsIgnoreCase(position)) {
                                PlayersInfo newPlayer = new PlayersInfo("Yamin", "Defender", "Recovering(will be back in 2 months)");
                                players.add(newPlayer);
                                System.out.println("Updated Roaster:");
                                System.out.println(team.getRoster() + newPlayer + " has been added to the team");
                            } else if ("Striker".equalsIgnoreCase(position)) {
                                PlayersInfo newPlayer = new PlayersInfo("Brian", "Striker", "Ready");
                                players.add(newPlayer);
                                System.out.println("Updated Roaster:");
                                System.out.println(team.getRoster() + newPlayer + " has been added to the team");
                            } else if ("GoalKeeper".equalsIgnoreCase(position)) {
                                PlayersInfo newPlayer = new PlayersInfo("Jay", "GoalKeeper", "Ready");
                                players.add(newPlayer);
                                System.out.println("Updated Roaster:");
                                System.out.println(team.getRoster() + newPlayer + " has been added to the team");
                            } else if ("Midfielder".equalsIgnoreCase(position)) {
                                PlayersInfo newPlayer = new PlayersInfo("Sena", "Midfielder", "Ready");
                                players.add(newPlayer);
                                System.out.println("Updated Roaster:");
                                System.out.println(team.getRoster() + newPlayer + " has been added to the team");
                            } else {
                                System.out.println("Invalid position entered.");
                            }
                        } else if ("n".equalsIgnoreCase(newplayer)) {
                            System.out.println("What is the name of the player?");
                            String name = scan.next();

                            System.out.println("What is the position of the player?");
                            String position = scan.next();

                            PlayersInfo newPlayer = new PlayersInfo(name, position, null);
                            players.add(newPlayer);
                            System.out.println("Updated Roaster:");
                            System.out.println(team.getRoster() + newPlayer + " has been added to the team");
                        } else if("r".equalsIgnoreCase(newplayer))
                        {
                            System.out.println("What is the name of the player?");
                            String name = scan.next();
                            
                            System.out.println("What is the position of the player?");
                            String position = scan.next();
                            team.removePlayer(name, position);
                        }
                        
                        else {
                            System.out.println("Invalid input. Please enter 'y' or 'n'.");
                        }

                        break;
                    case 2:
                        System.out.println(prac);
                        break;
                    case 3:
                        System.out.println(gameday);
                        break;
                    case 4:
                        System.out.println("Enter the date for booking (MM/dd/yy):");
                        String bookingDate = scan.next();
                        System.out.println("Enter the number of people for the booking:");
                        int numPeople = scan.nextInt();

                        BookingInfo bookingInfo = new BookingInfo(bookingDate, numPeople);
                        team.bookGameOrPracticeDay(bookingInfo,true);
                        System.out.println("Booking successful.");
                        
                        break;
                    case 5:
                        System.out.println("Enter the date for cancellation (MM/dd/yy):");
                        String cancellationDate = scan.next();
                        team.cancelGameOrPracticeDay(cancellationDate,false);
                        
                          System.out.println("Cancellation successful.");
                        
                        break;
                    case 6:
                        System.out.println(team.getBookingDetails());
                        break;
                    case 7:
                        System.out.println("Team game time: " + gameday.getDate());
                        System.out.println("Number of people: " + team.getNumPlayers());
                        break;
                    case 8:
                        quit = 1;
                        System.out.println("Quitting the program...");
                        break;
                    default:
                        System.out.println();
                        System.out.println("*Invalid input. Please choose a valid option.*");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println();
                System.out.println("*Invalid input. Please enter a numeric value.*");
                scan.nextLine();
            }

        }
        // Write data to a file
        String content ="";

        for (PlayersInfo player : players)
        {
            content += player.getName()+ "\n";
        }
        String filename = "textfile.txt";
        String roster = content;
        FileIO.writeToFile(filename, roster);

         //Read data from a file
        String display = FileIO.readFromFile(filename);
        System.out.println(display);
        System.out.println("That is the final Roster");
          }
      }
    

    

