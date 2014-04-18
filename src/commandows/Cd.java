package commandows;

import java.io.File;
import wandows.Main;

public class Cd {
	public Cd(String[] args) {
		File f = new File(args[0]);
		
		if (f.exists() && f.isDirectory()) {
			Main.currentWorkingDirectory = args[0];
		}
	}
}
