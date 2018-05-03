/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.japo.java.libraries;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.ChangeListener;

/**
 *
 * @author Juan Alcocer Canet - juanasir1995@gmail.com
 */
public class UtilesSwing {

    // Perfiles LnF
    public static final String LNF_WINDOWS_PROFILE = "WINDOWS";
    public static final String LNF_WINDOWS_CLASSIC_PROFILE = "WINDOWS CLASSIC";
    public static final String LNF_MOTIF_PROFILE = "CDE/MOTIF";
    public static final String LNF_GTK_PROFILE = "GTK+"; //LINUX
    public static final String LNF_METAL_PROFILE = "METAL"; //CROSS PLATFORM
    public static final String LNF_NIMBUS_PROFILE = "NIMBUS"; 
    public static final String LNF_SYSTEM_PROFILE = "SYSTEM";
    public static final String LNF_CROSS_PLATFORM_PROFILE = "CROSS PLATFORM";
    
    public static final String LNF_WINDOWS_CLASS = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
    public static final String LNF_WINDOWS_CLASSIC_CLASS = "com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel";
    public static final String LNF_MOTIF_CLASS = "com.sun.java.swing.plaf.motif.MotifLookAndFeel";
    public static final String LNF_GTK_CLASS = "com.sun.java.swing.plaf.gtk.GTKLookAndFeel"; //LINUX
    public static final String LNF_METAL_CLASS = "javax.swing.plaf.metal.MetalLookAndFeel"; //CROSS PLATFORM
    public static final String LNF_NIMBUS_CLASS = "javax.swing.plaf.nimbus.NimbusLookAndFeel";
    
    public static final String DEF_FONT_FAMILY = Font.SANS_SERIF;
    public static final int DEF_FONT_STYLE = Font.PLAIN;
    public static final int DEF_FONT_SIZE = 12;
    
    public static final String[] obtenerNombresLnfInstalados(){
        UIManager.LookAndFeelInfo[] lnfInfo = UIManager.getInstalledLookAndFeels();
        String[] lnfName = new String [lnfInfo.length];
        for (int i = 0 ; i < lnfInfo.length; i++){
            lnfName[i] = lnfInfo[i].getName().toUpperCase();
        }
        return lnfName;   
    }
    
    public static final String[] obtenerNombresClasesLNFInstalados(){
        UIManager.LookAndFeelInfo[] lnfInfo = UIManager.getInstalledLookAndFeels();
        String[] lnfClassName = new String [lnfInfo.length];
        for (int i = 0 ; i < lnfInfo.length; i++){
            lnfClassName[i] = lnfInfo[i].getClassName();
        }
        return lnfClassName;
    }
    
    public static final void establecerLookAndFeel(String lnfClass){
        try{
            UIManager.setLookAndFeel(lnfClass);
            
        }catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e){
            System.out.println("Error: No se ha instalado el LNF-CLASE");
        }
    }
    
    public static final void establecerLookAndFeelProfile(String lnfProfile){
        if(lnfProfile.toUpperCase().equals(LNF_SYSTEM_PROFILE)){
            establecerLnFSistema();
        }else if(lnfProfile.toUpperCase().equals(LNF_CROSS_PLATFORM_PROFILE)){
            establecerLnFCrossPlatform();
        }else{
            try{
                for(UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()){
                    if(lnfProfile.toUpperCase().equals(info.getName().toUpperCase())){
                        UIManager.setLookAndFeel(info.getClassName());                              
                        }
                    }
                } catch( ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e) {
                    System.out.println("Error: No se ha instalado el LnF_Perfil");
                }
            }
        }
    
    public static final String obtenerNombreLnFSistema(){
        return UIManager.getSystemLookAndFeelClassName();
    }
    
    public static final void establecerLnFSistema() {
        try{
            UIManager.getCrossPlatformLookAndFeelClassName();
        } catch (Exception e) {
            System.out.println("Error: No se ha instalado el LnF_Sistema");
        }
    }
    
    public static final String obtenerNombreLnFCrossPlatform(){
        return UIManager.getCrossPlatformLookAndFeelClassName();
    }
    
    public static final void establecerLnFCrossPlatform(){
        try{
            UIManager.setLookAndFeel(obtenerNombreLnFCrossPlatform());
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e) {
            System.out.println("Error: No se ha instalado el LnF_Cross Platform");
        }
    }
    
    // Cerrar programa
    public static void terminarPrograma(JFrame f) {
        // Oculta la ventana
        f.setVisible(false);

        // Devuelve los recursos
        f.dispose();

        // Cierra el programa
        System.exit(0);
    }

    // Escalar/Asignar Image > Etiqueta
    public static boolean asignarImagenEscalada(JLabel lblImagen, Image imgOriginal) {
        // Semáforo
        boolean procesoOK = false;

        // Procesado Imagen
        try {
            // Obtiene la imagen escalada
            Image imgEscalada = imgOriginal.getScaledInstance(
                    lblImagen.getSize().width,
                    lblImagen.getSize().height,
                    Image.SCALE_FAST);

            // Image (Final) > Icon
            Icon i = new ImageIcon(imgEscalada);

            // Icon > Etiqueta Imagen
            lblImagen.setIcon(i);

            // Actualiza semáforo
            procesoOK = true;
        } catch (Exception e) {
            System.out.println("ERROR: Reescalar/Asignar imagen a etiqueta");
        }

        // Devuelve semáforo
        return procesoOK;
    }

    // Obtiene el texto copiado al portapapeles
    public static String obtenerTextoPortapapeles() {
        // Referencia al texto del portapapeles
        String result = "";

        try {
            // Acceso al portapapeles
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();

            // Contenido del Portapapeles
            // El parámetro de getContents no se usa
            Transferable contents = clipboard.getContents(null);

            // Extrae texto del portapapeles
            result = (String) contents.getTransferData(DataFlavor.stringFlavor);
        } catch (HeadlessException | UnsupportedFlavorException | IOException e) {
            System.out.println("ERROR: Lectura del portapapeles");
        }

        // Texto extraido
        return result;
    }

    // Coloca texto en el portapapeles
    public static boolean ponerTextoPortapapeles(String texto, ClipboardOwner propietario) {
        // Semáforo
        boolean procesoOK = false;

        try {
            // Entidad que implementa la capacidad de transmitir texto
            StringSelection transmisor = new StringSelection(texto);

            // Acceso al portapapeles
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();

            // Transmisión de texto
            clipboard.setContents(transmisor, propietario);

            // Actualiza semáforo
            procesoOK = true;
        } catch (HeadlessException e) {
            System.out.println("ERROR: Escritura en el portapapeles");
        }

        // Devuelve semáforo
        return procesoOK;
    }

    // Cambiar valor sin disparar Eventos de Ajuste
    public static void ajustarValorDeslizador(JSlider sldActual, int valor) {
        // Captura los escuchadores del deslizador
        ChangeListener[] lista = sldActual.getChangeListeners();

        // Desactiva los escuchadores del deslizador
        for (ChangeListener clAct : lista) {
            sldActual.removeChangeListener(clAct);
        }

        // Establece el valor al deslizador
        sldActual.setValue(valor);

        // Asocia los escuchadores al deslizador
        for (ChangeListener clAct : lista) {
            sldActual.addChangeListener(clAct);
        }
    }

    // Cambiar valor sin disparar Eventos de Ajuste
    public static void ajustarValorCambiador(JSpinner spnActual, int valor) {
        // Captura los escuchadores del cambiador
        ChangeListener[] lista = spnActual.getChangeListeners();

        /**
         * Desactiva el primer ChangeListener para que no se propaguen eventos.
         * Si se desconectan todos los listeners el JSpinner no se actualiza con
         * el valor cambiado por set value.
         */
        spnActual.removeChangeListener(lista[0]);

        // Cambia el valor del spinner
        spnActual.setValue(valor);

        // Reconecta el primer ChangeListener
        spnActual.addChangeListener(lista[0]);
    }

    // Tipografias disponibles en el sistema
    public static String[] obtenerTipografiasSistema() {
        return GraphicsEnvironment.
                getLocalGraphicsEnvironment().
                getAvailableFontFamilyNames();
    }

    public static void seleccionarElementoCombo(JComboBox<String> cbbActual, String item) {
        // Captura los escuchadores del combo
        ActionListener[] lista = cbbActual.getActionListeners();

        // Desactiva los escuchadores del deslizador
        for (ActionListener al : lista) {
            cbbActual.removeActionListener(al);
        }

        // Selecciona el elemento
        cbbActual.setSelectedItem(item);

        // Asocia los escuchadores al combo
        for (ActionListener al : lista) {
            cbbActual.addActionListener(al);
        }
    }

    // Asignar Favicon Ventana
    public static void establecerFavicon(JFrame ventana, String rutaFavicon) {
        try {
            // Ruta Favicon > URL Favicon
            URL urlICN = ClassLoader.getSystemResource(rutaFavicon);

            // URL Favicon > Ventana Favicon
            ventana.setIconImage(new ImageIcon(urlICN).getImage());
        } catch (Exception e) {
            System.out.println("ERROR: Instalación del icono de la ventana");
        }
    }
    
    // Cargar Fuente TTF
    public static final Font cargarFuente(String rutaFuente) {
        // Referencia a la fuente
        Font fntActual;

        // Cargar Fuente
        try {
            // Crea Acceso al Fichero
            InputStream is = ClassLoader.getSystemResourceAsStream(rutaFuente);

            // Instancia fuente
            fntActual = Font.createFont(Font.TRUETYPE_FONT, is).deriveFont(Font.PLAIN, 12f);
        } catch (FontFormatException | IOException e) {
            fntActual = new Font("SansSerif", Font.PLAIN, 12);
        }

        // Devuelve fuente
        return fntActual;
    }
}
