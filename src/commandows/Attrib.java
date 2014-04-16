package commandows;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import wandows.Main;

public class Attrib {
	public static boolean[] flags = new boolean[4]; // -r=0, -a=1, -s=2, -h=3
	public static String filename;
	public static Path path;
	
	public Attrib(String[] args) throws IOException {
		for(int i=0; i<args.length; i++) {
			if(args[i].substring(0, 1).equals("-")) {
				switch(args[i].substring(1, 2)) {
				case "r":
					flags[0] = true;
					break;
				case "a":
					flags[1] = true;
					break;
				case "s":
					flags[2] = true;
					break;
				case "h":
					flags[3] = true;
					break;
				}
			} else {
				// the argument is a file name
				filename = args[i];
			}
		}
		path = Paths.get(filename);
		
		if(flags[0]) {
			this.setReadOnlyAttribute();
		} else if(flags[1]) {
			this.setArchiveAttribute();
		} else if(flags[2]) {
			this.setSystemFileAttribute();
		} else if(flags[3]) {
			this.setHiddenAttribute();
		}

	}
	public void setReadOnlyAttribute() {
		try {
			Files.setAttribute(path, "dos:readonly", true);
		} catch (IOException e) {
			Main.outln(e.getMessage());
		}
	}
	public void setArchiveAttribute() { 
		try {
			Files.setAttribute(path, "dos:archive", true);
		} catch (IOException e) {
			Main.outln(e.getMessage());
		}
	}
	public void setSystemFileAttribute() {
		try {
			Files.setAttribute(path, "dos:archive", true);
		} catch (IOException e) {
			Main.outln(e.getMessage());
		}
	}
	public void setHiddenAttribute() { 
		try {
			Files.setAttribute(path, "dos:hidden", true);
		} catch (IOException e) {
			Main.outln(e.getMessage());
		}	
	}
}