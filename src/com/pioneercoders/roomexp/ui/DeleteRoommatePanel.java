package com.pioneercoders.roomexp.ui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;

import com.pioneercoders.roomexp.common.AppManager;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DeleteRoommatePanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6854354972546566702L;
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public DeleteRoommatePanel() {
		setLayout(null);
		
		JButton btnRoommateName = new JButton("Roommate Name");
		btnRoommateName.setBounds(43, 109, 125, 35);
		add(btnRoommateName);
		
		textField = new JTextField();
		textField.setBounds(190, 109, 201, 35);
		add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				RoomDataWindow.clearAllPanels();
				System.out.println("************ DeletRoomatePanel **********");
				String roommateEmail = textField.getText();
				System.out.println(" roommateEmail["+roommateEmail+"]");
				AppManager.getInstance().removeRoommate(roommateEmail);
				clearData();
				//JFrame mainFrame = RoomDataWindow.getMainFreame();
				//mainFrame.getContentPane().remove(RoomDataWindow.getObjects().get(Constants.DELETE_ROOMMATE_PANEL));
				RoomDataWindow.clearAllPanels();
				SuccessDialog.getSuccessDialog().setVisible(true);
			}

			private void clearData() {
				textField.setText("");				
			}
		});
		btnNewButton.setBounds(188, 175, 130, 42);
		add(btnNewButton);

	}
}
