package program;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import function.OriginToArray;
import function.TxtToArray;

public class OriginToExcel {

	public static void main(String[] args) throws Exception {

		String pathname = "C:\\Users\\sky\\Desktop\\program\\test";
		File first = new File(pathname);
		File[] second = first.listFiles();
		
		ArrayList<Double> raincData = new ArrayList<Double>();
		ArrayList<Double> rainncData = new ArrayList<Double>();
		ArrayList<Double> raincResult = new ArrayList<Double>();
		ArrayList<Double> rainncResult = new ArrayList<Double>();
		ArrayList<Double> sum = new ArrayList<Double>();
		
		for (File sec : second) {
			File[] files = sec.listFiles();
			for (File f : files) {
				if (f.getName().equals("RAINC")) {
					ArrayList<Double> testData = new OriginToArray(f).getData();
					PrintStream printStream = new PrintStream(new FileOutputStream(new File(f.getParent() + "//RAINC_6534.txt")));
					for (double d : testData)
					    printStream.println(d);
				}
				if (f.getName().equals("RAINNC")) {
					ArrayList<Double> testData = new OriginToArray(f).getData();
					PrintStream printStream = new PrintStream(new FileOutputStream(new File(f.getParent() + "//RAINNC_6534.txt")));
					for (double d : testData)
					    printStream.println(d);
				}
			}
		}
		
		for (File sec : second) {
			File[] files = sec.listFiles();
			for (File f : files) {
				if (f.getName().equals("RAINC_6534.txt")) {
					raincData = new TxtToArray(f).toArrayList();
					for (int i = 6534; i > 0; i --)        
						raincResult.add(raincData.get(raincData.size()-i));
				}
				if (f.getName().equals("RAINNC_6534.txt")) {
					rainncData = new TxtToArray(f).toArrayList();
					for (int i = 6534; i > 0; i --)        
						rainncResult.add(rainncData.get(rainncData.size()-i));
				}
			}
			for (int i = 0; i < 6534; i++) {
				sum.add(raincResult.get(i) + rainncResult.get(i));
			}
			Workbook workbook = new XSSFWorkbook();
			org.apache.poi.ss.usermodel.Sheet sheet = workbook.createSheet("sheet1");
			for (int i = 0; i < sum.size(); i++) {
				Row row = sheet.createRow(i);
				row.createCell(0).setCellValue(raincResult.get(i));
				row.createCell(1).setCellValue(rainncResult.get(i));
				row.createCell(2).setCellValue(sum.get(i));
			}
			FileOutputStream fos = new FileOutputStream(sec.getAbsolutePath() + "//result.xlsx");	
			workbook.write(fos);
			raincData.clear();
			raincResult.clear();
			rainncData.clear();
			rainncResult.clear();
			sum.clear();
		}
		
	System.out.println("down");	
	
	}

}
