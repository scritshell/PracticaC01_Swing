/*
* Proyecto: swing_c_p01_parte1_CsibiSebastian
* Paquete: vista
* Archivo: PanelEj5.java
* Autor/a: Sebastian Csibi
* Fecha: 11 nov 2025 18:00:12
*
* Descripción:
* [Panel que muestra imágenes según el valor del spinner.]
*
* Licencia:
* [Todos los derechos reservados .]
*/
package vista;

/**
 * 
 */
import javax.swing.*;
import java.awt.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class PanelEj5 extends JPanel {
	// Declaramos los objetos que usaremos en este ejercicio
    private JSpinner spinner;
    private JPanel panelImagenes;
    private JLabel imagen1, imagen2, imagen3, imagen4;
    // Constructor sin parametros //
    public PanelEj5() {
    	// Bordes y layouts//
        setBorder(BorderFactory.createTitledBorder("Ejercicio 5"));
        setLayout(new BorderLayout(10, 10));
        
        // ==================================== //
        // Cargar las imágenes (codigo antiguo) //
        // el nuevo generado por chatgpt 	    //
        //  ajusta el tamaño de las imagenes	//
        // ==================================== //

//        imagen1 = new JLabel(new ImageIcon(getClass().getResource("/recursos/img1.jpg")));
//        imagen2 = new JLabel(new ImageIcon(getClass().getResource("/recursos/img2.jpg")));
//        imagen3 = new JLabel(new ImageIcon(getClass().getResource("/recursos/img3.jpg")));
//        imagen4 = new JLabel(new ImageIcon(getClass().getResource("/recursos/img4.jpg")));
        
        
        // ==================================== //
        // Cargar imagenes, el codigo ajustado  //
        // y ordenado.							//
        // ==================================== //
        
        ImageIcon icono1 = new ImageIcon(getClass().getResource("/recursos/img1.jpg"));
        Image img1 = icono1.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        imagen1 = new JLabel(new ImageIcon(img1));

        ImageIcon icono2 = new ImageIcon(getClass().getResource("/recursos/img2.jpg"));
        Image img2 = icono2.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        imagen2 = new JLabel(new ImageIcon(img2));

        ImageIcon icono3 = new ImageIcon(getClass().getResource("/recursos/img3.jpg"));
        Image img3 = icono3.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        imagen3 = new JLabel(new ImageIcon(img3));

        ImageIcon icono4 = new ImageIcon(getClass().getResource("/recursos/img4.jpg"));
        Image img4 = icono4.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        imagen4 = new JLabel(new ImageIcon(img4));

        
        // El spinner //
        spinner = new JSpinner(new SpinnerNumberModel(0, 0, 4, 1));
        spinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                actualizarImagenes();
            }
        });
        
        // los paneles con las imagenes // 
        panelImagenes = new JPanel();
        panelImagenes.setLayout(new FlowLayout());

        add(spinner, BorderLayout.NORTH);
        add(panelImagenes, BorderLayout.CENTER);

        actualizarImagenes(); // mostrar imagen inicial //
    }

    
// ======================================================================= //
//  Este método que actualiza las imágenes mostradas en el panel. Borra    //
//  las imágenes anteriores y muestra tantas como indique el spinner.      //
// ======================================================================= //

    private void actualizarImagenes() {
        panelImagenes.removeAll();
        int valor = (int) spinner.getValue();

        if (valor >= 1) panelImagenes.add(imagen1);
        if (valor >= 2) panelImagenes.add(imagen2);
        if (valor >= 3) panelImagenes.add(imagen3);
        if (valor >= 4) panelImagenes.add(imagen4);

        panelImagenes.revalidate();
        panelImagenes.repaint();
    }
}
