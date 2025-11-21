/*
* Proyecto: swing_c_p01_parte1_CsibiSebastian
* Paquete: vista
* Archivo: PanelEj2.java
* Autor/a: Sebastian Csibi
* Fecha: 11 nov 2025 13:51:58
*
* Descripción:
* [Panel que permite cambiar la fuente del texto mediante un JComboBox.]
*
* Licencia:
* [Todos los derechos reservados ]
*/
package vista;

/**
 * 
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PanelEj2 extends JPanel {
	// Se declaran los objetos //
    private JComboBox comboFuentes;
    private JLabel texto;
    
    // COnstructor sin parámetros //
    public PanelEj2() {
    	// Bordes y layouts //
        setBorder(BorderFactory.createTitledBorder("Ejercicio 2"));
        setLayout(new FlowLayout());

        
        texto = new JLabel("En un lugar de la Mancha, de cuyo nombre ...");
        texto.setFont(new Font("Arial", Font.PLAIN, 16));

        // Combo con algunas fuentes comunes y populares, si //
        // una no carga, se seleccionará otra de esta lista  //
        String[] fuentes = {"Arial", "Courier New", "Times New Roman", "Verdana"};
        comboFuentes = new JComboBox(fuentes);

        // Este evento cambia la fuente al seleccionar otra //
        
        comboFuentes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fuente = (String) comboFuentes.getSelectedItem();
                texto.setFont(new Font(fuente, Font.PLAIN, 16));
            }
        });
        
        
        // Se añaden los objetos //
        add(texto);
        add(comboFuentes);
    }
}
