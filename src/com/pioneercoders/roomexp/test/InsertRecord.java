package com.pioneercoders.roomexp.test;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
 
public class InsertRecord {
    
   private JFrame mainFrame;
   private JLabel headerLabel;
   private JLabel statusLabel;
   private JPanel controlPanel;
   private JTextField textFieldDate;
   private JTextField textFieldDescription;
   private JTextField textFieldAmount;

   public InsertRecord(){
      prepareGUI();
   }

   public static void main(String[] args){
	   InsertRecord  swingControlDemo = new InsertRecord();      
      swingControlDemo.showComboboxDemo();
   }

   private void prepareGUI(){
      mainFrame = new JFrame("Java Swing Examples");
      mainFrame.setSize(600,400);
      mainFrame.getContentPane().setLayout(new GridLayout(3, 1));
      mainFrame.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent windowEvent){
            System.exit(0);
         }        
      });    
      headerLabel = new JLabel("", JLabel.CENTER);        
      statusLabel = new JLabel("",JLabel.CENTER);    

      statusLabel.setSize(350,100);

      controlPanel = new JPanel();
      controlPanel.setLayout(new FlowLayout());

      mainFrame.getContentPane().add(headerLabel);
      mainFrame.getContentPane().add(controlPanel);
      mainFrame.getContentPane().add(statusLabel);
      mainFrame.setVisible(true);  
   }

   private void showComboboxDemo(){                                    
      headerLabel.setText("Add Daily Expensions"); 

      final DefaultComboBoxModel userName = new DefaultComboBoxModel();

      //userName.addElement("--Select--");
      userName.addElement("HariKrishna");
      userName.addElement("Siva");
      userName.addElement("Sateesh");
      userName.addElement("Jakesh");
      userName.addElement("Vamshi");

      final JComboBox userCombo = new JComboBox(userName);    
      userCombo.setSelectedIndex(-1);

      JScrollPane userScrollPane = new JScrollPane(userCombo);    

      JButton showButton = new JButton("Add");
      showButton.addMouseListener(new MouseAdapter() {
      	@Override
      	public void mousePressed(MouseEvent e) {
      		 String description = textFieldDescription.getText();
      		 System.out.println(description);
      		 
      		 String amount = textFieldAmount.getText();
      		 System.out.println(amount);
      		 
      		 String userName = (String) userCombo.getItemAt(userCombo.getSelectedIndex());
      		 System.out.println(userName);
      		 
      		CreateExcelFile.storeDataIntoExcel(userName, description, amount);
      		 
      	}
      });

      showButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) { 
            String data = "";
            if (userCombo.getSelectedIndex() != -1) {                     
               data = "User Selected: " 
                  + userCombo.getItemAt
                    (userCombo.getSelectedIndex());             
            }              
            statusLabel.setText(data);
         }
      }); 
      controlPanel.add(userScrollPane);          
  	  
      Date date = new Date();
      textFieldDate = new JTextField();
      controlPanel.add(textFieldDate);
      textFieldDate.setColumns(10);
      
      
      textFieldDescription = new JTextField();
      controlPanel.add(textFieldDescription);
      textFieldDescription.setColumns(10);
      
      textFieldAmount = new JTextField();
      controlPanel.add(textFieldAmount);
      textFieldAmount.setColumns(10);
      controlPanel.add(showButton);    
      mainFrame.setVisible(true);             
   }
}