package com.pioneercoders.roomexp.ui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.pioneercoders.roomexp.common.AppManager;

public class InsertExpenditurePanel extends JPanel {
	
	private static final long serialVersionUID = -5616047485249975535L;
	
	private JComboBox comboBoxUserNames;
	private JTextField textFieldDescription;
	private JTextField txtEnterAmount;

	/**
	 * Create the panel.
	 */
	public InsertExpenditurePanel() {
		setLayout(null);

		comboBoxUserNames = new JComboBox(getComboBoxModeDefalutvalues());
		
		comboBoxUserNames.setSelectedIndex(0);
		comboBoxUserNames.setBounds(10, 81, 88, 33);
		add(comboBoxUserNames);
		

		textFieldDescription = new JTextField();
		textFieldDescription.setText("Enter Description");
		textFieldDescription.setBounds(112, 81, 216, 33);
		add(textFieldDescription);
		textFieldDescription.setColumns(10);
		
		txtEnterAmount = new JTextField();
		txtEnterAmount.setText("Enter Amount");
		txtEnterAmount.setBounds(352, 81, 88, 33);
		add(txtEnterAmount);
		txtEnterAmount.setColumns(10);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				RoomDataWindow.clearAllPanels();
				String name = comboBoxUserNames.getSelectedItem().toString();

				String description = textFieldDescription.getText();
				String amount = txtEnterAmount.getText();
				AppManager.getInstance().addExpenditure(name, description, amount);
				clearData();
				RoomDataWindow.clearAllPanels();
				//JFrame mainFrame = RoomDataWindow.getMainFreame();
				//mainFrame.getContentPane().remove(RoomDataWindow.getObjects().get(Constants.INSERT_EXPENDITURE_PANEL));
				SuccessDialog.getSuccessDialog().setVisible(true);
			}

			private void clearData() {
				comboBoxUserNames.setSelectedIndex(0);
				textFieldDescription.setText("");
				txtEnterAmount.setText("");
			}
		});
		btnSubmit.setBounds(178, 154, 110, 33);
		add(btnSubmit);

	}

	private DefaultComboBoxModel getComboBoxModeDefalutvalues() {

		DefaultComboBoxModel userName = new DefaultComboBoxModel();
		userName.addElement("--Select--");
		userName.addElement("HariKrishna");
		userName.addElement("Siva");
		userName.addElement("Sateesh");
		userName.addElement("Jakesh");
		userName.addElement("Vamshi");

		return userName;

	}
}
