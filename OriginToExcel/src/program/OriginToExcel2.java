package program;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import function.OriginToTxt;

public class OriginToExcel2 {

	public static void main(String[] args) throws Exception {

		String pathname = "C:\\Users\\sky\\Desktop\\program\\test";
		File first = new File(pathname);
		File[] second = first.listFiles();
				
		for (File sec : second) {
			File[] files = sec.listFiles();
			ArrayList<Double> raincData = new ArrayList<Double>();
			ArrayList<Double> rainncData = new ArrayList<Double>();
			ArrayList<Double> sum = new ArrayList<Double>();
			
			raincData = new OriginToTxt(files, "RAINC").originToTxt();
			rainncData = new OriginToTxt(files, "RAINNC").originToTxt();
			for (int i = 0; i < 6534; i++) {
				sum.add(raincData.get(i) + rainncData.get(i));
			}
			Workbook workbook = new XSSFWorkbook();
			org.apache.poi.ss.usermodel.Sheet sheet = workbook.createSheet("sheet1");
			for (int i = 0; i < sum.size(); i++) {
				Row row = sheet.createRow(i);
				row.createCell(0).setCellValue(raincData.get(i));
				row.createCell(1).setCellValue(rainncData.get(i));
				row.createCell(2).setCellValue(sum.get(i));
			}
			FileOutputStream fos = new FileOutputStream(sec.getAbsolutePath() + "//result.xlsx");	
			workbook.write(fos);
		}
		
	System.out.println("down");	
	
	}

}
