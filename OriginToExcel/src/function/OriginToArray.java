package function;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class OriginToArray {
	ArrayList<String> lines;
	ArrayList<Double> datas;
	ArrayList<Double> results;
	ArrayList<String> linesData;
	File file;
	
	public OriginToArray(File file) {
		this.file = file;
		this.lines = new ArrayList<>();
		this.datas = new ArrayList<>();
		this.results = new ArrayList<>();
		this.linesData = new ArrayList<>();
	}
	
	public ArrayList<Double> getData() throws Exception {
		InputStream inputStream = new FileInputStream(file);
		Scanner scan = new Scanner(inputStream);
		while (scan.hasNextLine())
			lines.add(scan.nextLine());
		lines.subList(0, 1500).clear();
		for (int i = 0; i < lines.size()-1; i++) {
			linesData.add(lines.get(i).trim().replaceAll(",", "").replaceAll(";", ""));
			String[] data = linesData.get(i).split(" ");
			for (String d : data)
				if (!d.isEmpty()) {
					datas.add(Double.valueOf(d.trim()));
				}				
		}
		for (int i = 6534; i > 0; i--)
			results.add(datas.get(datas.size()-i));		
		return results;		
	}

}
