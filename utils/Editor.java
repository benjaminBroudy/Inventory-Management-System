package utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Editor {

    public Editor() {}

    public void write(String fileName, String message) throws IOException {

    BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
    writer.write(message);
     
    writer.close();
    
}

}
