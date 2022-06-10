package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import accesoADatos.RepositorioVendedor;

import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import java.awt.ScrollPane;
import java.awt.List;
import javax.swing.AbstractListModel;

public class VentanaBuscarVendedor extends JDialog {
	/**
	 * Create the dialog.
	 */
	public VentanaBuscarVendedor() {
		setModal(true);
		setResizable(false);
		setBounds(100, 100, 300, 300);
		getContentPane().setLayout(new BorderLayout());
		
		JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		JList list = new JList();
		scrollPane.setViewportView(list);
		
		//Crear un objeto DefaultListModel
		DefaultListModel listModel = new DefaultListModel();
		//Recorrer el contenido del ArrayList
		for(int i=0; i<RepositorioVendedor.getVendedores().size(); i++) {
		    //Añadir cada elemento del ArrayList en el modelo de la lista
		    listModel.add(i, RepositorioVendedor.getVendedores().get(i));
		}
		//Asociar el modelo de lista al JList
		list.setModel(listModel);
		
	}

}
