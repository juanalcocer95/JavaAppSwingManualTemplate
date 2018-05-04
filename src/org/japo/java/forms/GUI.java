/* 
 * Copyright 2018 Juan Alcocer Canet - juanasir1995@gmail.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.japo.java.forms;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.Properties;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import org.japo.java.events.MEM;
import org.japo.java.events.MMEM;
import org.japo.java.libraries.UtilesSwing;

/**
 *
 * @author Juan Alcocer Canet - juanasir1995@gmail.com
 */
public class GUI extends JFrame {

    // Propiedades App
    public static final String PRP_LOOK_AND_FEEL_PROFILE = "look_and_feel_profile";
    public static final String PRP_FAVICON_RESOURCE = "favicon_resource";
    public static final String PRP_BACKGROUND_RESOURCE = "background_resource";
    public static final String PRP_FONT_RESOURCE = "font_resource";
    
    
    // Valores por Defecto
    public static final String DEF_LOOK_AND_FEEL_PROFILE = UtilesSwing.LNF_WINDOWS_PROFILE;
    public static final String DEF_FAVICON_RESOURCE = "images/favicon.png";
    public static final String DEF_BACKGROUND_RESOURCE = "images/background.png";
    public static final String DEF_FONT_RESOURCE = "fonts/default_font.ttf";

    // Referencias
    private Properties prp;
    
    private int xIni;
    private int yIni;
    
    // Constructor
    public GUI(Properties prp) {
        // Inicialización Anterior
        initBefore(prp);

        // Creación Interfaz
        initComponents();

        // Inicializacion Posterior
        initAfter();
    }

    // Construcción - GUI
    private void initComponents() {

        //Ejemplo Texto
        JLabel lblTitle = new JLabel("Plantilla Swing Manual");
        //Establecer fuente
        lblTitle.setFont(UtilesSwing.importarFuenteRecurso(prp.getProperty(
                        PRP_FONT_RESOURCE, DEF_FONT_RESOURCE)).
                            deriveFont(Font.BOLD + Font.ITALIC, 30f));
        lblTitle.setSize(600, 50);
        lblTitle.setLocation(0, 10);
        lblTitle.setHorizontalAlignment(JLabel.CENTER);
       
        // Panel Principal
        JPanel pnlPpal = new JPanel();
        pnlPpal.add(lblTitle);
        
        // Ventana Principal
        setContentPane(pnlPpal);
        pnlPpal.setLayout(null); // Eliminamos el layout
        setTitle("Swing Manual #00");
        setResizable(false);
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);            
        
        
        //Eventos
        
        /* Eventos necesarios para Arrastre ventana
        addMouseListener(new MEM(this));
        addMouseMotionListener(new MMEM(this));            
        */
        
        }
    
    // Inicialización Anterior    
    private void initBefore(Properties prp) {
        // Memorizar Referencia
        this.prp = prp;

        // Establecer LnF
        UtilesSwing.establecerLookAndFeelProfile(prp.getProperty(PRP_LOOK_AND_FEEL_PROFILE, DEF_LOOK_AND_FEEL_PROFILE));
    }

    // Inicialización Posterior
    private void initAfter() {
        // Establecer Favicon
        UtilesSwing.establecerFavicon(this, prp.getProperty(PRP_FAVICON_RESOURCE, DEF_FAVICON_RESOURCE));
    }
    
    
    //Arrastre ventana
    public void iniciarArrastre(MouseEvent e){
        xIni = e.getXOnScreen();
        yIni = e.getYOnScreen();
    }
    
    public void gestionarArrastre(MouseEvent e){
        int xFin = e.getXOnScreen();
        int xOff = xFin - xIni;
        xIni = xFin;
        
        int yFin = e.getYOnScreen();
        int yOff = yFin - yIni;
        yIni = yFin;
        
        int xWin = getLocation().x;
        int yWin = getLocation().y;
        
        setLocation(xWin+xOff, yWin+yOff);
    } 
}
