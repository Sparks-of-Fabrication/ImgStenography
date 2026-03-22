    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.github.org.sparks_of_fabrication.imgstenography.loaders;

import java.awt.Component;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Window;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author petko
 */
public class ImageLoader implements Loader<BufferedImage> {
    private boolean trigger = false;
    private String path;
    private File file;
    private BufferedImage bufferedImage;

    public void setPath(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
    
    public Dimension imageGetDimensions() {
        if(file == null) return new Dimension();
        Dimension result = new Dimension();
          
         result.setSize(bufferedImage.getWidth(), bufferedImage.getHeight());
        
        return result;
    }

    @Override
    public BufferedImage fetchFile() {
         return  bufferedImage;
    }

    @Override
    public String fetchContent() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
    private void trigger() {
        this.trigger = true;
    }
    
    public boolean isTriggered() {
        return this.trigger;
    }
    
    private String getExt(File file) {
        String name = file.getName();
        int dot = name.lastIndexOf('.');
        return (dot == -1) ? "" : name.substring(dot + 1);
    }

    public boolean setFile(Component owner, File file) {
        String ext = getExt(file);
        
        System.out.println(ext);
       if(ext.toLowerCase().equals("png") || ext.toLowerCase().equals("jpg") || ext.toLowerCase().equals("bmp")) {
             this.file = file;
             
             try{
                bufferedImage = ImageIO.read(this.file);
                trigger();
             }catch(IOException ex) {
                 ex.printStackTrace();
                 System.exit(1);
             }
             return false;
        }
       
        JOptionPane.showMessageDialog(owner, "The selected file is not a supported image format.", "Invalid File", JOptionPane.ERROR_MESSAGE);
        return true;
    }

    public File getFile() {
        if(file == null) {
            return new File("");
        }
        return file;
    }
}
