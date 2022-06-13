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

import accesoADatos.RepositorioDireccion;
import accesoADatos.RepositorioOficina;
import accesoADatos.RepositorioVendedor;
import clases.Vendedor;
import clases.Direccion;
import clases.Oficina;

import javax.swing.JTextField;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.event.ItemListener;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaVendedor extends JDialog {
	private JTextField textFieldDNI;
	private JTextField textFieldNombre;
	private JTextField textFieldAP1;
	private JTextField textFieldAP2;
	private JTextField textField_zona;
	private JTextField textFieldDireccion;
	private JComboBox comboBox_oficina;
	private JDateChooser dateChooser_fecha_nac;
	private JDateChooser dateChooser_fecha_alta;
	
	private void limpiarCampos() {
		textFieldDNI.setText("");
		textFieldDNI.setEnabled(true);
		textFieldNombre.setText("");
		textFieldNombre.setEnabled(false);
		textFieldAP1.setText("");
		textFieldAP1.setEnabled(false);
		textFieldAP2.setText("");
		textFieldAP2.setEnabled(false);
		dateChooser_fecha_nac.setDate(null);
		dateChooser_fecha_nac.setEnabled(false);
		dateChooser_fecha_alta.setDate(null);
		dateChooser_fecha_alta.setEnabled(false);
		comboBox_oficina.setEnabled(false);
		textField_zona.setEnabled(false);
		textField_zona.setText("");
		
	}

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
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel.setBounds(35, 39, 45, 13);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(35, 92, 68, 13);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Apellido 1");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(35, 142, 68, 13);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Apellido 2");
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(35, 191, 86, 13);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Fecha de nacimiento");
		lblNewLabel_4.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(35, 246, 150, 13);
		getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Fecha de alta");
		lblNewLabel_5.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(387, 77, 102, 13);
		getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Zona");
		lblNewLabel_6.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_6.setBounds(387, 157, 45, 13);
		getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Direccion");
		lblNewLabel_7.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_7.setBounds(387, 117, 86, 13);
		getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Oficina");
		lblNewLabel_8.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_8.setBounds(387, 39, 45, 13);
		getContentPane().add(lblNewLabel_8);
		
		dateChooser_fecha_alta = new JDateChooser();
		dateChooser_fecha_alta.setEnabled(false);
		dateChooser_fecha_alta.setFont(new Font("Arial", Font.PLAIN, 14));
		dateChooser_fecha_alta.setDateFormatString("dd-MM-YYYY");
		dateChooser_fecha_alta.setBounds(523, 71, 124, 19);
		getContentPane().add(dateChooser_fecha_alta);
		
		dateChooser_fecha_nac = new JDateChooser();
		dateChooser_fecha_nac.setEnabled(false);
		dateChooser_fecha_nac.setFont(new Font("Arial", Font.PLAIN, 14));
		dateChooser_fecha_nac.setDateFormatString("dd-MM-YYYY");
		dateChooser_fecha_nac.setBounds(187, 240, 118, 19);
		getContentPane().add(dateChooser_fecha_nac);
		
		textFieldDNI = new JTextField();
		textFieldDNI.setFont(new Font("Arial", Font.PLAIN, 14));
		textFieldDNI.setBounds(131, 36, 96, 19);
		getContentPane().add(textFieldDNI);
		textFieldDNI.setColumns(10);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setEnabled(false);
		textFieldNombre.setFont(new Font("Arial", Font.PLAIN, 14));
		textFieldNombre.setBounds(131, 90, 96, 19);
		getContentPane().add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		textFieldAP1 = new JTextField();
		textFieldAP1.setEnabled(false);
		textFieldAP1.setFont(new Font("Arial", Font.PLAIN, 14));
		textFieldAP1.setBounds(131, 140, 96, 19);
		getContentPane().add(textFieldAP1);
		textFieldAP1.setColumns(10);
		
		textFieldAP2 = new JTextField();
		textFieldAP2.setEnabled(false);
		textFieldAP2.setFont(new Font("Arial", Font.PLAIN, 14));
		textFieldAP2.setBounds(131, 189, 96, 19);
		getContentPane().add(textFieldAP2);
		textFieldAP2.setColumns(10);
		
		textField_zona = new JTextField();
		textField_zona.setEnabled(false);
		textField_zona.setFont(new Font("Arial", Font.PLAIN, 14));
		textField_zona.setBounds(523, 155, 124, 19);
		getContentPane().add(textField_zona);
		textField_zona.setColumns(10);
		
		comboBox_oficina = new JComboBox();
		comboBox_oficina.setEnabled(false);
		comboBox_oficina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Oficina ofi =(Oficina)comboBox_oficina.getSelectedItem();
				textFieldDireccion.setText(ofi.getDireccion().toString());
			}
		});
				
		
		comboBox_oficina.setFont(new Font("Arial", Font.PLAIN, 14));
		comboBox_oficina.setBounds(457, 35, 204, 21);
		getContentPane().add(comboBox_oficina);
		
		DefaultComboBoxModel modeloOficina = new DefaultComboBoxModel(RepositorioOficina.getOficinas());
		comboBox_oficina.setModel(modeloOficina);
		
		JButton btnNewButton_guardar = new JButton("");
		btnNewButton_guardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Oficina ofi =(Oficina)comboBox_oficina.getSelectedItem();
				String fechanac = String.format("%1$td-%1$tm-%1$tY", dateChooser_fecha_nac.getDate());
				String fechaalta = String.format("%1$td-%1$tm-%1$tY", dateChooser_fecha_alta.getDate());
				
				if(RepositorioVendedor.comprobarExistencia(textFieldDNI.getText())==true) {
					RepositorioVendedor.updateVendedor(new Vendedor(textFieldDNI.getText(), textFieldNombre.getText(), textFieldAP1.getText(), textFieldAP2.getText(), fechanac, "Emleado",ofi.getDireccion() ,
							fechaalta.toString(),"Vendedor",(Oficina) comboBox_oficina.getSelectedItem(), textField_zona.getText()));
				}else {
					RepositorioVendedor.newVendedor(new Vendedor(textFieldDNI.getText(), textFieldNombre.getText(), textFieldAP1.getText(), textFieldAP2.getText(), fechanac, "Emleado", ofi.getDireccion(),
							fechaalta,"Vendedor",(Oficina) comboBox_oficina.getSelectedItem(), textField_zona.getText()));
				}
				limpiarCampos();
			}
		});
		btnNewButton_guardar.setIcon(new ImageIcon(VentanaVendedor.class.getResource("/images/btnGuardar.png")));
		btnNewButton_guardar.setBounds(554, 361, 50, 50);
		getContentPane().add(btnNewButton_guardar);
		
		JButton btnNewButton_borrar = new JButton("");
		btnNewButton_borrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RepositorioVendedor.deleteVendedor(textFieldDNI.getText());
				limpiarCampos();
			}
		});
		btnNewButton_borrar.setIcon(new ImageIcon(VentanaVendedor.class.getResource("/images/btnBorrar.png")));
		btnNewButton_borrar.setBounds(476, 361, 50, 50);
		getContentPane().add(btnNewButton_borrar);
		
		JButton btnNewButton_restablecer = new JButton("");
		btnNewButton_restablecer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarCampos();
			}
		});
		btnNewButton_restablecer.setIcon(new ImageIcon(VentanaVendedor.class.getResource("/images/restablecer.png")));
		btnNewButton_restablecer.setBounds(634, 361, 50, 50);
		getContentPane().add(btnNewButton_restablecer);
		
		textFieldDireccion = new JTextField();
		textFieldDireccion.setEditable(false);
		textFieldDireccion.setFont(new Font("Arial", Font.PLAIN, 14));
		textFieldDireccion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		textFieldDireccion.setBounds(483, 115, 178, 19);
		getContentPane().add(textFieldDireccion);
		textFieldDireccion.setColumns(10);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(RepositorioVendedor.comprobarExistencia(textFieldDNI.getText())==true) {
					Vendedor v = RepositorioVendedor.getVendedor(textFieldDNI.getText());
					
					textFieldDNI.setText(v.getDni());
					textFieldDNI.setEnabled(false);
					textFieldNombre.setText(v.getNombre());
					textFieldNombre.setEnabled(true);
					textFieldAP1.setText(v.getAp1());
					textFieldAP1.setEnabled(true);
					textFieldAP2.setText(v.getAp2());
					textFieldAP2.setEnabled(true);
					try {
						dateChooser_fecha_nac.setCalendar(helpers.Converters.StringACalendar(v.getFecha_nac()));
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					dateChooser_fecha_nac.setEnabled(true);
					comboBox_oficina.setSelectedItem(v.getOficina());
					comboBox_oficina.setEnabled(true);
					try {
						dateChooser_fecha_alta.setCalendar(helpers.Converters.StringACalendar(v.getFecha_alta()));
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					dateChooser_fecha_alta.setEnabled(true);
					textField_zona.setText(v.getZona());
					textField_zona.setEnabled(true);
					
				}else{
					textFieldDNI.setEnabled(false);
					textFieldNombre.setEnabled(true);
					textFieldAP1.setEnabled(true);
					textFieldAP2.setEnabled(true);
					dateChooser_fecha_nac.setEnabled(true);
					comboBox_oficina.setEnabled(true);
					dateChooser_fecha_alta.setEnabled(true);
					textField_zona.setEnabled(true);
				}
			}
		});
		btnNewButton.setIcon(new ImageIcon(VentanaVendedor.class.getResource("/images/buscar2.png")));
		btnNewButton.setBounds(237, 25, 30, 30);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaBuscarVendedor buscarV = new VentanaBuscarVendedor();
				buscarV.setVisible(true);
				textFieldDNI.setText(buscarV.v.getDni());
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(VentanaVendedor.class.getResource("/images/lista.png")));
		btnNewButton_1.setBounds(277, 25, 30, 30);
		getContentPane().add(btnNewButton_1);
	}
}
