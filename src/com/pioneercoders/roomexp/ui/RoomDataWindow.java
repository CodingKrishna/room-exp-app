package com.pioneercoders.roomexp.ui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import com.pioneercoders.roomexp.common.AppManager;

public class RoomDataWindow {

	private static JFrame mainFrame;

	private static Map<Integer, JPanel>  panelsMap = new HashMap<Integer, JPanel>();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@SuppressWarnings("static-access")
			public void run() {
				try {
					RoomDataWindow window = new RoomDataWindow();
					window.mainFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RoomDataWindow() {
		loadPanels();
		initialize();
	}

	private void loadPanels() {
		panelsMap.put(Constants.ADD_ROOMMATE_PANEL, new AddRoommatePanel());
		panelsMap.put(Constants.DELETE_ROOMMATE_PANEL, new DeleteRoommatePanel());
		panelsMap.put(Constants.INSERT_EXPENDITURE_PANEL, new InsertExpenditurePanel());
		panelsMap.put(Constants.SHOW_ALL_EXPENDITURES_PANEL, new ShowAllExpendituresPanel());
		
	}
	
	public static Map<Integer, JPanel> getObjects(){
		return panelsMap;
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		mainFrame = new JFrame();
		mainFrame.setBounds(230, 130, 900, 500);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		mainFrame.setJMenuBar(menuBar);
		
		JMenu mnRoommate = new JMenu("Roommate");
		mnRoommate.setFont(new Font("Segoe UI", Font.BOLD, 12));
		menuBar.add(mnRoommate);
		
		JMenuItem mntmAdduser = new JMenuItem("Add Roommate");
		
		mntmAdduser.addMouseListener(new MouseAdapter() {			
			@Override
			public void mousePressed(MouseEvent e) {
				clearAllPanels();
				// on add user mouse click..
				AddRoommatePanel addUserPannel= (AddRoommatePanel)panelsMap.get(new Integer(Constants.ADD_ROOMMATE_PANEL));
				mainFrame.getContentPane().add(addUserPannel,BorderLayout.CENTER);
				mainFrame.setVisible(true);
			}
		});
		mnRoommate.add(mntmAdduser);
		
		JMenuItem mntmDeletuser = new JMenuItem("Delet Roommate");
		mntmDeletuser.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				clearAllPanels();
				DeleteRoommatePanel deleteRoommatePanel= (DeleteRoommatePanel)panelsMap.get(new Integer(Constants.DELETE_ROOMMATE_PANEL));
				mainFrame.getContentPane().add(deleteRoommatePanel,BorderLayout.CENTER);
				mainFrame.setVisible(true);
			}
		});
		mnRoommate.add(mntmDeletuser);
		
		JMenu mnExpenditures = new JMenu("Expenditures");
		menuBar.add(mnExpenditures);
		
		JMenuItem mntmInsertrecord = new JMenuItem("Insert Expenditur");
		mntmInsertrecord.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				clearAllPanels();
				InsertExpenditurePanel insertExpenditurePanel= (InsertExpenditurePanel)panelsMap.get(new Integer(Constants.INSERT_EXPENDITURE_PANEL));
				mainFrame.getContentPane().add(insertExpenditurePanel,BorderLayout.CENTER);
				mainFrame.setVisible(true);
			}
		});
		mnExpenditures.add(mntmInsertrecord);
		
		JMenuItem mntmShowAllExpenditures = new JMenuItem("Show All Expenditures");
		mntmShowAllExpenditures.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				clearAllPanels();
				ShowAllExpendituresPanel showAllExpendituresPanel= (ShowAllExpendituresPanel)panelsMap.get(new Integer(Constants.SHOW_ALL_EXPENDITURES_PANEL));
				showAllExpendituresPanel.loadTable();
				mainFrame.getContentPane().add(showAllExpendituresPanel,BorderLayout.CENTER);
				mainFrame.setVisible(true);
			}
		});
		mnExpenditures.add(mntmShowAllExpenditures);
		
		JMenu mnSheet = new JMenu("Sheet");
		menuBar.add(mnSheet);
		
		JMenuItem mntmShow = new JMenuItem("ShowExpenditurSheet");
		mnSheet.add(mntmShow);
		
		JMenuItem mntmSendmail = new JMenuItem("SendMail");
		mntmSendmail.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				clearAllPanels();
				AppManager.getInstance().sendEmail();
			}
		});
		mnSheet.add(mntmSendmail);
		mainFrame.getContentPane().setLayout(new CardLayout(0, 0));
	}
	
	public static JFrame  getMainFreame() {
		return mainFrame;
	}
	
	public static void  clearAllPanels() {
		for(Map.Entry<Integer, JPanel> entry:panelsMap.entrySet()){
			System.out.println(entry.getValue());
			mainFrame.getContentPane().remove(entry.getValue());
		}
	}
	
}
