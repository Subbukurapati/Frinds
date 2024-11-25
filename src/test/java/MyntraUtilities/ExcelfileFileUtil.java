package MyntraUtilities;


import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.IOException;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelfileFileUtil {
	Workbook wb;
	
	public ExcelfileFileUtil(String Excelpath) throws Throwable, IOException {
		FileInputStream fi=new FileInputStream(Excelpath);
		wb=WorkbookFactory.create(fi); //1st mistak  wb= new WorkbookFactory.create(fi);

	}
	//count number of rows
	public int rowcount(String sheetName ) {
		return wb.getSheet(sheetName).getLastRowNum();

	}
	//method for reading cell data
	public String getcellData(String sheetName, int Row, int Coloum) {
		String data;
		if(wb.getSheet(sheetName).getRow(Row).getCell(Coloum).getCellType()==CellType.NUMERIC) {
			int celldata=(int) wb.getSheet(sheetName).getRow(Row).getCell(Coloum).getNumericCellValue();
			data=String.valueOf(celldata);
		}else {
			data=wb.getSheet(sheetName).getRow(Row).getCell(Coloum).getStringCellValue();
		}
		return data;

	}
	//method for setcelldata
	public void setcelldata(String sheetName, int row, int coloum, String Status, String writeexcelpath) throws Throwable {
		//get sheet from wb
		Sheet ws=wb.getSheet(sheetName);
		//get row from sheet
		Row rownum=ws.getRow(row);
		//create a cell in row
		Cell cell=rownum.createCell(coloum);
		//write status
		cell.setCellValue(Status);
		if(Status.equalsIgnoreCase("Pass")) {
			CellStyle style=wb.createCellStyle();
			org.apache.poi.ss.usermodel.Font font= wb.createFont();
			//color with green
			font.setColor(IndexedColors.GREEN.getIndex());
			font.setBold(true);
			style.setFont(font);
			ws.getRow(row).getCell(coloum).setCellStyle(style);

		}else if(Status.equalsIgnoreCase("Fail")){
			CellStyle style=wb.createCellStyle();
			org.apache.poi.ss.usermodel.Font font=wb.createFont();
			font.setColor(IndexedColors.RED.getIndex());
			font.getBold();
			style.setFont(font);
			ws.getRow(row).getCell(coloum).setCellStyle(style);

		}else if (Status.equalsIgnoreCase("Block")) {
			CellStyle style=wb.createCellStyle();
			org.apache.poi.ss.usermodel.Font font=wb.createFont();
			font.setColor(IndexedColors.BLUE.getIndex());
			font.setBold(true);
			style.setFont(font);
			ws.getRow(row).getCell(coloum).setCellValue(Status);

		}
		FileOutputStream fo=new FileOutputStream(writeexcelpath);
		wb.write(fo);

	}

}
