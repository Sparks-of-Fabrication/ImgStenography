/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.github.org.sparks_of_fabrication.imgstenography.loaders;

/**
 *
 * @author petko
 * @param <T>
 */
public interface  Loader <T> {
    T fetchFile();
    String fetchContent();
}
