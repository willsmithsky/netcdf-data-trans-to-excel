package program;

import java.io.File;
import java.util.ArrayList;

import function.DataToExcel;
import function.OriginToTxt;

public class OriginToExcel3 {

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
			
			new DataToExcel(raincData, sec.getAbsolutePath()).createExcel();
			new DataToExcel(raincData, sec.getAbsolutePath()).addToExcel(0);
			new DataToExcel(rainncData, sec.getAbsolutePath()).addToExcel(1);
			new DataToExcel(sum, sec.getAbsolutePath()).addToExcel(2);
		}		
	
	    System.out.println("down");		
	}

}
