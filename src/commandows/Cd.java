package commandows;

import java.io.File;
import java.io.IOException;

import wandows.*;

public class Cd {
	public Cd(String[] args) throws IOException {
		File f = new File(args[0]);
		
		if (f.exists() && f.isDirectory()) {
			Main.setCurrentWorkingDirectory(args[0].replace("/", "\\"));
		}
	}
}
