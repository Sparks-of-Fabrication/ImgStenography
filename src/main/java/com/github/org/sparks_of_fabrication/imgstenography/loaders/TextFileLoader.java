/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.github.org.sparks_of_fabrication.imgstenography.loaders;

import java.awt.Component;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author petko
 */
public class TextFileLoader implements LoaderSolver<String> {
    
    private File textFile;
    private FileOutput fileOutput;
    
    private class FileOutput {
        private StringBuilder text;
        private int lines;
        private int chars;

        public FileOutput() {
            this.text = new StringBuilder();
            this.lines = 0;
            this.chars = 0;
        }
        
        private void readThrough(File file) throws FileNotFoundException {
            try(Scanner scanner = new Scanner(file).useDelimiter("")) {
                while(scanner.hasNext()) {
                    char tChar = scanner.next().charAt(0);
                    
                    chars++;
                    if(tChar == '\n') {
                        lines++;
                    }
                    
                    text.append(tChar);
                }
            }
        }

        public int getChars() {
            return chars;
        }

        public int getLines() {
            return lines;
        }

        public StringBuilder getText() {
            return text;
        }
    }
    
    public FileMetadata getFileOutputMetadata() {
        return new FileMetadata(textFile.getName(), fileOutput.getChars(), fileOutput.getLines(), getExt(this.textFile));
    }

    public TextFileLoader() {
        this.fileOutput = new FileOutput();
    }

    @Override
    public boolean setFile(Component owner, File file) {
        String ext = getExt(file);
        
        if(ext.equals("txt")) {
            try{
                this.textFile = file;
                this.fileOutput.readThrough(file);
            } catch(FileNotFoundException exception) {
                JOptionPane.showMessageDialog(owner, exception.getMessage() , "Invalid File", JOptionPane.ERROR_MESSAGE);
                exception.printStackTrace();
            }
            return true;
        }
        
         JOptionPane.showMessageDialog(owner, "The selected file is not a supported image format.", "Invalid File", JOptionPane.ERROR_MESSAGE);
        return false;
    }

    @Override
    public boolean setFile(File file) {
        String ext = getExt(file);
        
        if(ext.equals("txt")) {
            try{
                this.textFile = file;
                this.fileOutput.readThrough(file);
            } catch(FileNotFoundException exception) {
                exception.printStackTrace();
            }
            return true;
        }
        
        return false;
    }

    @Override
    public File getFile() {
        return this.textFile;
    }

    @Override
    public String convertIntoSolver() {
        return this.fileOutput.getText().toString();
    }

    @Override
    public void flush() {
        textFile = new File("");
        fileOutput = new FileOutput();
    }
    
}
