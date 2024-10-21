/**
 * @author Javier
 * @since 18-10-2024
 */
package com.example.tallerrest.utils;

import java.util.Enumeration;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Clase para el manejo de los mensajes con el patrón Singleton
 */
public class StaticBundle extends ResourceBundle {

    private static ResourceBundle instance = ResourceBundle.getBundle("messages", Locale.getDefault());
    /*Para pruebas en inglés*/
	//private static ResourceBundle instance = ResourceBundle.getBundle("messages", new Locale("en"));

    // Constructor privado, nadie puede instanciar esta clase, solo ella misma
    private StaticBundle() {

    }

    public static ResourceBundle getInstance() {
        return instance;
    }

	@Override
	protected Object handleGetObject(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Enumeration<String> getKeys() {
		// TODO Auto-generated method stub
		return null;
	}
}
