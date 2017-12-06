package com.pioneercoders.roomexp.test.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.FlowLayout;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;

public class RoomExpenApp {

	private JFrame frame;
	
	private static Map<Integer, JPanel> panelMap = new HashMap<Integer, JPanel>();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RoomExpenApp window = new RoomExpenApp();
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
	public RoomExpenApp() {
		loadPanels();
		initialize();
	}

	private void loadPanels() {
		panelMap.put(Constants.ADD_USER, new AddUser());
	}
	
	public static Map<Integer, JPanel> getObjects() {
		return panelMap;
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnAdd = new JMenu("Add");
		menuBar.add(mnAdd);
		
		JMenuItem mntmAddUser = new JMenuItem("Add User");
		mntmAddUser.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				AddUser addUser = (AddUser) panelMap.get(new Integer(Constants.ADD_USER));
				frame.getContentPane().add(addUser, BorderLayout.CENTER);
				frame.setVisible(true);
			}
		});
		mnAdd.add(mntmAddUser);
		
		JMenuItem mntmDeleteUser = new JMenuItem("Delete User");
		mnAdd.add(mntmDeleteUser);
		
		JMenu mnInsert = new JMenu("Insert");
		menuBar.add(mnInsert);
		
		JMenuItem mntmInsertRecord = new JMenuItem("Insert Record");
		mnInsert.add(mntmInsertRecord);
		
		JMenuItem mntmDeleteRecord = new JMenuItem("Delete Record");
		mnInsert.add(mntmDeleteRecord);
		
		JMenu mnGenerate = new JMenu("Generate");
		menuBar.add(mnGenerate);
		
		JMenuItem mntmNewXml = new JMenuItem("New XML");
		mntmNewXml.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
			}
		});
		mnGenerate.add(mntmNewXml);
		
		JMenu mnSend = new JMenu("Send");
		menuBar.add(mnSend);
		
		JMenuItem mntmEmail = new JMenuItem("Email");
		mntmEmail.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				SimpleEmail saEmail = new SimpleEmail();
				saEmail.generateEmail();
			}
		});
		mnSend.add(mntmEmail);
	}

}
