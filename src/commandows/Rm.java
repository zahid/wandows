package commandows;

import java.io.File;

import wandows.Main;

public class Rm {
	public Rm(String[] args) {
		try {
			if(args.length == 0) {
				Main.outln("rm: please specify a file");
				return;
			}
			
			File file = new File(args[0]);
			String dir = file.getPath();
			String fname = file.getName();
			
			if(!dir.equals(Main.getCurrentWorkingDirectory()))
				dir = Main.getCurrentWorkingDirectory();
			
			if(!file.exists() && !file.isDirectory()) {
				file = new File(dir + "\\" + fname);
				
				// if it doesn't exist, throw an error
				if(file.exists() && !file.isDirectory())
					file.delete();
				else
					Main.outln("rmdir: `" + file.getCanonicalFile() + "`: file not found or is a directory");
			} else
				Main.outln("rmdir: `" + file.getCanonicalFile() + "`: file not found or is a directory");
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
}
