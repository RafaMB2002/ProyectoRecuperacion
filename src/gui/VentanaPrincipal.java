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
		setResizable(false);
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
		
		JMenu menuEmpleado = new JMenu("Empleados");
		menuEmpleado.setFont(new Font("Arial", Font.PLAIN, 14));
		menuBarPrincipal.add(menuEmpleado);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Vendedor");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaVendedor ventanaVend = new VentanaVendedor();
				ventanaVend.setVisible(true);
				
			}
		});
		mntmNewMenuItem.setFont(new Font("Arial", Font.PLAIN, 14));
		menuEmpleado.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Programador");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaProgramador ventanaProg = new VentanaProgramador();
				ventanaProg.setVisible(true);
			}
		});
		mntmNewMenuItem_1.setFont(new Font("Arial", Font.PLAIN, 14));
		menuEmpleado.add(mntmNewMenuItem_1);
		
		JMenu mnNewMenu = new JMenu("Listados");
		mnNewMenu.setFont(new Font("Arial", Font.PLAIN, 14));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Programadores");
		mntmNewMenuItem_2.setFont(new Font("Arial", Font.PLAIN, 14));
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Vendedores");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaListadoVendedor v = new VentanaListadoVendedor();
				v.setVisible(true);
			}
		});
		mntmNewMenuItem_3.setFont(new Font("Arial", Font.PLAIN, 14));
		mnNewMenu.add(mntmNewMenuItem_3);
		panelPrincipal = new JPanel();
		panelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panelPrincipal);
		panelPrincipal.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		setLocationRelativeTo(null);
	}
}
