package windix;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;


public class Mv {
	public static String fromFile;
	public static String toFile;
	public static FileLock exclusiveLock ;
	public static byte[] fileBytes;
	
	//mv C:/Users/Josh/Desktop/test.txt C:/Users/Josh/Desktop/stuffs/nonsense3.txt
	
	public Mv(String[] args) throws IOException {
		if(args.length == 2) {
			fromFile = args[0];
			toFile = args[1];
			File file = new File(fromFile);
			
			if(file.exists() && !file.isDirectory()) {
				fileBytes = new byte[(int)file.length()];
				
				// perform IO operations
				readFileToBytes();
				writeFileFromBytes();
				deleteOldFile();
			} else
				System.out.println("Error: file not accessible or is a directory");
		} else {
			System.out.println("Error: parameters incorrect");
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
			// create a new RandomAccessFile with filename test
			RandomAccessFile raf = new RandomAccessFile(toFile, "rw");
			
			// write bytes to file
			raf.write(fileBytes);
			
			// set the file pointer at 0 position
			raf.seek(0);
		} catch (IOException e) {
			System.out.println("Cannot move file: " + e);
		}
	}
	
	public static void readFileToBytes() throws IOException {
		try {
			RandomAccessFile raf = new RandomAccessFile(fromFile, "rw");
			FileChannel ch = raf.getChannel();
			
			// this locks the first half of the file - exclusive
			exclusiveLock = ch.lock(0, raf.length(), true);

			// read data into bytes array
			raf.read(fileBytes);
		} catch (IOException e) {
			System.err.println("Cannot read file: " + e);
		}
	}
}
