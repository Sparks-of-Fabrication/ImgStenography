/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.github.org.sparks_of_fabrication.imgstenography.loaders;

import java.util.function.Supplier;

/**
 *
 * @author petko
 */
public class LoaderSpawn {
    public static class LoaderType<T extends Loader<?>> {
        public static final LoaderType<FileLoader> FILE = new LoaderType<>(FileLoader::new);
        public static final LoaderType<ImageLoader> IMAGE = new LoaderType<>(ImageLoader::new);
        
        private final Supplier<T> factory;
        
        private LoaderType(Supplier<T> factory) {
            this.factory = factory;
        }
        
        public T create() {return factory.get(); };
    }
    
    public static <T extends Loader<?>> T createLoader(LoaderType<T> type) {
        return type.create();
    }
}
