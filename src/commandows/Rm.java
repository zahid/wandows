package commandows;

import java.io.File;

public class Rm {
	public Rm(String[] args) {
		try {
			File file = new File(args[0]);
			if (file.exists()) {
				System.out.println("file exists " + file.getAbsolutePath());
				file.delete();
			} else {
				System.out.println("file does not exist " + file.getAbsolutePath());
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

}
