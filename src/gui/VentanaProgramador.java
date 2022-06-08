package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;

public class VentanaProgramador extends JDialog {


	/**
	 * Create the dialog.
	 */
	public VentanaProgramador() {
		setModal(true);
		setResizable(false);
		setTitle("Programadores");
		setBounds(100, 100, 720, 480);
		getContentPane().setLayout(new BorderLayout());
		
		setLocationRelativeTo(null);
	}

}
