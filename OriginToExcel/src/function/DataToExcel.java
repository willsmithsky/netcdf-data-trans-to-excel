package function;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataToExcel {
	ArrayList<Double> data;
	File dataFile;
	String pathName;
		
	public DataToExcel(ArrayList<Double> data, String pathName) {
		this.data = data;
		this.pathName = pathName;
	}
	
	public DataToExcel(File dataFile) throws FileNotFoundException {
		this.dataFile = dataFile;
		this.data = new TxtToArray(this.dataFile).toArrayList();
		this.pathName = dataFile.getParent();
	}
	
	public void createExcel() throws Exception {
		Workbook workbook = new XSSFWorkbook();
		Sheet sheet = workbook.createSheet("sheet1");
		for (int i = 0; i < data.size(); i++) {
			Row row = sheet.createRow(i);
		}
		FileOutputStream fos = new FileOutputStream(pathName + "//result.xlsx");	
		workbook.write(fos);
		workbook.close();
		fos.close();
	}
	
	public void addToExcel(int column) throws Exception {
		FileInputStream getExcel = new FileInputStream(pathName + "//result.xlsx");
		Workbook addWorkbook = new XSSFWorkbook(getExcel);
		Sheet addSheet = addWorkbook.getSheet("sheet1");
		for (int i = 0; i < data.size(); i++) {
			Row row = addSheet.getRow(i);
			row.createCell(column).setCellValue(data.get(i));
		}
		FileOutputStream fos = new FileOutputStream(pathName + "//result.xlsx");	
		addWorkbook.write(fos);
		addWorkbook.close();
		fos.close();
	}
	
	public void sum() throws Exception {
		FileInputStream getExcel = new FileInputStream(pathName + "//result.xlsx");
		Workbook sumWorkbook = new XSSFWorkbook(getExcel);
		Sheet sumSheet = sumWorkbook.getSheet("sheet1");
		for (int i = 0; i < data.size(); i++) {
			Row row = sumSheet.getRow(i);
			row.createCell(2).setCellFormula("A" + (i + 1) + "+" + "B" + (i + 1));
		}
		FileOutputStream fos = new FileOutputStream(pathName + "//result.xlsx");	
		sumWorkbook.write(fos);
		sumWorkbook.close();
		fos.close();
	}

}
