package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Input

{
    public Input() {}

    public String getInput() throws IOException{
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input= reader.readLine();
        
        return input;

    }

}