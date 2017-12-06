package com.pioneercoders.roomexp.test;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFHeader;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Header;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadAndWriteExcelData {
	public static List<Roommate> readExcelAndWrite() {
		List<Roommate> list = null;
		
			FileInputStream file = null;
			try {
				file = new FileInputStream(new File(
						"C:/Users/SATEESH/Desktop/RoomExpen.xls"));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			// Get the workbook instance for XLS file
			HSSFWorkbook workbook = null;
			try {
				workbook = new HSSFWorkbook(file);
			} catch (IOException e) {
				e.printStackTrace();
			}
			// Get first sheet from the workbook
			HSSFSheet sheet = workbook.getSheetAt(0);
			list = new ArrayList<Roommate>();

			// Iterate through each rows from first sheet
			Iterator<Row> rowIterator = sheet.rowIterator();
			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				if (row.getRowNum() == 0) {
					
				}else{
				Roommate roommate = new Roommate();
				// For each row, iterate through each columns
				Iterator<Cell> cellIterator = row.cellIterator();
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					if (cell.getColumnIndex() == 0) {
						roommate.setDate(cell.getStringCellValue());
					} else if (cell.getColumnIndex() == 1) {
						roommate.setName(cell.getStringCellValue());
					} else if (cell.getColumnIndex() == 2) {
						roommate.setDesc(cell.getStringCellValue());
					} else if (cell.getColumnIndex() == 3) {
						roommate.setAmount(cell.getStringCellValue());
					}
				}
				list.add(roommate);
				}
			}
		return list;
	}
	public static void main(String[] args) {
		List<Roommate> list = readExcelAndWrite();
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			Roommate roommate = (Roommate) iterator.next();
			System.out.println(roommate.getDate() + " " + roommate.getName()
					+ " " + roommate.getDesc() + " " + roommate.getAmount());
		}
	}

}
