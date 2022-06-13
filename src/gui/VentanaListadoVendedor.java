package gui;

import java.awt.EventQueue;
import java.util.Vector;

import javax.swing.JDialog;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import accesoADatos.RepositorioVendedor;

public class VentanaListadoVendedor extends JDialog {
	private JTable table;

	/**
	 * Create the dialog.
	 */
	public VentanaListadoVendedor() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		DefaultTableModel tableModel = new DefaultTableModel();
		tableModel.addColumn("Nombre Completo");
	    tableModel.addColumn("Oficina");
	    tableModel.addColumn("DNI");
	    
	    
	    
		for(int i=0; i<RepositorioVendedor.getVendedores().size(); i++) {
			Vector v = new Vector();
			v.addElement(RepositorioVendedor.getVendedores().get(i).getNombreCompleto());
			v.addElement(RepositorioVendedor.getVendedores().get(i).getOficina());
			v.addElement(RepositorioVendedor.getVendedores().get(i));
			tableModel.addRow(v);
		}
		table.setModel(tableModel);

	}

}
