package commandows;

import java.io.BufferedReader;
import java.io.FileReader;

import wandows.Main;

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
		    	Main.outln(line);
		    }
		} catch (Exception e) {
			Main.outln(e.getMessage());
		}
	}
	
}
