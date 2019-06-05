package com.aleite.utilities.io.file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Vector;

public class fileReader {
    private BufferedReader input;

    /**
     * This method sets the file to be used when reading data
     * @param filePath Complete path of the file to be read
     */
    public fileReader(String filePath) {
        try {
            this.input = new BufferedReader(new FileReader(filePath));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method sets the stream to be used when reading data
     * @param inputStream Initialized input stream to be read
     */
    public fileReader(InputStream inputStream) {
        this.input = new BufferedReader(new InputStreamReader(inputStream));
    }

    /**
     * This method reads all the data and converts it to a String array
     * @return String[] String array representation of the data in the InputStream
     */
    public String[] read() {
        String[] data = null;

        try {
            if (this.input.ready()) {
                    Vector<String> v = new Vector<>();

                    String line;

                    while ((line = this.input.readLine()) != null) {
                        v.addElement(line);
                    }

                    data = new String[v.size()];
                    data = v.toArray(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    /**
     * This method reads a single line of data and converts it to a String
     * @return String String representation of line read
     */
    public String readLine() {
        String data = null;

        try {
            if (this.input.ready()) {
                data = this.input.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    /**
     * This method closes the BufferedReader used to read data
     */
    public void close() {
        try {
            if (this.input.ready()) {
                this.input.close();
            }
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }
}
