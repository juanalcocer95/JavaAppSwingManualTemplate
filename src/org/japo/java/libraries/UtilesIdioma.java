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
public class UtilesIdioma {

    // Dias de la Semana
    public static final int LUNES = 1;
    public static final int MARTES = 2;
    public static final int MIERCOLES = 3;
    public static final int JUEVES = 4;
    public static final int VIERNES = 5;
    public static final int SABADO = 6;
    public static final int DOMINGO = 7;

    // Código
    public static final int CODIGO_ESP = 34;
    public static final int CODIGO_ING = 44;
    public static final int CODIGO_ALE = 49;

    // Idiomas
    public static final String NOMBRE_ESP = "Español";
    public static final String NOMBRE_ING = "Inglés";
    public static final String NOMBRE_ALE = "Alemán";

    // Dias - Español
    public static final String[] DIAS_ESP = {
        "Lunes", "Martes", "Miércoles", "Jueves",
        "Viernes", "Sábado", "Domingo"
    };

    // Dias - Inglés
    public static final String[] DIAS_ING = {
        "Monday", "Tuesday", "Wednesday", "Thursday",
        "Freeday", "Saturday", "Sunday"};

    // Dias - Alemán
    public static final String[] DIAS_ALE = {
        "Montag", "Dienstag", "Mittwoch", "Donnerstag",
        "Freitag", "Samstag", "Sontag"};

    // ATENCION >>> Lunes: 1 - Domingo: 7 <<<
    public static String generarNombreDia(int dia, int idioma) {
        // Día actual
        String nombre;

        // Análisis idioma
        try {
            switch (idioma) {
                case CODIGO_ESP:
                    nombre = String.format("%s (%s)",
                            DIAS_ESP[dia - 1], NOMBRE_ESP);
                    break;
                case CODIGO_ING:
                    nombre = String.format("%s (%s)",
                            DIAS_ING[dia - 1], NOMBRE_ING);
                    break;
                case CODIGO_ALE:
                    nombre = String.format("%s (%s)",
                            DIAS_ALE[dia - 1], NOMBRE_ALE);
                    break;
                default:
                    nombre = "Desconocido";
            }
        } catch (Exception e) {
            nombre = "Desconocido";
        }

        // Devuelve nombre
        return nombre;
    }
}
