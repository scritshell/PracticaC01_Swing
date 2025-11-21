/*
* Proyecto: swing_c_p01_parte1_CsibiSebastian
* Paquete: vista
* Archivo: PanelEj1.java
* Autor/a: Sebastian Csibi
* Fecha: 10 nov 2025 10:07:29
*
* Descripción:
* [Panel que cambia el estilo del texto entre negrita y cursiva.]
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
import java.awt.event.ItemEvent;

public class PanelEj1 extends JPanel {
	// Declaración de los objetos //
    private JCheckBox eleccionNegrita, eleccionCursiva;
    private JLabel texto;

    public PanelEj1() {
        setBorder(BorderFactory.createTitledBorder("Ejercicio 1"));
        setLayout(new FlowLayout());
        
        
        texto = new JLabel("En un lugar de la Mancha, de cuyo nombre ...");
        texto.setFont(new Font("Arial", Font.PLAIN, 16));
        eleccionNegrita = new JCheckBox("Negrita");
        eleccionCursiva = new JCheckBox("Cursiva");

        // Eventos //
        eleccionNegrita.addItemListener(e -> actualizarEstilo());
        eleccionCursiva.addItemListener(e -> actualizarEstilo());

        
        // Añadir los objetos //
        add(texto);
        add(eleccionNegrita);
        add(eleccionCursiva);
    }

    // ========================================== //
    // Con este método, el estilo del texto se    //
    // modifica según lo que el usuario marque    //
    // en el programa. El text o se deja por      //
    // defecto en fuente arial, estilo plano y    //
    // tamañano 16 del texto.					  //
    // ========================================== //
    private void actualizarEstilo() {
        int estilo = Font.PLAIN;
        
        if (eleccionNegrita.isSelected()) {
            estilo += Font.BOLD;
        }
        if (eleccionCursiva.isSelected()) {
        	estilo += Font.ITALIC;
        } 
        
        texto.setFont(new Font("Arial", estilo, 16)); 
    }
}
