package utils;

import java.io.*;
import java.util.Scanner;

public class Scan {

    static String raw;

    static File file;

    static Scanner reader;

    public static String scan(String filePath) throws IOException {

        // creates a blank raw string for later safety
        raw = "";

        // attempts to find the file and create a scanner to read it,
        try {

            file = new File(filePath);

            reader = new Scanner(file); 

            while(reader.hasNextLine()) {

                raw += reader.nextLine();

            }

        } catch (Exception e) {

            System.out.print("File not found: " + filePath);

        }

        return raw;

    }

}