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
public class UtilesSiNo {

    public static final Scanner SCN = new Scanner(System.in, "ISO-8859-1");

    public static final boolean leerSiNo(String msg) {

        boolean testOK;

        System.out.print(msg);
        String respuesta = SCN.nextLine();
        if (respuesta.equalsIgnoreCase("SI")) {
            testOK = true;
        } else if (respuesta.equalsIgnoreCase("S")) {
            testOK = true;
        } else if (respuesta.equalsIgnoreCase("NO")) {
            testOK = false;
        } else {
            testOK = false;
        }
        return testOK;
    }
}
