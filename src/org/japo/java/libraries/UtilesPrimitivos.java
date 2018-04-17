/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.japo.java.libraries;

/**
 *
 * @author Juan Alcocer Canet - juanasir1995@gmail.com
 */
public class UtilesPrimitivos {

    // Constantes referenciales
    public static final int MAYOR = 1;
    public static final int MENOR = -1;
    public static final int IGUAL = 0;

    // Comprueba la paridad de un número entero
    public static boolean validarParidad(int num) {
        return num % 2 == 0;
    }

    // Comprueba la paridad de un número real
    public static boolean validarParidad(double num) {
        return num % 2 == 0;
    }

    // Comprueba el signo de un número entero
    public static boolean validarSigno(int num) {
        return num >= 0;
    }

    // Comprueba el signo de un número real
    public static boolean validarSigno(double num) {
        return num >= 0;
    }

    // Devuelve el mayor de dos números enteros
    public static int obtenerMayor(int n1, int n2) {
        return n1 > n2 ? n1 : n2;
    }

    // Devuelve el mayor de dos números reales
    public static double obtenerMayor(double n1, double n2) {
        return n1 > n2 ? n1 : n2;
    }

    // Devuelve el menor de dos números enteros
    public static int obtenerMenor(int n1, int n2) {
        return n1 < n2 ? n1 : n2;
    }

    // Devuelve el menor de dos números reales
    public static double obtenerMenor(double n1, double n2) {
        return n1 < n2 ? n1 : n2;
    }

    // Devuelve la relación entre dos números
    public static int obtenerRelacion(double n1, double n2) {
        return n1 > n2 ? MAYOR : n1 < n2 ? MENOR : IGUAL;
    }
}
