package commandows;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Grep {
	public static char[] match;
	public static String fileData;
	
	public Grep(String[] args) throws IOException { //grep hello C:/Users/Josh/Desktop/test.txt
		File file = new File(args[1]);
		match = args[0].toCharArray();
		
		// if file does not exist, give it a chance with the absolute path specified (since user may specify relative path instead)
		if(!file.exists())
			file = new File(System.getProperty("user.dir") + args[1]);
		
		if(file.exists()) {
			// search file
			String lines[] = readFileToString(args[1]).split("\n");
			
			for(int i=0; i<lines.length; i++) {
				if(searchLine(lines[i]))
					System.out.println(lines[i]);
			}
		} else {
			System.out.println("grep: " + args[1] + ": file not accessible or is a directory");
		}
	}
	
	public static boolean searchLine(String lineString) {
		char[] line = lineString.toCharArray();
		int pointer = 0;
		
		for(int i=0; i<line.length; i++) {
			if(line[i] == match[pointer]) {
				if(pointer+1 >= match.length)
					return true;
				else
					pointer++;
			} else
				pointer = 0;
		}
		
		return false;
	}
	
	public static String readFileToString(String fileName) throws IOException {
		try {
			RandomAccessFile raf = new RandomAccessFile(fileName, "rw");
			File file = new File(fileName);
			byte[] fileBytes = new byte[(int)file.length()];
			
			// read data into bytes array
			raf.read(fileBytes);
			
			// read data into string
			return new String(fileBytes);
		} catch (IOException e) {
			System.err.println("grep: " + e);
			return "";
		}
	}
}
