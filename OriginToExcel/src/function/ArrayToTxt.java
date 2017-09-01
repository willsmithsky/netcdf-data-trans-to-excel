package function;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

public class ArrayToTxt {
	String pathname;
	ArrayList<Double> data;
	
	public ArrayToTxt(ArrayList<Double> data, String pathname) {
		this.data = data;
		this.pathname = pathname;
	}
	
	public void toTxt() throws Exception {
		PrintStream printStream = new PrintStream(new FileOutputStream(new File(pathname)));
		for (double d : data)
		    printStream.println(d);
	}

}
