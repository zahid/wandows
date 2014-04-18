package commandows;

import java.io.File;
import java.util.Scanner;

import wandows.Main;

public class Cat {
	public Cat(String[] filename) {
		try {
			String file = filename[0];
			String contents = "";
			Scanner scanner = new Scanner(new File(file));
			while(scanner.hasNext()) {
				contents += scanner.nextLine() + "\n";
			}
			Main.outln(contents);
			scanner.close();
		} catch(Exception e) {
			Main.outln(e.getMessage());
		}
	}

}
