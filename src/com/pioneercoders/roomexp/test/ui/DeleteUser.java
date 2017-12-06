package com.pioneercoders.roomexp.test.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DeleteUser {

	private JFrame frame;
	private JTextField textFieldDeleteUser;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteUser window = new DeleteUser();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DeleteUser() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, "name_30322138120724");
		
		JButton btnDeleteUser = new JButton("User Name");
		btnDeleteUser.setBounds(84, 90, 120, 23);
		btnDeleteUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel.setLayout(null);
		panel.add(btnDeleteUser);
		
		textFieldDeleteUser = new JTextField();
		textFieldDeleteUser.setBounds(214, 91, 108, 20);
		panel.add(textFieldDeleteUser);
		textFieldDeleteUser.setColumns(10);
		
		JButton btnNewButton = new JButton("Delete");
		btnNewButton.setBounds(160, 142, 92, 23);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				String uname = textFieldDeleteUser.getText();
				System.out.println(uname);
				
				XmlFileGenerations xml = new XmlFileGenerations();
				xml.deleteRecord(uname);
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel.add(btnNewButton);
	}

}
