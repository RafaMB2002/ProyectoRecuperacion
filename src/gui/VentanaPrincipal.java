package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaPrincipal extends JFrame {

	private JPanel panelPrincipal;


	/**
	 * Create the frame.
	 */
	public VentanaPrincipal() {
		setTitle("Empresa Programacion");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 720, 480);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menuBarPrincipal = new JMenu("Mantenimiento");
		menuBarPrincipal.setFont(new Font("Arial", Font.PLAIN, 14));
		menuBar.add(menuBarPrincipal);
		
		JMenuItem menuItemOficinas = new JMenuItem("Oficinas");
		menuItemOficinas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Esta es la ventana de mantenimiento de oficinas");
			}
		});
		menuItemOficinas.setFont(new Font("Arial", Font.PLAIN, 14));
		menuBarPrincipal.add(menuItemOficinas);
		
		JMenuItem menuItemDireccion = new JMenuItem("Direccion");
		menuItemDireccion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Esta es la ventana de mantenimiento de Direcciones");
			}
		});
		menuItemDireccion.setFont(new Font("Arial", Font.PLAIN, 14));
		menuBarPrincipal.add(menuItemDireccion);
		
		JMenuItem menuItemEmpleado = new JMenuItem("Empleado");
		menuItemEmpleado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaEmpleado ventanaEmple = new VentanaEmpleado();
				ventanaEmple.setVisible(true);
			}
		});
		menuItemEmpleado.setFont(new Font("Arial", Font.PLAIN, 14));
		menuBarPrincipal.add(menuItemEmpleado);
		panelPrincipal = new JPanel();
		panelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panelPrincipal);
		panelPrincipal.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		setLocationRelativeTo(null);
	}
}
