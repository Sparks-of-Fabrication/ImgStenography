/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.github.org.sparks_of_fabrication.imgstenography;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author petko
 */
public class FileExplorer {
    private Path currentPath;
    
    public FileExplorer() {
        this.currentPath  = Paths.get("");
    }
    
    public List<String> getCurrentPathContent() throws IOException {
        List<String> result = new ArrayList<>();
        
        
        for(String file: Files.readAllLines(this.currentPath)) {
            result.add(file);
        }
        
        return result;
    }
}
