package commandows;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Path;
import java.nio.file.Paths;

import wandows.Main;

public class Cut {
	public static String filename;
	public static Path path;
	public static int start, end;
	public static BufferedReader in;
	
	public Cut(String[] args) {
		String range = null;
		int dashIndex = 0;
		for(int i=0; i<args.length; i++) {
			if(args[i].substring(0, 1).equals("-")) {
				switch(args[i].substring(1, 2)) {
				case "c":
					range = args[i+1];
					dashIndex = range.indexOf("-");
					break;
				}
			} else {
				// the argument is a file name
				filename = args[i];
			}
		}
		path = Paths.get(filename);
		try {
			start = Integer.parseInt(range.substring(0, dashIndex));
			end = Integer.parseInt(range.substring(dashIndex+1));
			System.out.println(start + " " + end);
		    in = new BufferedReader(new FileReader(filename));
		    String line = "" ;
		    while((line = in.readLine()) != null){
		    	Main.outln(line.substring(start, end));
		    }
		} catch (Exception e) {
			Main.outln(e.getMessage());
		}
	}
}
