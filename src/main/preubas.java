package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class preubas extends JFrame {

	private JPanel contentPane;
	private JDateChooser dateChooser;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					preubas frame = new preubas();
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
	public preubas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("dd-MM-YYYY");
		dateChooser.setBounds(59, 47, 70, 19);
		contentPane.add(dateChooser);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String fecha = String.format("%1$td-%1$tm-%1$tY", dateChooser.getDate());
				JOptionPane.showMessageDialog(null, fecha) ;
			}
		});
		btnNewButton.setBounds(207, 47, 85, 21);
		contentPane.add(btnNewButton);
	}
}
