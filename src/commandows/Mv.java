package commandows;
import java.io.IOException;

import wandows.Main;


public class Mv {
	public Mv(String[] args) throws IOException {
		if(args.length == 2) {
			// if file does not exist, give it a chance with the absolute path specified (since user may specify relative path instead
			WandowsFile source = new WandowsFile(args[0]);
			WandowsFile destination = new WandowsFile(args[1]);
			
			if(source.exists() && !source.isDirectory()) {
				destination.createIfNotExists();
				destination.readFileToBytes();
				destination.append(source.readBytes());
			} else
				Main.outln("mv: " + source.getName() + ": file not accessible or is a directory");
		} else {
			Main.outln("mv: incorrect parameters specified");
		}
	}
}
