package commandows;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import wandows.Main;

public class Link {// link C:/Users/Josh/Desktop/thing.txt C:/Users/Josh/Desktop/stuff.txt

	public Link(String[] args) {
		String fileName = args[0];
		String destination = args[1];
		File file = new File(fileName);
		
		// if file does not exist, give it a chance with the absolute path specified (since user may specify relative path instead)
		if(!file.exists())
			file = new File(Main.currentWorkingDirectory + fileName);
		
		if(file.exists()) {
			Path newLink = Paths.get(destination);
			Path existingFile = Paths.get(file.getAbsolutePath());
			
			try {
			    Files.createLink(newLink, existingFile);
			} catch (IOException e) {
				Main.outln("link: `" + fileName + "`: " + e);
			} catch (UnsupportedOperationException e) {
			    // some file systems do not support hard links
			    Main.outln("link: this operating system does not allow hard links");
			}
		} else
			Main.outln("link: `" + fileName + "`: file not found");
	}
}
