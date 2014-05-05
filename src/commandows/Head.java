package commandows;

import java.io.BufferedReader;
import java.io.FileReader;

import wandows.Main;

public class Head {
	BufferedReader in;
	
	public Head(String[] args) {
		String filename;
		BufferedReader in;
		WandowsFile file = new WandowsFile(args[0]);
		
		if(file.exists() && !file.isDirectory()) {
			try {
				filename = file.getPath();
				in = new BufferedReader(new FileReader(filename));
				String line;
				int i = 0;
			    while((line = in.readLine()) != null && i < 10){
			    	Main.outln(line);
			    }
			} catch (Exception e) {
				Main.outln(e.getMessage());
			}
		} else {
			Main.outln("tail: `" + file.getName() + "`: file not found or is a directory");
		}
	}
	
}
