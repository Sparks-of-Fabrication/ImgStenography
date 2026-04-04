/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.github.org.sparks_of_fabrication.imgstenography.loaders;

import java.awt.Component;
import java.io.File;
import java.util.Optional;

/**
 *
 * @author petko
 */
public interface Loader {
    default Optional<String> fetchContent() {
        return Optional.empty();
    }
    boolean setFile(Component owner, File file);
    boolean setFile(File file);
    File getFile();
    void flush();
    default String getExt(File file) {
        String name = file.getName();
        int dot = name.lastIndexOf('.');
        return (dot == -1) ? "" : name.substring(dot + 1);
    }
}
