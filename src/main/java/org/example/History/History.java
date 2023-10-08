package org.example.History;

import com.sun.istack.internal.Nullable;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class History {
    private ArrayList<String> history;
    private FileWriter writer;
    private String filename = "history.txt";

    History(@Nullable String filename) {
        try{
            this.writer = new FileWriter(filename);
            this.filename = filename;
            }catch (Exception e) {
               System.err.println("Error : " + e.getMessage());
        }
    }

    public void add(String hitory) {
        this.history.add(hitory);
    }

    public void showHistory() {

    }
    public void saveHistory() throws IOException {
        for (String line: this.history ) {
            this.writer.write(line);
        }
        this.writer.close();
    }

}
