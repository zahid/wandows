package commandows;

import java.io.BufferedReader;
import java.io.FileReader;

import wandows.Main;

public class Tail {

	public Tail(String[] args) {
		String filename;
		BufferedReader in;
		WandowsFile file = new WandowsFile(args[0]);
		
		if(file.exists() && !file.isDirectory()) {
			try {
				filename = file.getPath();
				in = new BufferedReader(new FileReader(filename));
				String line;
				int i = 0;
				String content = null;
			    while((line = in.readLine()) != null && i < 10){
			        content += line + "\n";
			    }
			    String[] lines = content.split("\n");
			    if(lines.length < 10) {
			    	i = 0;
			    } else {
			    	i = lines.length - 10;
			    }
			    while(i < lines.length) {
			    	Main.outln(lines[i]);
			    	i++;
			    }
			} catch (Exception e) {
				Main.outln(e.getMessage());
			}
		} else {
			Main.outln("tail: `" + file.getName() + "`: file not found or is a directory");
		}
	}
	
}
