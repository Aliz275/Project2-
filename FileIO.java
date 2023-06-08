/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project2;

/**
 *
 * @author alihabibi
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
public class FileIO {
    
    //The writeToFile method takes a filename and data to be written as input and writes 
    //the data to the file with the specified filename.
    
    public static void writeToFile(String filename, String data) {
        //PrintWriter pw = new PrintWriter (new BufferedOutPutStream((new FileOutputStream("filename")));
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(new FileOutputStream(filename,true));
            writer.write(data);
        } catch (IOException e) {
             System.out.println(e.getMessage());
        } finally {
            if (writer != null) {
                writer.close();
            }
            writer.close();
        }
    }
    /*The readFromFile method takes a filename
    as input and reads the contents of the file with the specified filename and returns it as a string.*/

    public static String readFromFile(String filename) {
    BufferedReader reader = null;
    StringBuilder stringBuilder = new StringBuilder();
    try {
        File file = new File(filename);
        reader = new BufferedReader(new FileReader(file));
        String line = reader.readLine();
        while (line != null) {
            stringBuilder.append(line);
            stringBuilder.append(System.lineSeparator());
            line = reader.readLine();
        }
    } catch (IOException e) {
        System.out.println(e.getMessage());
    } finally {
        try {
            if (reader != null) {
                reader.close();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    return stringBuilder.toString();
    }
}
