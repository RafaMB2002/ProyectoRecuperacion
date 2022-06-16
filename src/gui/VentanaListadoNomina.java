package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import accesoADatos.RepositorioEmpleado;
import accesoADatos.RepositorioVendedor;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class VentanaListadoNomina extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JComboBox comboMeses;
	private JButton btnMuestra;
	private DefaultTableModel tableModel;

	public VentanaListadoNomina() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Elija un mes:");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 14));
		panel.add(lblNewLabel);
		
		comboMeses = new JComboBox();
		comboMeses.setFont(new Font("Arial", Font.PLAIN, 14));
		comboMeses.setModel(new DefaultComboBoxModel(new String[] {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"}));
		panel.add(comboMeses);
		
		btnMuestra = new JButton("Generar Listado");
		btnMuestra.setFont(new Font("Arial", Font.PLAIN, 14));
		btnMuestra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int i=0; i<RepositorioEmpleado.getEmpleados().size(); i++) {
					Vector v = new Vector();
					v.addElement(RepositorioEmpleado.getEmpleados().get(i).getOficina());
					v.addElement(RepositorioEmpleado.getEmpleados().get(i).getNombreCompleto());
					v.addElement(RepositorioEmpleado.getEmpleados().get(i).getTipo_empleado());
					v.addElement(RepositorioEmpleado.getEmpleados().get(i).nomina(comboMeses.getSelectedIndex()+1));
					tableModel.addRow(v);
				}
				table.setModel(tableModel);
				
				TableRowSorter<TableModel> ordenaTabla = new TableRowSorter<TableModel>(tableModel);
				table.setRowSorter(ordenaTabla);
			}
		});
		panel.add(btnMuestra);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		tableModel = new DefaultTableModel();
		tableModel.addColumn("Oficina");
	    tableModel.addColumn("Nombre Completo");
	    tableModel.addColumn("Tipo Empleado");
	    tableModel.addColumn("Nomina");
	    DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
	    
	}

}
