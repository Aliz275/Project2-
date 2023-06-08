/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project2;

/**
 *
 * @author User
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class FootballSystemGUI {

    private ArrayList<PlayersInfo> players;
    private Team team;
    private dates prac;
    private dates gameday;
    private LineUpGenerator gen;
    private JTextArea rosterTextArea;
    private static FootballSystemGUI instance;

    public FootballSystemGUI() {
        players = new ArrayList<PlayersInfo>();
        players.add(new PlayersInfo("Ali", "Striker", "injured"));
        players.add(new PlayersInfo("John", "Midfielder", "Recovering.."));
        players.add(new PlayersInfo("Farred", "Defender", "Ready"));

        team = new Team("team1", players);

        prac = new practiceday("08/11/24");
        gameday = new gameday("06/12/24");
        gen = new LineUpGenerator();

        JFrame frame = new JFrame("Centralized System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 300);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        rosterTextArea = new JTextArea();
        rosterTextArea.setEditable(false);
        mainPanel.add(new JScrollPane(rosterTextArea), BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        JButton roasterButton = new JButton("Team Roaster");
        roasterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayRoster();
            }
        });
        buttonPanel.add(roasterButton);

        JButton practiceButton = new JButton("Team Practice Day");
        practiceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, prac.toString(), "Practice Day", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        buttonPanel.add(practiceButton);

        JButton gameButton = new JButton("Team Game Day");
        gameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, gameday.toString(), "Game Day", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        buttonPanel.add(gameButton);
        
        JButton removeButton = new JButton("Remove Player");
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removePlayer();
            }
        });
        buttonPanel.add(removeButton);

        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
        frame.getContentPane().add(mainPanel);
        frame.setVisible(true);
    }
    
    

    private void removePlayer() {
        String[] playerNames = team.getPlayerNames();
        String playerName = (String) JOptionPane.showInputDialog(null, "Select a player to remove:", "Remove Player",
                JOptionPane.QUESTION_MESSAGE, null, playerNames, playerNames[0]);

        if (playerName != null) {
            team.removePlayer(playerName);
            JOptionPane.showMessageDialog(null, "Player removed successfully!", "Player Removed", JOptionPane.INFORMATION_MESSAGE);
            displayRoster();
        }
    }
    private void displayRoster() {
        StringBuilder roster = new StringBuilder("Current lineup:\n");
        roster.append(team.getRoster());
        rosterTextArea.setText(roster.toString());

        String[] options = {"Choose Player", "Register Player"};
        int choice = JOptionPane.showOptionDialog(null, "Do you want to choose a player from the available players or register a new player?",
                "Choose an option", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

        if (choice == 0) {
            String[] positions = {"Defender", "Midfielder", "Striker", "GoalKeeper"};
            String position = (String) JOptionPane.showInputDialog(null, "Select the player position:", "Choose Position",
                    JOptionPane.QUESTION_MESSAGE, null, positions, positions[0]);

            PlayersInfo newPlayer = null;
            if ("Defender".equalsIgnoreCase(position)) {
                newPlayer = new PlayersInfo("Yamin", "Defender", "Recovering(will be back in 2 months)");
            } else if ("Striker".equalsIgnoreCase(position)) {
                newPlayer = new PlayersInfo("Brian", "Striker", "Ready");
            } else if ("GoalKeeper".equalsIgnoreCase(position)) {
                newPlayer = new PlayersInfo("Jay", "GoalKeeper", "Ready");
            } else if ("Midfielder".equalsIgnoreCase(position)) {
                newPlayer = new PlayersInfo("Sena", "Midfielder", "Ready");
            }

            if (newPlayer != null) {
                players.add(newPlayer);
                rosterTextArea.append("\n" + newPlayer + " has been added to the team");
            }
        } else if (choice == 1) {
            String name = JOptionPane.showInputDialog("Enter the name of the player:");
            String position = JOptionPane.showInputDialog("Enter the position of the player:");

            PlayersInfo newPlayer = new PlayersInfo(name, position, null);
            players.add(newPlayer);
            rosterTextArea.append("\n" + newPlayer + " has been added to the team");
        }
    }
    public static FootballSystemGUI getInstance() {
        if (instance == null) {
            instance = new FootballSystemGUI();
        }
        return instance;
    }

    private void writeToFile(String filename, String content) throws IOException {
        FileWriter writer = new FileWriter(filename);
        writer.write(content);
        writer.close();
    }

    private String readFromFile(String filename) throws FileNotFoundException {
        File file = new File(filename);
        Scanner scanner = new Scanner(file);
        StringBuilder content = new StringBuilder();

        while (scanner.hasNextLine()) {
            content.append(scanner.nextLine()).append("\n");
        }

        scanner.close();
        return content.toString();
    }

    public static void main(String[] args) throws SQLException {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                FootballSystemGUI.getInstance(); // Get the instance using the Singleton pattern
            }
        });
        
        try
        {
            
        String databaseURL = "jdbc:derby:D:/Derby/FootballSystem;create=true";
        Connection con = DriverManager.getConnection(databaseURL);
        } catch(SQLException ex)
        {
            ex.printStackTrace();
        }
    }
}
/*The Singleton pattern ensures that 
only one instance of the class can 
be created and provides a global point
of access to that instance.


By using the Singleton pattern,
you can ensure that there is a single 
instance of the FootballSystemGUI class, 
allowing consistent access to the GUI functionality 
and preventing multiple instances from being created accidentally.*/