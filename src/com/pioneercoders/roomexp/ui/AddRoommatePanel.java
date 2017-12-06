package com.pioneercoders.roomexp.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.pioneercoders.roomexp.common.AppManager;

public class AddRoommatePanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6393071711596784922L;
	
	
	private JTextField textFieldUserName;
	private JTextField textFieldEmail;
	private JTextField textFieldMobileNo;

	/**
	 * Create the panel.
	 */
	public AddRoommatePanel() {
		setLayout(null);
		
		JButton btnUsername = new JButton("User Name");
		btnUsername.setBounds(23, 49, 108, 30);
		add(btnUsername);
		
		textFieldUserName = new JTextField();
		textFieldUserName.setBounds(156, 49, 224, 30);
		add(textFieldUserName);
		textFieldUserName.setColumns(10);
		
		JButton btnEmail = new JButton("Email");
		btnEmail.setBounds(23, 85, 108, 30);
		add(btnEmail);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(156, 85, 224, 30);
		add(textFieldEmail);
		textFieldEmail.setColumns(10);
		
		JButton btnMobileNumber = new JButton("Mobile Number");
		btnMobileNumber.setBounds(23, 128, 108, 30);
		add(btnMobileNumber);
		
		textFieldMobileNo = new JTextField();
		textFieldMobileNo.setBounds(156, 128, 224, 30);
		add(textFieldMobileNo);
		textFieldMobileNo.setColumns(10);
		
		JButton btnUserInfoSubmit = new JButton("Submit");
		btnUserInfoSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RoomDataWindow.clearAllPanels();
				String roommateName =textFieldUserName.getText();
				String email = textFieldEmail.getText();
				String mobileNo = textFieldMobileNo.getText();
				System.out.println("UserName:"+roommateName+" email:"+email+" mobileNo:"+mobileNo);
				AppManager.getInstance().addRoommate(roommateName, email, mobileNo);
				clearData();
				RoomDataWindow.clearAllPanels();
				//JFrame mainFrame = RoomDataWindow.getMainFreame();
				//mainFrame.getContentPane().remove(RoomDataWindow.getObjects().get(Constants.ADD_ROOMMATE_PANEL));
				SuccessDialog.getSuccessDialog().setVisible(true);
				
			}
			private void clearData() {
				textFieldUserName.setText("");
				textFieldEmail.setText("");
				textFieldMobileNo.setText("");
			}
			
		});
		btnUserInfoSubmit.setBounds(156, 192, 165, 40);
		add(btnUserInfoSubmit);

	}
}
