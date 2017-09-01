package program;

import java.io.File;
import java.util.ArrayList;

import function.DataToExcel;
import function.OriginToTxt;

public class OriginToExcel4 {

	public static void main(String[] args) throws Exception {

		String pathname = "C:\\Users\\sky\\Desktop\\program\\test";
		File first = new File(pathname);
		
		File[] second = first.listFiles();		
		for (File sec : second) {
			File[] files = sec.listFiles();
			ArrayList<Double> raincData = new ArrayList<Double>();
			ArrayList<Double> rainncData = new ArrayList<Double>();
			
			raincData = new OriginToTxt(files, "RAINC").originToTxt();
			rainncData = new OriginToTxt(files, "RAINNC").originToTxt();
			
			new DataToExcel(raincData, sec.getAbsolutePath()).createExcel();
			new DataToExcel(raincData, sec.getAbsolutePath()).addToExcel(0);
			new DataToExcel(rainncData, sec.getAbsolutePath()).addToExcel(1);
			new DataToExcel(raincData, sec.getAbsolutePath()).sum();

		}		
	
	    System.out.println("down");		
	}

}
