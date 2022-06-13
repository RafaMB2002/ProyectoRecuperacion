package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.toedter.components.JSpinField;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class NominaEmpleados extends JDialog {
	private JTextField textFieldDNI;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			NominaEmpleados dialog = new NominaEmpleados();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public NominaEmpleados() {
		setBounds(100, 100, 350, 300);
		getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Calcular nomina");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	
			}
		});
		btnNewButton.setBounds(195, 20, 117, 21);
		getContentPane().add(btnNewButton);
		
		textFieldDNI = new JTextField();
		textFieldDNI.setBounds(21, 21, 124, 19);
		getContentPane().add(textFieldDNI);
		textFieldDNI.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(NominaEmpleados.class.getResource("/images/buscar2.png")));
		btnNewButton_1.setBounds(155, 11, 30, 30);
		getContentPane().add(btnNewButton_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(119, 122, 96, 19);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("NOMINA:");
		lblNewLabel.setBounds(140, 103, 45, 13);
		getContentPane().add(lblNewLabel);
	}
}
