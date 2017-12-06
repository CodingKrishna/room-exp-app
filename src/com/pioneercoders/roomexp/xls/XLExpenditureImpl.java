package com.pioneercoders.roomexp.xls;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class XLExpenditureImpl implements IExpenditure {

	// private String filePath ="E:/RoomExpen.xls";
	private static final XLExpenditureImpl XLExpenditureImpl = new XLExpenditureImpl();

	private XLExpenditureImpl() {

	}

	public static XLExpenditureImpl getInstance() {
		return XLExpenditureImpl;
	}

	private String getCurrentSheetName() {
		Calendar cal = Calendar.getInstance();
	    String sheetName = new SimpleDateFormat("MMM_yyyy").format(cal.getTime());
	    
		return sheetName;
	}

	private HSSFSheet getSheet() {
		FileInputStream file = null;
		try {
			file = new FileInputStream(new File(XL_FILE_NAME));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		// Get the workbook instance for XLS file
		HSSFWorkbook workbook = null;
		try {
			workbook = new HSSFWorkbook(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		// Get first sheet from the workbook
		String sheetName = getCurrentSheetName();
		int index = workbook.getSheetIndex(sheetName);
		HSSFSheet sheet = workbook.getSheetAt(index);
		return sheet;
	}

	private void createXLSheet() {

		HSSFWorkbook workBook = new HSSFWorkbook();
		// Create the spreadsheet
		HSSFSheet spreadSheet = workBook.createSheet(getCurrentSheetName());
		// Create the first row
		HSSFRow row = spreadSheet.createRow((short) 0);

		createHeadRow(row);

		writeSheet(workBook);

	}

	private void createHeadRow(HSSFRow row) {
		// Create the cells and write to the file
		HSSFCell cell;

		// Write Hello
		cell = row.createCell(0);
		cell.setCellValue(new HSSFRichTextString("Date"));

		// Write World
		cell = row.createCell(1);
		cell.setCellValue(new HSSFRichTextString("Name"));

		cell = row.createCell(2);
		cell.setCellValue(new HSSFRichTextString("Description"));

		cell = row.createCell(3);
		cell.setCellValue(new HSSFRichTextString("Amount"));
	}

	private void writeSheet(HSSFWorkbook workBook) {
		// Create object of FileOutputStream
		FileOutputStream fout = null;
		try {
			fout = new FileOutputStream(XL_FILE_NAME);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		// Build the Excel File
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

		try {
			workBook.write(outputStream);
			outputStream.writeTo(fout);
			outputStream.close();
			fout.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private HSSFSheet createRow(String name, String description, String amount) {
		HSSFSheet spreadSheet = getSheet();
		int lastRowNum = spreadSheet.getLastRowNum();
		// Create the first row
		HSSFRow row = spreadSheet.createRow((short) lastRowNum + 1);

		// Create the cells and write to the file
		HSSFCell cell;

		String date = Calendar.getInstance().getTime().toString();
		// Write Hello
		cell = row.createCell(0);
		cell.setCellValue(new HSSFRichTextString(date));

		// Write World
		cell = row.createCell(1);
		cell.setCellValue(new HSSFRichTextString(name));

		cell = row.createCell(2);
		cell.setCellValue(new HSSFRichTextString(description));

		cell = row.createCell(3);
		cell.setCellValue(new HSSFRichTextString(amount));
		return spreadSheet;
	}

	@Override
	public void insertExpenditure(String name, String description, String amount) {
		File file = new File(XL_FILE_NAME);
		if (!file.exists()) {
			createXLSheet();
		}

		HSSFSheet spreadSheet = createRow(name, description, amount);

		writeSheet(spreadSheet.getWorkbook());
	}

	@Override
	public Object[][] getExpenditureSheet() {

		Object[][] rows = null;
		HSSFSheet sheet = getSheet();
		rows = new Object[sheet.getLastRowNum() + 1][4];
		int i = 0;

		// Iterate through each rows from first sheet
		Iterator<Row> rowIterator = sheet.rowIterator();
		while (rowIterator.hasNext()) {
			Row row = rowIterator.next();
			// For each row, iterate through each columns
			Iterator<Cell> cellIterator = row.cellIterator();
			while (cellIterator.hasNext()) {
				Cell cell = cellIterator.next();
				if (cell.getColumnIndex() == 0) {
					rows[i][0] = cell.getStringCellValue();
				} else if (cell.getColumnIndex() == 1) {
					rows[i][1] = cell.getStringCellValue();
				} else if (cell.getColumnIndex() == 2) {
					rows[i][2] = cell.getStringCellValue();
				} else if (cell.getColumnIndex() == 3) {
					rows[i][3] = cell.getStringCellValue();
				}
			}
			i++;
		}

		return rows;
	}

}
