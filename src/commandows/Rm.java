package commandows;

import wandows.Main;

public class Rm {
	public Rm(String[] args) {
		try {
			if(args.length == 0) {
				Main.outln("rm: please specify a file");
				return;
			}
			
			WandowsFile file = new WandowsFile(args[0]);
			
			if(file.exists() && !file.isDirectory())
				file.delete();
			else
				Main.outln("rm: `" + file.getName() + "`: file not found or is a directory");
		} catch (Exception e) {
			Main.outln("rm: `" + e.getMessage());
		}
	}
}
