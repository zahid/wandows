package commandows;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Cat {
	public Cat(String[] filename) {
		try {
			String file = filename[0];
			String contents = "";
			Scanner scanner = new Scanner(new File(file));
			while(scanner.hasNext()) {
				contents += scanner.nextLine();
			}
			System.out.println(contents);
		} catch(Exception e) {
			System.err.print(e.getMessage());
		}
	}

}
