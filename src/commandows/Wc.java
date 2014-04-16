package commandows;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import wandows.Main;

public class Wc {
	public static String[] files = new String[1];
	public static boolean[] flags = new boolean[3]; // -l=0, -m=1, -w=2
	public static int[] sizes = new int[3]; // -l=0, -m=1, -w=2
	
	//wc -l -m -w C:/Users/Josh/Desktop/test.txt C:/Users/Josh/Desktop/test.txt C:/Users/Josh/Desktop/tes3t.txt
	
	public Wc(String[] args) throws IOException {
		for(int i=0; i<args.length; i++) {
			if(args[i].substring(0, 1).equals("-")) {
				// the arg starts with "-" and is therefore a command. which command(s) is the user requesting?
				
				switch(args[i].substring(1, 2)) {
				case "l":
					flags[0] = true;
					break;
				case "m":
					flags[1] = true;
					break;
				case "w":
					flags[2] = true;
					break;
				}
			} else {
				// the argument is a file name
				String[] temp = new String[files.length+1];
			    System.arraycopy(files, 0, temp, 0, files.length);
			    temp[files.length] = args[i];
			    files = temp;
			}
		}
		
		// print counts for each file
		for(int i=0; i<files.length; i++) {
			if(files[i] != null) {
				// clear sizes first
				sizes[0] = 0;
				sizes[1] = 0;
				sizes[2] = 0;
				
				readFile(files[i]);
			}
		}
		// print totals
		Main.outln("\t" + sizes[0] + "\t" + sizes[1] + "\t" + sizes[2] + "\ttotal");
	}
	
	public static void readFile(String fileName) throws IOException {
		File file = new File(fileName);
		
		// if file does not exist, give it a chance with the absolute path specified (since user may specify relative path instead)
		if(!file.exists())
			file = new File(System.getProperty("user.dir") + fileName);
		
		if(file.exists() && !file.isDirectory()) {
			try {
				byte[] fileBytes = new byte[(int)file.length()];
				RandomAccessFile raf = new RandomAccessFile(fileName, "r");
	
				// read data into bytes array and then convert to String
				raf.read(fileBytes);
				String fileContents = new String(fileBytes);
				int c1 = 0, c2 = 0, c3 = 0;
				
				// get delimiter count for each flag
				if(flags[0]) {
					c1 = delimiterCount(fileContents, "\n");
					sizes[0] += c1;
				}
				if(flags[1]) {
					c2 = delimiterCount(fileContents, "");
					sizes[1] += c2;
				}
				if(flags[2]) {
					c3 = delimiterCount(fileContents, " ");
					c3 += delimiterCount(fileContents, "\n");
					sizes[2] += c3;
				}
				
				Main.out("\n" + "\t" + c1 + "\t" + c2 + "\t" + c3 + "\t" + fileName);
			} catch (IOException e) {
				System.err.println("Cannot read file: " + e);
			}
		} else {
			Main.outln("wc: `" + fileName + "`: no such file or directory.");
		}
	}
	
	public static int delimiterCount(String fileContents, String delimiter) {
		String[] p = fileContents.split(delimiter);
		int count = 0;
		
		for(int i=0; i<p.length; i++) {
			if(p[i].replace("\n", "").replace("\t", "").replace(" ", "").length() > 0)
				count++;
		}

		return count;
	}
}
