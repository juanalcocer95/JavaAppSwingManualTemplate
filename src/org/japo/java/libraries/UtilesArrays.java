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
public class UtilesArrays {

    // Sistema Números Aleatórios
    public static final Random RND = new Random();

    // Array int >> Total
    public static final int acumular(int[] listaDatos) {
        // Acumulador
        int total = 0;

        // Proceso
        for (int dato : listaDatos) {
            total += dato;
        }

        // Devolución Valor
        return total;
    }

    // Array double >> Total
    public static final double acumular(double[] listaDatos) {
        // Acumulador
        double total = 0;

        // Proceso
        for (double dato : listaDatos) {
            total += dato;
        }

        // Devolución Valor
        return total;
    }

    // Número aleatorio >> Array Char
    public static final char[] generar(int numPos, char chrMin, char chrMax) {
        // Array Vacío
        char[] listaDatos = new char[numPos];

        // Generación de datos
        for (int i = 0; i < numPos; i++) {
            listaDatos[i] = (char) (RND.nextInt(chrMax - chrMin + 1) + chrMin);
        }

        // Devolución Array
        return listaDatos;
    }

    // Número aleatorio >> Array Entero
    public static final int[] generar(int numPos, int numMin, int numMax) {
        // Array Vacío
        int[] listaDatos = new int[numPos];

        // Generación de datos
        for (int i = 0; i < numPos; i++) {
            listaDatos[i] = RND.nextInt(numMax - numMin + 1) + numMin;
        }

        // Devolución Array
        return listaDatos;
    }

    // Número aleatorio >> Array Real
    public static final double[] generar(int numPos, double numMin, double numMax) {
        // Array Vacío
        double[] listaDatos = new double[numPos];

        // Generación de datos
        for (int i = 0; i < numPos; i++) {
            listaDatos[i] = RND.nextDouble() * (numMax - numMin) + numMin;
        }

        // Devolución Array
        return listaDatos;
    }

    // Inicializar Array - char
    public static final void inicializar(char[] listaDatos, char dato) {
        for (int i = 0; i < listaDatos.length; i++) {
            listaDatos[i] = dato;
        }
    }

    // Inicializar Array - int
    public static final void inicializar(int[] listaDatos, int dato) {
        for (int i = 0; i < listaDatos.length; i++) {
            listaDatos[i] = dato;
        }
    }

    // Inicializar Array - double
    public static final void inicializar(double[] listaDatos, double dato) {
        for (int i = 0; i < listaDatos.length; i++) {
            listaDatos[i] = dato;
        }
    }

    // Inicializar Array - boolean
    public static final void inicializar(boolean[] listaDatos, boolean dato) {
        for (int i = 0; i < listaDatos.length; i++) {
            listaDatos[i] = dato;
        }
    }

    // Búsqueda Simple - int
    public static final int buscar(int[] listaDatos, int clave) {
        // Marcador de posición
        int posicion = 0;
        
        // Semáforo de Proceso de Búsqueda
        boolean finBusquedaOK = false;
        
        // Proceso de búsqueda
        do {
            if (posicion >= listaDatos.length) {
                finBusquedaOK = true;
                posicion = -1;
            } else if (listaDatos[posicion] == clave) {
                finBusquedaOK = true;
            } else {
                posicion++;
            }
        } while (!finBusquedaOK);
        
        // Posición de la clave en el array
        return posicion;
    }
}
