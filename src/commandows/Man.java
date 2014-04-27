package commandows;

import wandows.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Man {
	public Man(String cmd) throws FileNotFoundException {
		cmd = Character.toUpperCase(cmd.charAt(0)) + cmd.substring(1).toLowerCase();
		File cmdHelp = new File(System.getProperty("user.dir") + "/Manual/" + cmd + ".txt");
			
		if(cmdHelp.exists()) {
			Main.setManualMode(true);
			
			Scanner sc = new Scanner(cmdHelp);
			String str = "";
			
			while(sc.hasNextLine())
				str += sc.nextLine() + "\n";
			
			str += "\nPress any key to quit";
			
			Main.setTypingAreaText(str);
		} else {
			Main.outln("No help available for `" + cmd + "`");
		}
	}
}
