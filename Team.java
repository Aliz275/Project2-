/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project2;

import java.util.ArrayList;
import java.util.Iterator;
/**
 *
 * @author alihabibi
 */
public class Team {
    
    public String name;
    public ArrayList<PlayersInfo> players;
    public ArrayList<gameday> gameday;
    public ArrayList<practiceday> practiceday;
    private ArrayList<BookingInfo> gameBookings;
    private ArrayList<BookingInfo> practiceBookings;
    private ArrayList<BookingInfo> bookings;
    
    // constructor that takes the team name and a list of player information
    public Team(String name, ArrayList<PlayersInfo> players) {
        this.name = name;
        this.players = players;
        this.gameday = new ArrayList<>();
        this.practiceday = new ArrayList<>();
        this.bookings = new ArrayList<>(); // Initialize the bookings ArrayList
    }
    
    //add a player
    public void addplayer(PlayersInfo player)
    {   
        players.add(player);
    }
    public void removePlayer(String playerName) {
        for (int i = 0; i < players.size(); i++) {
            PlayersInfo player = players.get(i);
            if (player.getName().equalsIgnoreCase(playerName)) {
                players.remove(i);
                break;
            }
        }
    }
    
    public String[] getPlayerNames() {
        String[] playerNames = new String[players.size()];
        for (int i = 0; i < players.size(); i++) {
            playerNames[i] = players.get(i).getName();
        }
        return playerNames;
    }
    
    //get the team roster
     public String getRoster() {
        StringBuilder sb = new StringBuilder(); // to bulid the output
        for (PlayersInfo player : players) {   // iterate through list of players
            System.out.println(player.getName());
        }
        return sb.toString();
    }
    
      public void bookGameOrPracticeDay(BookingInfo bookingInfo, boolean isGameDay) {
        bookings.add(bookingInfo);
        if (isGameDay) {
            System.out.println("Game day booked: " + bookingInfo.getDate());
        } else {
            System.out.println("Practice day booked: " + bookingInfo.getDate());
        }
    }
      public boolean cancelGameOrPracticeDay(String cancellationDate, boolean isGame) {
        Iterator<gameday> gameIterator = gameday.iterator();
        while (gameIterator.hasNext()) {
            gameday date = gameIterator.next();
            if (date.getDate().equals(cancellationDate)) {
                gameIterator.remove();
                break;
            }
        }

        Iterator<practiceday> practiceIterator = practiceday.iterator();
        while (practiceIterator.hasNext()) {
            practiceday date = practiceIterator.next();
            if (date.getDate().equals(cancellationDate)) {
                practiceIterator.remove();
                break;
            }
        }

        Iterator<BookingInfo> bookingIterator = bookings.iterator();
        while (bookingIterator.hasNext()) {
            BookingInfo booking = bookingIterator.next();
            if (booking.getDate().equals(cancellationDate)) {
                bookingIterator.remove();
                break;
            }
        }

        return true;
    }

    public String getBookings(boolean isGameDay) {
        StringBuilder bookings = new StringBuilder();
        ArrayList<BookingInfo> bookingList = isGameDay ? gameBookings : practiceBookings;
        for (BookingInfo bookingInfo : bookingList) {
            bookings.append("Date: ").append(bookingInfo.getDate())
                    .append(", Number of People: ").append(bookingInfo.getNumPeople())
                    .append("\n");
        }
        return bookings.toString();
    }
    
    public String getBookingDetails() {
        StringBuilder sb = new StringBuilder();
        for (BookingInfo booking : bookings) {
            sb.append(booking.getDate()).append(" - ").append(booking.getNumPeople()).append(" people\n");
        }
        return sb.toString();
    }

    public int getNumPlayers() {
        return players.size();
    }
    
    public void removePlayer(String name, String position) {
    Iterator<PlayersInfo> iterator = players.iterator();
    while (iterator.hasNext()) {
        PlayersInfo player = iterator.next();
        if (player.getName().equals(name) && player.getPosition().equals(position)) {
            iterator.remove();
            System.out.println("Player removed: " + player.getName());
            return; // Exit the method after removing the player
        }
    }
    System.out.println("Player not found in the roster.");
}
    
    
     
     //get the team's schedule.
     public String Schedule()
     {
         StringBuilder sb = new StringBuilder();// to bulid the output
         
         for(gameday date: gameday)  //iterate through list of games
         {
             System.out.println(date.getDate());
         }
         return sb.toString();
     }
}
