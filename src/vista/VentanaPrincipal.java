/*
* Proyecto: swing_c_p01_parte1_CsibiSebastian
* Paquete: vista
* Archivo: VentanaPrincipal.java
* Autor/a: Sebastian Csibi
* Fecha: 11 nov 2025 10:01:03
*
* Descripción:
* [La ventana principal que gestiona la visualización de los 5 ejercicios Swing
*   Nos permite activar/desactivar cada ejercicio mediante checkboxes y mostrar
*   los ejercicios activos en cualquier momento segun lo que desee el usuario  ]
*
* Licencia:
* [Todos los derechos reservados]
*/
package vista;

import java.awt.BorderLayout;
import java.awt.Toolkit;
import javax.swing.*;

public class VentanaPrincipal extends JFrame {
	// Declaramos los objetos que usaremos //
    private JPanel panelCentral;
    private JPanel panelBotones;
    private JCheckBox ejercicio1, ejercicio2, ejercicio3, ejercicio4, ejercicio5;
    private PanelEj1 panelEj1; private PanelEj2 panelEj2; private PanelEj3 panelEj3; private PanelEj4 panelEj4; private PanelEj5 panelEj5;
    private PanelTitulo panelTitulo;
    
    
    public VentanaPrincipal() {
        super("Swing Práctica01 - C - Sebastian Csibi");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(
                getClass().getResource("/recursos/icono.png")));
        
        // Panel superior con el título
        panelTitulo = new PanelTitulo();
        this.add(panelTitulo, BorderLayout.NORTH);
        
        // Panel principal que contendrá botones (izquierda) y ejercicios (centro)
        JPanel panelPrincipal = new JPanel(new BorderLayout());
        
        // Panel para los botones en la izquierda //
        panelBotones = new JPanel();
        panelBotones.setLayout(new BoxLayout(panelBotones, BoxLayout.Y_AXIS)); //BoxLayout ordena los componentes, Y_AXIS lo hara de forma vertical //
        
        // Crear cada checkbox d forma individual //
        ejercicio1 = new JCheckBox("Ejercicio 1");
        ejercicio2 = new JCheckBox("Ejercicio 2");
        ejercicio3 = new JCheckBox("Ejercicio 3");
        ejercicio4 = new JCheckBox("Ejercicio 4");
        ejercicio5 = new JCheckBox("Ejercicio 5");
        
        // Añadimos los action listeners a cada ejercicio //
        ejercicio1.addActionListener(e -> actualizarVista());
        ejercicio2.addActionListener(e -> actualizarVista());
        ejercicio3.addActionListener(e -> actualizarVista());
        ejercicio4.addActionListener(e -> actualizarVista());
        ejercicio5.addActionListener(e -> actualizarVista());
        
        // Añadimos los paneles //
        panelBotones.add(ejercicio1);
        panelBotones.add(ejercicio2);
        panelBotones.add(ejercicio3);
        panelBotones.add(ejercicio4);
        panelBotones.add(ejercicio5);
        
        // Botón para mostrar los ejercicios activos //
        JButton btnActivos = new JButton("Ejercicios Activos");
        btnActivos.addActionListener(e -> mostrarEjerciciosActivos());
        panelBotones.add(btnActivos);
        
        // Añadir panel de botones a la izquierda del panel principal
        panelPrincipal.add(panelBotones, BorderLayout.WEST);
        
        // Panel central para los ejercicios //
        panelCentral = new JPanel();
        panelCentral.setLayout(new BoxLayout(panelCentral, BoxLayout.Y_AXIS));
        
        // Crear los paneles de ejercicios //
        panelEj1 = new PanelEj1();
        panelEj2 = new PanelEj2();
        panelEj3 = new PanelEj3();
        panelEj4 = new PanelEj4();
        panelEj5 = new PanelEj5();
        
        // ============================================== //
        // Con esto, los ejercicios estarán ocultos al    //
        // inicio del programa.							  //
        // ============================================== //

        panelEj1.setVisible(false);
        panelEj2.setVisible(false);
        panelEj3.setVisible(false);
        panelEj4.setVisible(false);
        panelEj5.setVisible(false);
        
        // Añadir todos los paneles al panel central //
        panelCentral.add(panelEj1);
        panelCentral.add(panelEj2);
        panelCentral.add(panelEj3);
        panelCentral.add(panelEj4);
        panelCentral.add(panelEj5);
        
        // Añadir panel de ejercicios al centro del panel principal
        panelPrincipal.add(new JScrollPane(panelCentral), BorderLayout.CENTER);
        
        // Añadir panel principal al centro del frame
        this.add(panelPrincipal, BorderLayout.CENTER);
        
        this.setSize(900, 600);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    
    
    // =========================================== //
    // Este metodo visibiliza los ejercicios segun //
    // la decision del usuario al clickear los	   //
    // botones correspondientes.				   //
    // =========================================== //

    
    private void actualizarVista() {
        // Actualiza la visibilidad de cada panel según su checkbox //
        panelEj1.setVisible(ejercicio1.isSelected());
        panelEj2.setVisible(ejercicio2.isSelected());
        panelEj3.setVisible(ejercicio3.isSelected());
        panelEj4.setVisible(ejercicio4.isSelected());
        panelEj5.setVisible(ejercicio5.isSelected());
        
        // Refresca el panel (codigo pedido a chatgpt) //
        panelCentral.revalidate();
        panelCentral.repaint();
    }
    
    // =========================================== //
    // Este metodo avisa de los ejercicios que     //
    // están seleccionados en el  preciso momento  //
    // =========================================== //
    private void mostrarEjerciciosActivos() {
        StringBuilder activos = new StringBuilder("Ejercicios activos:\n");
        
        // Verifica cada checkbox de forma individual //
        if (ejercicio1.isSelected()) {
            activos.append("Ejercicio 1\n");
        }
        if (ejercicio2.isSelected()) {
            activos.append("Ejercicio 2\n");
        }
        if (ejercicio3.isSelected()) {
            activos.append("Ejercicio 3\n");
        }
        if (ejercicio4.isSelected()) {
            activos.append("Ejercicio 4\n");
        }
        if (ejercicio5.isSelected()) {
            activos.append("Ejercicio 5\n");
        }
        
        // Si no hay ejercicios activos, sale este mensaje //
        if (activos.toString().equals("Ejercicios activos: \n")) {
            activos.append("Ningún ejercicio activo");
        }
        
        // Un buen mensaje de dialogo para mejorar el metodo! //
        JOptionPane.showMessageDialog(this, activos.toString(), "Ejercicios Activos", JOptionPane.INFORMATION_MESSAGE);
    }
}