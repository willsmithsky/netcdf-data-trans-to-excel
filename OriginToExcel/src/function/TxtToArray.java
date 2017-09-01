package function;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class TxtToArray {
	String dataPath;
	File file;
    ArrayList<Double> arrayList;
	
	public TxtToArray(String path) {
		this.dataPath = path;
		this.file = new File(this.dataPath);
		arrayList = new ArrayList<>();
	}
	
	public TxtToArray(File file) {
		this.file = file;
		this.dataPath = this.file.getAbsolutePath();
		arrayList = new ArrayList<>();
	}
	
	public ArrayList<Double> toArrayList() throws FileNotFoundException {
		InputStream inputStream = new FileInputStream(file);
		Scanner scan = new Scanner(inputStream);
		while (scan.hasNextDouble())
			arrayList.add(scan.nextDouble());
		return arrayList;		
	}

}
