package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import accesoADatos.RepositorioVendedor;
import clases.Vendedor;

import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import java.awt.ScrollPane;
import java.util.Vector;
import java.awt.List;
import javax.swing.AbstractListModel;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VentanaBuscarVendedor extends JDialog {
	private JTable table;
	public Vendedor v;
	/**
	 * Create the dialog.
	 */
	public VentanaBuscarVendedor() {
		setModal(true);
		setResizable(false);
		setBounds(100, 100, 400, 300);
		getContentPane().setLayout(new BorderLayout());
		
		JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				int fila = table.getSelectedRow();
				v = (Vendedor) table.getValueAt(fila, 2);
				setVisible(false);
				
				
			}
		});
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
		
		TableRowSorter<TableModel> ordenaTabla = new TableRowSorter<TableModel>(tableModel);
		table.setRowSorter(ordenaTabla);
		
	}

}
