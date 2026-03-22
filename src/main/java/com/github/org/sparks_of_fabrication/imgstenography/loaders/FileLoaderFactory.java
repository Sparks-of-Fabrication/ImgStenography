/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.github.org.sparks_of_fabrication.imgstenography.loaders;

/**
 *
 * @author petko
 */
public class FileLoaderFactory implements Factory<FileLoader>{

    @Override
    public FileLoader create() {
        return new FileLoader();
    }

}
