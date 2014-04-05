package commandows;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Link {// link C:/Users/Josh/Desktop/thing.txt C:/Users/Josh/Desktop/stuff.txt

	public Link(String[] args) {
		String fileName = args[0];
		String destination = args[1];
		File file = new File(fileName);
		
		// if file does not exist, give it a chance with the absolute path specified (since user may specify relative path instead)
		if(!file.exists())
			file = new File(System.getProperty("user.dir") + fileName);
		
		if(file.exists()) {
			Path newLink = Paths.get(destination);
			Path existingFile = Paths.get(file.getAbsolutePath());
			
			try {
			    Files.createLink(newLink, existingFile);
			} catch (IOException e) {
			    System.out.println("link: `" + fileName + "`: " + e);
			} catch (UnsupportedOperationException e) {
			    // some file systems do not support hard links
			    System.out.println("link: this operating system does not allow hard links");
			}
		} else
			System.out.println("link: `" + fileName + "`: file not found");
	}
}
