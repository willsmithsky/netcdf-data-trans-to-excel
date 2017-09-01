package function;

import java.io.File;
import java.util.ArrayList;

public class OriginToTxt {
	File[] parent;
	String fileName;
	
	public OriginToTxt(File[] parent, String fileName) {
		this.parent = parent;
		this.fileName = fileName;
	}
	
	public ArrayList<Double> originToTxt() throws Exception {
		ArrayList<Double> fileData = new ArrayList<>();
		for (File p : parent) {
			if (p.getName().equals(fileName)) {
				fileData = new OriginToArray(p).getData();
				String pathOut = p.getParent() + "//" + fileName + "_6534.txt";
				new ArrayToTxt(fileData, pathOut).toTxt();
			}
		}
		return fileData;
	}

}
