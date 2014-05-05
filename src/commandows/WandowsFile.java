package commandows;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

import wandows.Main;

public class WandowsFile {
	private File f;
	private int size;
	private byte[] bytes;
	
	public WandowsFile(String pathname) {
		// check if directory already has path specified
		if(!(pathname.contains("\\") || pathname.contains("/")))
			pathname = Main.getCurrentWorkingDirectory() + "\\" + pathname;
		
		this.f = new File(pathname);
		
		if(this.f.exists())
			this.size = (int)this.f.length();
	}
	
	public void createIfNotExists() throws IOException {
		if(!f.exists())
			f.createNewFile();
	}
	
	public String getPath() {
		return f.getPath();
	}
	
	public void readFileToBytes() throws IOException {
		try {
			RandomAccessFile raf = new RandomAccessFile(f.getPath(), "rw");
			bytes = new byte[size];
			// set the file pointer at 0 position
			raf.seek(0);
 
			// read data into bytes array
			raf.readFully(bytes, 0, size);
			raf.close();
		} catch (IOException e) {
			Main.outln("read error: " + e);
		}
	}
	
	public void append(String text, boolean withLineBreak) {
		try {
			// append the new text to file
			String updatedText = new String(bytes) + (withLineBreak ? "\n" : "") + text;
			updatedText = updatedText.trim();
			bytes = updatedText.getBytes();

			// write to file
			FileOutputStream out = new FileOutputStream(f.getPath());
			out.write(bytes);
			
			System.out.println(f.getName() + ", " + bytes);
			out.close();
		} catch (IOException e) {
			Main.outln("error: " + e);
		}
	}
	
	public void append(byte[] b) {
		append(new String(b), false);
	}
	
	public void delete() {
		if(!f.delete())
			Main.outln("`" + f.getName() + "`: could not delete file");
	}
	
	public byte[] readBytes() throws IOException {
		readFileToBytes();
		
		return this.bytes;
	}
	
	public boolean isDirectory() {
		return f.isDirectory();
	}
	
	public boolean exists() {
		return f.exists();
	}
	
	public String getName() {
		return f.getName();
	}
	
	public String[] list() {
		return f.list();
	}
	
	public void mkdir() {
		f.mkdir();
	}
}
