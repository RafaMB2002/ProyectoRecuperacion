package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import com.toedter.calendar.JDateChooser;

import accesoADatos.ConexionBD;
import accesoADatos.RepositorioProgramador;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class prueba extends JFrame {

	private JPanel contentPane;
	private JDateChooser dateChooser;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		ConexionBD.abreConexion();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					prueba frame = new prueba();
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
	public prueba() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RepositorioProgramador.newProgramador("54593460Q", "Rafael", "Montoro", "Berdonces", "1997-02-17", 12,
						"Empleado", "1997-02-17", 12, "Programador", "HTML#CSS#JAVA");
			}
		});
		contentPane.add(btnNewButton, BorderLayout.CENTER);
		
		dateChooser = new JDateChooser();
		contentPane.add(dateChooser, BorderLayout.NORTH);
	}

}
