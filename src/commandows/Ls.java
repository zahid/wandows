package commandows;

import java.io.File;

import wandows.Main;

public class Ls {
	public Ls(String[] args) {
		String directory;
		
		if(args.length > 0)
			directory = args[0];
		else
			directory = Main.getCurrentWorkingDirectory();

		File file = new File(directory);

		if(file.exists() && file.isDirectory()) {
			System.out.println("is directory");
		} else {
			System.out.println("not a directory");
		}
	}
}
