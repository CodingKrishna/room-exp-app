package com.pioneercoders.roomexp.test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;

public class CreateExcelFile {
	
	public static void storeHeaderIntoExcel(){
		
		// Directory path where the xls file will be created
	    String destinationFilePath = "C:/Users/SATEESH/Desktop/RoomExpen.xls";	
	    // Create object of FileOutputStream+-
	    FileOutputStream fout=null;
		try {
			fout = new FileOutputStream(destinationFilePath);
		} catch (FileNotFoundException e) {
			System.out.println("file is opened somewhere, please close file first...");
		}
	    // Build the Excel File
	    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	    HSSFWorkbook workBook = new HSSFWorkbook();
	    // Create the spreadsheet
	    HSSFSheet spreadSheet = workBook.createSheet("September");
	    // Create the first row
	    HSSFRow row = spreadSheet.createRow((short) 0);
	   
	    // Create the cells and write to the file
	    HSSFCell cell;
	    cell = row.createCell(0);
	    cell.setCellValue(new HSSFRichTextString("Date"));
	    cell = row.createCell(1);
	    cell.setCellValue(new HSSFRichTextString("Name"));

	    cell = row.createCell(2);
	    cell.setCellValue(new HSSFRichTextString("Description"));
	    
	    cell = row.createCell(3);
	    cell.setCellValue(new HSSFRichTextString("Amount"));
	    
	    try {
			workBook.write(outputStream);
			outputStream.writeTo(fout);
			outputStream.close();
			fout.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	    System.out.println("File created successfully...");
	}
	
	public static void storeDataIntoExcel(String userName, String description, String amount) {
			// Directory path where the xls file will be created
		    String destinationFilePath = "C:/Users/SATEESH/Desktop/RoomExpen.xls";
		    FileInputStream fileInputStream=null;
		    try {
		    	fileInputStream= new FileInputStream(new File(destinationFilePath)); 
			} catch (FileNotFoundException  e) {
				storeHeaderIntoExcel();
				try {
					fileInputStream= new FileInputStream(new File(destinationFilePath));
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		    
		    HSSFWorkbook workBook=null;
			try {
				workBook = new HSSFWorkbook(fileInputStream);
			} catch (IOException e) {
				e.printStackTrace();
			}
		    HSSFSheet spreadSheet = workBook.getSheetAt(0);
		    int lastRow = spreadSheet.getLastRowNum();
		    // Create the first row
		    HSSFRow row = spreadSheet.createRow((short) lastRow+1);
		    // Create the cells and write to the file
		    HSSFCell cell;
		   
		    Date date = new Date();
		    DateFormat dateFormat = new SimpleDateFormat("DD/MM/YYYY HH:MM:SS");
			String formatdate = dateFormat.format(date);
		    cell = row.createCell(0);
		    cell.setCellValue(new HSSFRichTextString(formatdate));
		     
		    cell = row.createCell(1);
		    cell.setCellValue(new HSSFRichTextString(userName));
		     
		    cell = row.createCell(2);
		    cell.setCellValue(new HSSFRichTextString(description));
		    
		    cell = row.createCell(3);
		    cell.setCellValue(new HSSFRichTextString(amount));
		    
		    FileOutputStream fout=null;
			try {
				fout = new FileOutputStream(new File(destinationFilePath));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		    try {
				workBook.write(fout);
				fout.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		    System.out.println("Success");
		
	}
	
	public static void main(String[] args)  {
				storeHeaderIntoExcel();
	 }
}
