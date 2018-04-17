/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.japo.java.libraries;

import java.util.Scanner;

/**
 *
 * @author Juan Alcocer Canet - juanasir1995@gmail.com
 */
public class UtilesEntrada {

    // Scanner --- > Entrada de acentos con Windows
    public static final Scanner SCN = new Scanner(System.in, "ISO-8859-1");

    // Devuelve un entero introducido por teclado
    public static final int leerEntero(String msgUsr, String msgErr) {
        // Dato a introducir
        int dato = 0;

        // Proceso de lectura
        boolean lecturaOK = false;
        do {
            try {
                // Entrada dato
                System.out.print(msgUsr);
                dato = SCN.nextInt();

                // Marca el semáforo
                lecturaOK = true;
            } catch (Exception e) {
                System.out.println(msgErr);
            } finally {
                SCN.nextLine();
            }
        } while (!lecturaOK);

        // Devolver dato
        return dato;
    }

    // Devuelve un entero entre limites introducido por teclado
    public static final int leerEntero(String msgUsr, String msgErr, int min, int max) {
        // Numero a devolver
        int dato;

        // Semaforo validacion
        boolean rangoOK;

        // Bucle Validacion
        do {
            // Introducir Entero
            dato = leerEntero(msgUsr, msgErr);

            // Validar Entero
            rangoOK = dato >= min && dato <= max;

            // Mensaje de error
            if (!rangoOK) {
                System.out.println(msgErr);
            }
        } while (!rangoOK);

        // Devolver número
        return dato;
    }

    // Devuelve un entero introducido por teclado de entre una lista de posibles valores
    public static final int leerEntero(String msgUsr, String msgErr, int lista[]) {
        // Numero a devolver
        int dato;

        // Semaforo validacion
        boolean datoOK;

        // Bucle Validacion
        do {
            // Introducir Entero
            dato = UtilesEntrada.leerEntero(msgUsr, msgErr);

            // Validar Entero
            datoOK = UtilesArrays.buscar(lista, dato) > -1;

            // Mensaje de error
            if (!datoOK) {
                System.out.println(msgErr);
            }
        } while (!datoOK);

        // Devolver número
        return dato;
    }

    // Devuelve un número de DNI
    public static final int leerNumeroDNI(String msgUsr, String msgErr) {
        return leerEntero(msgUsr, msgErr, UtilesDNI.NUM_MIN, UtilesDNI.NUM_MAX);
    }

    // Devuelve un caracter introducido por teclado
    public static final char leerCaracter(String msgUsr, String msgErr) {
        // Dato a introducir
        char dato = 0;

        // Proceso de lectura
        boolean lecturaOK = false;
        do {
            try {
                // Entrada dato
                System.out.print(msgUsr);
                dato = SCN.nextLine().charAt(0);

                // Marca el semáforo
                lecturaOK = true;
            } catch (Exception e) {
                System.out.println(msgErr);
            }
        } while (!lecturaOK);

        // Devolver dato
        return dato;
    }

    // Devuelve un caracter de control de DNI
    public static final char leerControlDNI(String msgUsr, String msgErr) {
        return leerCaracter(msgUsr, msgErr);
    }

    // Devuelve un DNI
    public static final String leerDNI(String msgNum, String msgCtr, String msgErr) {
        // Mensajes
        final String MSG_ERR = "ERROR: DNI incorrecto";

        // Variables 
        int num;
        char ctr;

        // Proceso de entrada
        boolean dniOK;

        do {
            // Componentes del DNI
            num = leerNumeroDNI(msgNum, msgErr);
            ctr = leerControlDNI(msgCtr, msgErr);

            // Valida DNI
            dniOK = UtilesValidacion.validarDNI(num, ctr);

            // DNI Erróneo
            if (!dniOK) {
                System.out.println(MSG_ERR);
            }
        } while (!dniOK);

        // Devolver dato
        return "" + num + ctr;
    }
    
    public static final char leerOpcion(String opciones, String msgUsr, String msgErr) {
        char dato=' ';
        boolean lecturaOk = false;
        do{
            try{
                System.out.print(msgUsr);
                dato = SCN.nextLine().charAt(0);
                if(opciones.contains(dato+"")){
                    lecturaOk=true;
                }else{
                    System.out.println(msgErr);   
                }
            } catch(Exception e) {
                System.out.println(msgErr);
            }
        }while(!lecturaOk);
        return dato;
    }
    
    public static final String leerTexto(String msgUsr) {
        System.out.print(msgUsr);
        return SCN.nextLine();
    }
}
