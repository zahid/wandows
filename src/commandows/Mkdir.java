package commandows;

import wandows.Main;

public class Mkdir {
	public Mkdir(String[] args) {
		try {
			if(args.length == 0) {
				Main.outln("mkdir: please specify a directory name");
				return;
			}
			
			WandowsFile directory = new WandowsFile(args[0]);
			
			if(directory.exists())
				Main.outln("mkdir: `" + directory.getPath() + "`: directory already exists");
			else
				directory.mkdir();
		} catch (Exception e) {
			Main.outln("mkdir: `" + e.getMessage());
		}
	}

}
