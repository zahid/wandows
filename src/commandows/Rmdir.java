package commandows;

import wandows.Main;

public class Rmdir {
	public Rmdir(String[] args) {
		try {
			if(args.length == 0) {
				Main.outln("rmdir: please specify a directory");
				return;
			}
			
			WandowsFile directory = new WandowsFile(args[0]);
			
			if(directory.exists() && directory.isDirectory()) {
				// if it doesn't exist or is not empty, throw an error
				if(directory.list().length > 0)
					Main.outln("rmdir: `" + directory.getPath() + "`: directory not empty");
				else
					directory.delete();
			} else
				Main.outln("rmdir: `" + directory.getPath() + "`: file not found or is not a directory");
		} catch (Exception e) {
			Main.outln("rmdir: `" + e.getMessage());
		}
	}
}
