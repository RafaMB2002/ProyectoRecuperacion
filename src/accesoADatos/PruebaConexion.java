package accesoADatos;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.Direccion;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.event.ActionEvent;

public class PruebaConexion extends JFrame {
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PruebaConexion frame = new PruebaConexion();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PruebaConexion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JButton btnNewButton = new JButton("Conectar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				repositorioDireccion repoDireccion = new repositorioDireccion();
				
				//repoDireccion.newDireccion(14, "andujar", 9, 23746);
//				ArrayList<Direccion> arrayDireccion = new ArrayList<Direccion>();
//				arrayDireccion = repoDireccion.getDirecciones();
//				
//				for (Direccion i : arrayDireccion) {
//					  System.out.println(arrayDireccion);
//					}
				
				repoDireccion.updateDireccion(13,"Orecera",0,23746);
	
			}
		});
		contentPane.add(btnNewButton, BorderLayout.CENTER);
	}

}
