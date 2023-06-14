package com.nandu.register;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class db_data_excel {
	  public static void main(String[] args) {
	        String jdbcUrl = "jdbc:mysql://localhost:3306/medical_data";
	        String username = "root";
	        String password = "Chrome@123";
	        String tableName = "medicine_info";
	        String outputPath = "C:\\Users\\nanda\\OneDrive\\Desktop\\Excel-sheets\\database_data.xlsx";

	        try {
	            // Establish a database connection
	            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
	            
	            // Create a statement to execute SQL queries
	            Statement statement = connection.createStatement();
	            
	            // Retrieve all data from the table
	            ResultSet resultSet = statement.executeQuery("SELECT * FROM " + tableName);
	            
	            // Create a new workbook
	            XSSFWorkbook workbook = new XSSFWorkbook();
	            
	            // Create a sheet within the workbook
	            XSSFSheet sheet = workbook.createSheet(tableName);
	            
	            // Get metadata of the result set
	            ResultSetMetaData metaData = resultSet.getMetaData();
	            
	            // Get the number of columns in the result set
	            int columnCount = metaData.getColumnCount();
	            
	            // Create the header row and populate it with column names
	            sheet.createRow(0);
	            for (int i = 1; i <= columnCount; i++) {
	                String columnName = metaData.getColumnName(i);
	                sheet.getRow(0).createCell(i - 1).setCellValue(columnName);
	            }
	            
	            // Populate the remaining rows with data
	            int rowNum = 1;
	            while (resultSet.next()) {
	                sheet.createRow(rowNum);
	                for (int i = 1; i <= columnCount; i++) {
	                    Object value = resultSet.getObject(i);
	                    sheet.getRow(rowNum).createCell(i - 1).setCellValue(value.toString());
	                }
	                rowNum++;
	            }
	            
	            // Specify the file path where the Excel file will be saved
	            File file = new File(outputPath);
	            
	            // Write the workbook data to the file
	            FileOutputStream outputStream = new FileOutputStream(file);
	            workbook.write(outputStream);
	            outputStream.close();

	            System.out.println("Database data exported to Excel successfully.");
	            
	            // Close resources
	            resultSet.close();
	            statement.close();
	            connection.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	}