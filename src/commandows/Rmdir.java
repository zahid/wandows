package commandows;

import java.io.File;

public class Rmdir {
	public Rmdir(String[] args) {
		try {
			File directory = new File(args[0]);
			if (directory.isDirectory()) {
				directory.delete();
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

}
