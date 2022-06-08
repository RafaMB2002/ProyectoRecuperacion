package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;
import javax.swing.JTextField;

public class VentanaVendedor extends JDialog {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;


	/**
	 * Create the dialog.
	 */
	public VentanaVendedor() {
		setResizable(false);
		setModal(true);
		setTitle("Vendedores");
		setBounds(100, 100, 720, 480);
		
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("DNI");
		lblNewLabel.setBounds(35, 39, 45, 13);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setBounds(35, 77, 45, 13);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Apellido 1");
		lblNewLabel_2.setBounds(35, 117, 45, 13);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Apellido 2");
		lblNewLabel_3.setBounds(35, 158, 45, 13);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Fecha de nacimiento");
		lblNewLabel_4.setBounds(35, 203, 102, 13);
		getContentPane().add(lblNewLabel_4);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(131, 250, 29, 21);
		getContentPane().add(comboBox);
		
		JLabel lblNewLabel_5 = new JLabel("Fecha de alta");
		lblNewLabel_5.setBounds(35, 295, 102, 13);
		getContentPane().add(lblNewLabel_5);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(131, 337, 29, 21);
		getContentPane().add(comboBox_1);
		
		JLabel lblNewLabel_6 = new JLabel("Zona");
		lblNewLabel_6.setBounds(35, 391, 45, 13);
		getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Direccion");
		lblNewLabel_7.setBounds(35, 254, 45, 13);
		getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Oficina");
		lblNewLabel_8.setBounds(35, 341, 45, 13);
		getContentPane().add(lblNewLabel_8);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(131, 289, 70, 19);
		getContentPane().add(dateChooser);
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(131, 203, 70, 19);
		getContentPane().add(dateChooser_1);
		
		textField = new JTextField();
		textField.setBounds(131, 36, 96, 19);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(131, 74, 96, 19);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(131, 114, 96, 19);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(131, 155, 96, 19);
		getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(131, 388, 96, 19);
		getContentPane().add(textField_4);
		textField_4.setColumns(10);
	}
}
