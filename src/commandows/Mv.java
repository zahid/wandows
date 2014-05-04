package commandows;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;

import wandows.Main;


public class Mv {
	public static String fromFile;
	public static String toFile;
	public static FileLock exclusiveLock;
	public static byte[] fileBytes;
	public static int fileSize;
	
	//mv C:/Users/Josh/Desktop/test.txt C:/Users/Josh/Desktop/nonsense3.txt
	
	public Mv(String[] args) throws IOException {
		if(args.length == 2) {
			fromFile = args[0];
			toFile = args[1];
			
			// if file does not exist, give it a chance with the absolute path specified (since user may specify relative path instead
			File file = new File(fromFile);
			String dir = file.getPath();
			String fname = file.getName();
			
			if(!dir.equals(Main.getCurrentWorkingDirectory()))
				dir = Main.getCurrentWorkingDirectory();
			
			if(!file.exists())
				file = new File(dir + fname);
				
			if(file.exists() && !file.isDirectory()) {
				fromFile = file.getAbsolutePath();
				
				// find file size
				fileSize = (int) file.length();
				fileBytes = new byte[fileSize];
				
				// perform IO operations
				readFileToBytes();
				writeFileFromBytes();
				deleteOldFile();
			} else
				Main.outln("mv: " + fromFile + ": file not accessible or is a directory");
		} else {
			Main.outln("mv: incorrect parameters specified");
		}
	}
	
	public static void deleteOldFile() throws IOException {
		// delete the old file from the system
		File file = new File(fromFile);
		
		// if file does not exist, give it a chance with the absolute path specified (since user may specify relative path instead)
		if(!file.exists())
			file = new File(Main.getCurrentWorkingDirectory() + fromFile);
		
		if(!file.delete())
			Main.outln("mv: `" + file.getAbsolutePath() + "`: could not delete file");
	}
	
	public static void writeFileFromBytes() {
		try {
			// create file if not exists
			File newFile = createIfNotExists(toFile);

			// write to file
			FileOutputStream out = new FileOutputStream(newFile);
			
			out.write(fileBytes);
			System.out.println(new String(fileBytes));
			out.close();
		} catch (IOException e) {
			Main.outln("mv: `" + toFile + "`: " + e);
		}
	}
	
	public static File createIfNotExists(String newFileName) throws IOException {
		File file = new File(newFileName);
		String dir = file.getPath();
		String fname = file.getName();
		
		if(!dir.equals(Main.getCurrentWorkingDirectory()))
			dir = Main.getCurrentWorkingDirectory();
		
		if(!file.exists()) {
			file = new File(dir + fname);
			
			// if it doesn't exist, create a new one.
			if(!file.exists())
				file.createNewFile();
		}
		
		return file;
	}
	
	public static void readFileToBytes() throws IOException {
		try {
			RandomAccessFile raf = new RandomAccessFile(fromFile, "rw");

			// set the file pointer at 0 position
			raf.seek(0);
 
			// read data into bytes array
			raf.readFully(fileBytes, 0, fileSize);
			raf.close();
		} catch (IOException e) {
			Main.outln("mv: `" + fromFile + "`: " + e);
		}
	}
}
