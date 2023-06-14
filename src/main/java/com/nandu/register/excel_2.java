package com.nandu.register;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excel_2 {
	public static void main(String[] args) throws Exception {
		XSSFWorkbook workbook=new XSSFWorkbook();
		XSSFSheet sheet=workbook.createSheet();
		sheet.createRow(0);
		sheet.getRow(0).createCell(0).setCellValue("Yeedi");
		sheet.getRow(0).createCell(1).setCellValue("Pardha");
		sheet.getRow(0).createCell(2).setCellValue("Gopi");
		sheet.getRow(0).createCell(3).setCellValue("Krishna");
	
		sheet.createRow(1);
		sheet.getRow(1).createCell(0).setCellValue("yeedi");
		sheet.getRow(1).createCell(1).setCellValue("Uma");
		sheet.getRow(1).createCell(2).setCellValue("Nandan");
		File file=new File("C:\\Users\\nanda\\OneDrive\\Desktop\\Excel-sheets\\second.xlsx");
		try {
			FileOutputStream os=new FileOutputStream(file);
			workbook.write(os);
			os.close();
			System.out.println("data is entered into excel successfully");
		}
		catch (IOException e){
			e.printStackTrace();
		}
		finally {
			try {
				workbook.close();
			}
			catch (IOException e){
				e.printStackTrace();
				
			}
		}
		
	}
}
