package commandows;

import java.io.IOException;

import wandows.Main;

public class File {
	public File(String[] args) throws IOException {
		int index;
		try {
			index = args[0].indexOf(".");
			Main.out(args[0].substring(index + 1) + " file type");
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
}