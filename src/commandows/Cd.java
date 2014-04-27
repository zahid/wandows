package commandows;

import java.io.File;
import wandows.*;

public class Cd {
	public Cd(String[] args) {
		File f = new File(args[0]);
		
		if (f.exists() && f.isDirectory()) {
			Main.setCurrentWorkingDirectory(args[0].replace("/", "\\"));
		}
	}
}
