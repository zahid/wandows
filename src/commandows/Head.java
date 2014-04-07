package commandows;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Head {
	BufferedReader in;
	private static String filename;
	

	public Head(String[] args) {
		filename = args[0];
		try {
			in = new BufferedReader(new FileReader(filename));
			String line;
			int i = 0;
		    while((line = in.readLine()) != null && i < 10){
		        System.out.println(line);
		    }
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
	
}
