/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.japo.java.libraries;

import java.util.Random;

/**
 *
 * @author Juan Alcocer Canet - juanasir1995@gmail.com
 */
public class UtilesSorteos {
    // Referencias
    public static final int LONGITUD_BOMBO_PRIMITIVA = 49;
    public static final int LONGITUD_APUESTA_PRIMITIVA = 6;
    
    // Sistema de Números Aleatorios
    public static final Random RND = new Random();
    
    // Genera Bombo Loteria Primitiva | Inicializado 1 - 49
    public static int[] generarBomboPrimitiva() {
        // Definir bombo
        int[] bombo = new int[LONGITUD_BOMBO_PRIMITIVA];
        
        // Llenar bombo - Primer Número: 1
        for (int i = 0; i < bombo.length; i++) {
            bombo[i] = i + 1;
        }
        
        // Devolver Bombo
        return bombo;
    }
    
    // Genera Apuesta Loteria Primitiva
    public static int[] generarApuestaPrimitiva() {
        // Definir Apuesta
        int[] apuesta = new int[LONGITUD_APUESTA_PRIMITIVA];

        // Definir bombo
        int[] bombo = generarBomboPrimitiva();
        
        // Generar apuesta
        for (int i = 0; i < apuesta.length; i++) {
            // Extrae la posición actual
            int posicion = RND.nextInt(LONGITUD_BOMBO_PRIMITIVA - i);
            
            // Extrae la bola de la posición actual
            apuesta[i] = bombo[posicion];
            
            // Rellena el hueco
            bombo[posicion] = bombo[LONGITUD_BOMBO_PRIMITIVA - i - 1];
        }
        
        // Devolver Apuesta
        return apuesta;
    }
}
