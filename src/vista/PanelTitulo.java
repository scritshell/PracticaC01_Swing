/*
* Proyecto: swing_c_p01_parte1_CsibiSebastian
* Paquete: vista
* Archivo: PanelTitulo.java
* Autor/a: Sebastian Csibi
* Fecha: 10 nov 2025 10:01:12
*
* Descripción:
* [Titulo que se mostrara en la parte superior de la ventana]
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

public class PanelTitulo extends JPanel {
    public PanelTitulo() {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createTitledBorder("Panel Título"));

        JLabel titulo = new JLabel("Proyecto Swing - Ejercicios 1 al 5. Hecho por Sebastian Csibi", JLabel.CENTER);
        titulo.setFont(new Font("SansSerif", Font.BOLD, 18));
        add(titulo, BorderLayout.CENTER);
    }
}