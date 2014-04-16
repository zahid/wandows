package commandows;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

import wandows.Main;


public class Mv {
	public static String fromFile;
	public static String toFile;
	public static FileLock exclusiveLock;
	public static byte[] fileBytes;
	
	//mv C:/Users/Josh/Desktop/test.txt C:/Users/Josh/Desktop/stuffs/nonsense3.txt
	
	public Mv(String[] args) throws IOException {
		if(args.length == 2) {
			fromFile = args[0];
			toFile = args[1];
			File file = new File(fromFile);
			
			// if file does not exist, give it a chance with the absolute path specified (since user may specify relative path instead)
			if(!file.exists())
				file = new File(System.getProperty("user.dir") + fromFile);
			
			if(file.exists() && !file.isDirectory()) {
				fileBytes = new byte[(int)file.length()];
				
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
		// release the lock
		if (exclusiveLock != null)
			exclusiveLock.release();
		
		// delete the old file from the system
		File file = new File(fromFile);
		file.delete();
	}
	
	public static void writeFileFromBytes() {
		try {
			// create file if not exists
			File newFile = new File(toFile);
			if(!newFile.exists()) {
				newFile.createNewFile();
			}

			// write to file
			FileOutputStream out = new FileOutputStream(newFile);
			
			out.write(fileBytes);
			out.close();
		} catch (IOException e) {
			Main.outln("mv: `" + toFile + "`: " + e);
		}
	}
	
	public static void readFileToBytes() throws IOException {
		try {
			@SuppressWarnings("resource")
			RandomAccessFile raf = new RandomAccessFile(fromFile, "rw");
			FileChannel ch = raf.getChannel();
			
			// this locks the first half of the file - exclusive
			exclusiveLock = ch.lock(0, raf.length(), true);

			// read data into bytes array
			raf.read(fileBytes);
		} catch (IOException e) {
			Main.outln("mv: `" + fromFile + "`: " + e);
		}
	}
}
