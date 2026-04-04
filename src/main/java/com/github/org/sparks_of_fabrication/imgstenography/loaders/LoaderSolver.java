/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.github.org.sparks_of_fabrication.imgstenography.loaders;

import java.awt.Component;
import java.io.File;

/**
 *
 * @author petko
 * @param <T>
 */
public interface  LoaderSolver <T> extends Loader {
    T convertIntoSolver();
}
