    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.github.org.sparks_of_fabrication.imgstenography;

import java.awt.Component;
import java.awt.Dialog;
import java.awt.Window;
import java.io.File;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author petko
 */
public class ImageLoader {
    private static ImageLoader INSTANCE = null;
    private String path;
    private File file = new File("");

    private ImageLoader() {
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
    
    private String getExt(File file) {
        String name = file.getName();
        int dot = name.lastIndexOf('.');
        return (dot == -1) ? "" : name.substring(dot + 1);
    }

    public boolean setFile(Component owner, File file) {
        String ext = getExt(file);
        
        System.out.println(ext);
       if(ext.toLowerCase().equals("png") || ext.toLowerCase().equals("jpg")) {
             this.file = file;
             return false;
        }
       
        JOptionPane.showMessageDialog(owner, "The selected file is not a supported image format.", "Invalid File", JOptionPane.ERROR_MESSAGE);
        return true;
    }

    public File getFile() {
        return file;
    }
 
    
    public static ImageLoader getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ImageLoader();
        }
        
        return INSTANCE;
    }
}
