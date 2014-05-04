package commandows;

import java.io.File;

public class Rm {
	public Rm(String[] args) {
		try {
			File file = new File(args[0]);
			if (file.exists()) {
				file.delete();
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

}
