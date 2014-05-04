package commandows;

import java.io.File;

import wandows.Main;

public class Mkdir {
	public Mkdir(String[] args) {
		try {
			if(args.length == 0) {
				Main.outln("mkdir: please specify a directory name");
				return;
			}
			
			File directory = new File(Main.getCurrentWorkingDirectory() + "\\" + args[0]);
			
			if(directory.exists())
				Main.outln("mkdir: `" + directory.getCanonicalFile() + "`: directory already exists");
			else
				directory.mkdir();
		} catch (Exception e) {
			Main.outln("mkdir: `" + e.getMessage());
		}
	}

}
