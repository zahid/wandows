package commandows;

import java.io.File;

public class Mkdir {
	public Mkdir(String[] args) {
		try {
			File file = new File(args[0]);
			if (!file.exists()) {
				file.mkdir();
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

}
