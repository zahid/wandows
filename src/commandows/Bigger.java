package commandows;
import java.io.IOException;
import java.nio.channels.FileLock;

import wandows.Main;

public class Bigger {
	public static String cmd, fileName;
	public static FileLock exclusiveLock;
	public static WandowsFile file;
	
	public Bigger(String command) throws IOException {
		// interpret the command and the file to write to
		cmd = command.substring(0, command.indexOf('>')).trim();
		fileName = command.substring(command.indexOf('>')+1, command.length()).trim();
		file = new WandowsFile(fileName);

		// ensure file exists
		file.createIfNotExists();
		file.readFileToBytes();
		fileName = file.getPath();
		System.out.println("File" + fileName);
		
		// tell Main to print to file instead of to console
		Main.setPrintToFile(true);
	}
	
	public String getCommand() {
		return cmd;
	}
	
	public void append(String text, boolean withLineBreak) {
		if(file != null)
			file.append(text, withLineBreak);
	}
}
