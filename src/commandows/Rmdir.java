package commandows;

import java.io.File;

import wandows.Main;

public class Rmdir {
	public Rmdir(String[] args) {
		try {
			if(args.length == 0) {
				Main.outln("rmdir: please specify a directory");
				return;
			}
			
			File directory = new File(args[0]);
			String dir = directory.getPath();
			String fname = directory.getName();
			
			if(!dir.equals(Main.getCurrentWorkingDirectory()))
				dir = Main.getCurrentWorkingDirectory();
			directory = new File(dir + "\\" + fname);
			
			if(directory.exists() && directory.isDirectory()) {
				// if it doesn't exist or is not empty, throw an error
				if(directory.list().length > 0)
					Main.outln("rmdir: `" + directory.getCanonicalFile() + "`: directory not empty");
				else
					directory.delete();
			} else
				Main.outln("rmdir: `" + directory.getCanonicalFile() + "`: file not found or is not a directory");
		} catch (Exception e) {
			Main.outln("rmdir: `" + e.getMessage());
		}
	}
}
