package com.pioneercoders.roomexp.test.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DeleteRecord {

	private JFrame frame;
	private JTextField textFieldUnametoDelete;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteRecord window = new DeleteRecord();
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
	public DeleteRecord() {
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
		
		JButton btnDeleteRecord = new JButton("Delete Record From Here");
		btnDeleteRecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDeleteRecord.setBounds(103, 43, 242, 23);
		frame.getContentPane().add(btnDeleteRecord);
		
		textFieldUnametoDelete = new JTextField();
		textFieldUnametoDelete.setBounds(86, 100, 121, 23);
		frame.getContentPane().add(textFieldUnametoDelete);
		textFieldUnametoDelete.setColumns(10);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(258, 99, 110, 23);
		frame.getContentPane().add(btnDelete);
	}
}
