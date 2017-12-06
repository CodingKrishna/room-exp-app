package com.pioneercoders.roomexp.ui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;

import com.pioneercoders.roomexp.common.AppManager;
import javax.swing.JButton;

import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ShowAllExpendituresPanel extends JPanel {
	
	private static final long serialVersionUID = 3670414527360974741L;

	private JTable table;

	Object columnNames[] = { "Date", "Name", "Description", "Amount" };
	
	/**
	 * Create the panel.
	 */
	public ShowAllExpendituresPanel() {
		setLayout(null);
		
		//loadTable();
		
		JButton btnClose = new JButton("Close");
		btnClose.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				JFrame mainFrame = RoomDataWindow.getMainFreame();
				mainFrame.getContentPane().remove(RoomDataWindow.getObjects().get(Constants.SHOW_ALL_EXPENDITURES_PANEL));
				//SuccessDialog.getSuccessDialog().setVisible(true);
			}
		});
		btnClose.setBounds(185, 277, 89, 23);
		add(btnClose);

	}

	public void loadTable() {
		table = new JTable(AppManager.getInstance().getExpenditureSheet(),
				columnNames);
		table.setBounds(new Rectangle(10, 37, 364, 213));
		//table.setBounds(444, 24, -424, 233);
		add(table);
	}
}
