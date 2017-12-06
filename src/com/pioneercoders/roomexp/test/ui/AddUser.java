package com.pioneercoders.roomexp.test.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AddUser extends JPanel{

	private JFrame frame;
	private JTextField textFieldName;

	JPanel panel;
	private JTextField textFieldMobile;
	private JTextField textFieldEmail;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddUser window = new AddUser();
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
	public AddUser() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(112, 22, 236, 185);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnUname = new JButton("uname");
		btnUname.setBounds(10, 44, 89, 23);
		panel.add(btnUname);
		
		textFieldName = new JTextField();
		textFieldName.setBounds(127, 45, 86, 20);
		panel.add(textFieldName);
		textFieldName.setColumns(10);
		
		JButton btnNewButton = new JButton("submit");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				String uname = textFieldName.getText();
				System.out.println("user name : "+uname);
				
				String mobile = textFieldMobile.getText();
				System.out.println("Mobile Number : "+mobile);
				
				String email = textFieldEmail.getText();
				System.out.println("Email : "+email);
				
				XmlFileGenerations xml = new XmlFileGenerations();
				xml.createXml(uname, mobile, email);
				frame.getContentPane().remove(panel);
				frame.revalidate();
				frame.repaint();
			}
		});
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(74, 151, 89, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Mobile");
		btnNewButton_1.setBounds(10, 75, 89, 23);
		panel.add(btnNewButton_1);
		
		textFieldMobile = new JTextField();
		textFieldMobile.setBounds(127, 76, 86, 20);
		panel.add(textFieldMobile);
		textFieldMobile.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("Email");
		btnNewButton_2.setBounds(10, 109, 89, 23);
		panel.add(btnNewButton_2);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(127, 110, 86, 20);
		panel.add(textFieldEmail);
		textFieldEmail.setColumns(10);
		
		JButton btnAddNewUser = new JButton("Add New User");
		btnAddNewUser.setBounds(51, 10, 131, 23);
		panel.add(btnAddNewUser);
	}
}
