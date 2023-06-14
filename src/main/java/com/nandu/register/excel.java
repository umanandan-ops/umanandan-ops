package com.nandu.register;

import java.io.File;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class excel {
	public static void main(String[] args) throws Exception {
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet=workbook.createSheet();
		sheet.createRow(0);
		sheet.getRow(0).createCell(0).setCellValue("Nandan");
		sheet.getRow(0).createCell(1).setCellValue("for ths sake og kjfldkfjdsl");
		sheet.createRow(1);
		sheet.getRow(1).createCell(0).setCellValue("Umanandan");
		sheet.getRow(1).createCell(1).setCellValue("Yeedi");
		File file =new File("C:\\Users\\nanda\\eclipse-workspace\\registration\\Excel-sheets\\test.xls");
		workbook.write(file);
		workbook.close();
		
	}
}
