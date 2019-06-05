package com.aleite.utilities.io.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

public class fileWriter {

    private PrintStream ps;
    private FileOutputStream fos;
    private boolean writerReady;

    /**
     * This method opens a stream to the desired file
     * @param filePath Complete path of the file to be written
     */
    public fileWriter(String filePath) {
        this.writerReady= false;
        if(filePath!=null){

            try {
                File file= new File(filePath);
                this.fos = new FileOutputStream(file);
                this.ps= new PrintStream(this.fos);
                this.writerReady= true;
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
        }
    }

    /**
     * This method stored the initialized Output stream to be used when writing data
     * @param outputStream Initialized OutputStream to be used
     */
    public fileWriter(OutputStream outputStream){
        this.writerReady= true;

        this.ps= new PrintStream(outputStream);
    }

    /**
     * This method writes the data and closes the stream
     * @param data Data to be written
     * @return boolean Returns true if data was written or false if an error occurred
     */
    public boolean write(String data){
        boolean status= false;

        if((this.writerReady)&&(data!=null)){
            try{
                if(data.length()>0){
                    this.ps.println(data);
                }

                this.ps.close();

                if(this.fos!=null){
                    this.fos.close();
                }

                status= true;

            }catch(IOException e){
                e.printStackTrace();
            }
        }
        return status;

    }

    /**
     * This method writes a single line to the stream
     * @param data Data to be written
     * @return boolean Returns true if data was written or false if an error occurred
     */
    public boolean writeLine(String data){
        boolean status= false;

        if((this.writerReady)&&(data!=null)){

            if(data.length()>0){
                this.ps.println(data);

                status= true;
            }
        }

        return status;
    }

    /**
     * This method closes the stream used to write data
     * @return boolean Returns true if was closed or false if an error occurred
     */
    public boolean closeFile(){
        boolean status= false;

        if(this.writerReady){
            try{
                if(this.fos!=null){
                    this.fos.close();
                }

                status= true;
            }catch(IOException e){
                e.printStackTrace();
            }
        }

        return status;
    }
}
