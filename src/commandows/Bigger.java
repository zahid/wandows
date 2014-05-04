package commandows;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;

import wandows.Main;

public class Bigger {
	public static String cmd, fileName;
	public static FileLock exclusiveLock;
	public static byte[] fileBytes;
	public static int fileSize;
	
	public Bigger(String command) throws IOException {
		// interpret the command and the file to write to
		cmd = command.substring(0, command.indexOf('>')).trim();
		fileName = command.substring(command.indexOf('>')+1, command.length()).trim();

		// ensure file exists
		createIfNotExists();

		// get file byte array
		readFileToBytes();
		
		// tell Main to print to file instead of to console
		Main.setPrintToFile(true);
	}
	
	public void appendToFile(String text, boolean withLineBreak) {
		try {
			// append the new text to file
			String updatedText = new String(fileBytes) + (withLineBreak ? "\n" : "") + text;
			updatedText = updatedText.trim();
			fileBytes = updatedText.getBytes();

			// write to file
			FileOutputStream out = new FileOutputStream(fileName);
			
			out.write(fileBytes);
			
			System.out.println(fileName + ", " + fileBytes);
			out.close();
		} catch (IOException e) {
			Main.outln("mv: `" + fileName + "`: " + e);
		}
	}
	
	public static void readFileToBytes() throws IOException {
		try {
			RandomAccessFile raf = new RandomAccessFile(fileName, "rw");

			// set the file pointer at 0 position
			raf.seek(0);
 
			// read data into bytes array
			raf.readFully(fileBytes, 0, fileSize);
			raf.close();
		} catch (IOException e) {
			Main.outln("mv: `" + fileName + "`: " + e);
		}
	}
	
	public static void createIfNotExists() throws IOException {
		File file = new File(fileName);
		String dir = file.getPath();
		String fname = file.getName();
		
		if(!dir.equals(Main.getCurrentWorkingDirectory()))
			dir = Main.getCurrentWorkingDirectory();
		
		if(!file.exists()) {
			file = new File(dir + fname);
			
			// if it doesn't exist, create a new one.
			if(!file.exists())
				file.createNewFile();
			
			fileName = file.getAbsolutePath();
			
			// find file size
			fileSize = (int) file.length();
			fileBytes = new byte[fileSize];
		}
	}
	
	public String getCommand() {
		return cmd;
	}
}
