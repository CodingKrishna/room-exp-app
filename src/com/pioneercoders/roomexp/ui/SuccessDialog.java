package com.pioneercoders.roomexp.ui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JDialog;

public class SuccessDialog extends JDialog {

	private static final long serialVersionUID = 2192960479029067054L;

	final static SuccessDialog dialog = new SuccessDialog();
	
	static{
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	}
	
	public static SuccessDialog getSuccessDialog(){
		return dialog;
	}
	
	/**
	 * Create the dialog.
	 */
	public SuccessDialog() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JButton btnSuccessfullySubmited = new JButton("Successfully Submitted");
		btnSuccessfullySubmited.setBounds(102, 51, 241, 40);
		getContentPane().add(btnSuccessfullySubmited);
		
		JButton btnOk = new JButton("OK");
		btnOk.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				dialog.setVisible(false);
			}
		});
		btnOk.setBounds(162, 144, 89, 23);
		getContentPane().add(btnOk);

	}

}
