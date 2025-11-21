/*
* Proyecto: swing_c_p01_parte1_CsibiSebastian
* Paquete: vista
* Archivo: PanelEj4.java
* Autor/a: Sebastian Csibi
* Fecha: 11 nov 2025 17:24:40
*
* Descripción:
* [Panel que ajusta el tamaño del texto con un JSlider.]
*
* Licencia:
* [Todos los derechos reservados]
*/
package vista;


import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class PanelEj4 extends JPanel {
	// Declaramos los objetos de este ejercicio //
    private JLabel texto;
    private JSlider sliderTamanio;
    private JLabel valor;
    // Constructor sin paramentros // 
    public PanelEj4() {
    	//Bordes y layouts//
        setBorder(BorderFactory.createTitledBorder("Ejercicio 4"));
        setLayout(new FlowLayout());

        texto = new JLabel("En un lugar de la Mancha, de cuyo nombre...");
        texto.setFont(new Font("Arial", Font.PLAIN, 12));
        // Las funciones de los objetos //
        sliderTamanio = new JSlider(6, 18, 12);
        sliderTamanio.setMajorTickSpacing(2); // Marcas cada 2 números en el slider //
        sliderTamanio.setPaintTicks(true);
        sliderTamanio.setPaintLabels(true);

        valor = new JLabel("Tamaño: 12");

        // Este es el evento. //
        sliderTamanio.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int tam = sliderTamanio.getValue();
                texto.setFont(new Font("Arial", Font.PLAIN, tam));
                valor.setText("Tamaño: " + tam);
            }
        });

        add(texto);
        add(sliderTamanio);
        add(valor);
    }
}