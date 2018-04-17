/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.japo.java.libraries;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

/**
 *
 * @author Juan Alcocer Canet - juanasir1995@gmail.com
 */
public class UtilesCSV {

    // Separadores
    public static final String SEPARADOR_LECTURA = "\\s*,\\s*";
    public static final String SEPARADOR_ESCRITURA = ", ";

    // Archivo CSV > Lista Items
    public static String[] importarItemsCSV(String fichero) throws Exception {
        // Lista Items (Vacio)
        String[] items;

        // Importar Items
        try (BufferedReader entrada = new BufferedReader(new FileReader(fichero))) {
            // Fichero CSV > Linea Items
            String linea = entrada.readLine();

            // Linea Items > Lista Items
            items = linea.split(SEPARADOR_LECTURA);
        }

        // Devolver Items
        return items;
    }

    // Lista Items > Archivo CSV
    public static void exportarItemsCSV(String[] items, String fichero) throws Exception {
        // Lectura de un fichero de texto
        try (PrintWriter salida = new PrintWriter(new FileWriter(fichero))) {

            // Primer item por separado
            salida.print(items[0]);

            // Resto de los items
            for (int i = 1; i < items.length; i++) {
                salida.print(SEPARADOR_ESCRITURA + items[i]);
            }
        }
    }
}
