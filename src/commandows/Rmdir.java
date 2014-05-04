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
			
			if(!directory.exists()) {
				directory = new File(dir + "\\" + fname);
				
				// if it doesn't exist, throw an error
				if(directory.exists())
					directory.delete();
				else
					Main.outln("rmdir: `" + directory.getCanonicalFile() + "`: file not found or is not a directory");
			} else
				Main.outln("rmdir: `" + directory.getCanonicalFile() + "`: file not found or is not a directory");
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

}
