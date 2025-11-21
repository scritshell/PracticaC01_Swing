/*
* Proyecto: swing_c_p01_parte1_CsibiSebastian
* Paquete: vista
* Archivo: PanelEj3.java
* Autor/a: Sebastian Csibi
* Fecha: 11 nov 2025 14:10:27
*
* Descripción:
* [Panel que modifica el tamaño del texto con botones de opción.]
*
* Licencia:
* [Todos los derechos reservados]
*/
package vista;

/**
 * 
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelEj3 extends JPanel {
	// Declaramos los objetos de este ejercicio //
    private JLabel texto;
    private JRadioButton pequenio, mediano, grande, muyGrande;
    private ButtonGroup grupoTamanios;
    // Constructor sin parametros //
    public PanelEj3() {
    	// Bordes y layouts //
        setBorder(BorderFactory.createTitledBorder("Ejercicio 3"));
        setLayout(new FlowLayout());

        texto = new JLabel("En un lugar de la Mancha, de cuyo nombre...");
        texto.setFont(new Font("Arial", Font.PLAIN, 16));
        
        
        // Los botones y sus funciones //
        pequenio = new JRadioButton("Pequeño");
        mediano = new JRadioButton("Mediano", true); // Este se muestra por defecto //
        grande = new JRadioButton("Grande");
        muyGrande = new JRadioButton("Muy grande");

        grupoTamanios = new ButtonGroup();
        grupoTamanios.add(pequenio);
        grupoTamanios.add(mediano);
        grupoTamanios.add(grande);
        grupoTamanios.add(muyGrande);

        // Evento //
        ActionListener cambiarTamano = (ActionEvent e) -> {
            int size = 14;
            if (pequenio.isSelected()) size = 10;
            else if (mediano.isSelected()) size = 14;
            else if (grande.isSelected()) size = 18;
            else if (muyGrande.isSelected()) size = 24;
            texto.setFont(new Font("Arial", Font.PLAIN, size));
        };
        pequenio.addActionListener(cambiarTamano);
        mediano.addActionListener(cambiarTamano);
        grande.addActionListener(cambiarTamano);
        muyGrande.addActionListener(cambiarTamano);

        
        // Se añaden los objetos //
        add(texto);
        add(pequenio);
        add(mediano);
        add(grande);
        add(muyGrande);
    }
}