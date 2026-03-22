/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.github.org.sparks_of_fabrication.imgstenography.loaders;

/**
 *
 * @author petko
 */
public class ImageLoaderFactory implements Factory<ImageLoader> {

    @Override
    public ImageLoader create() {
        return new ImageLoader();
    }
}
