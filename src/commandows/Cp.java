package commandows;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Cp {
	public Cp(String[] args) {	
	 
    	InputStream inStream = null;
		OutputStream outStream = null;
	 
    	try{
 
    	    File afile = new File(args[0]);
    	    File bfile = new File(args[1]);
 
    	    inStream = new FileInputStream(afile);
    	    outStream = new FileOutputStream(bfile);
 
    	    byte[] buffer = new byte[1024];
 
    	    int length;
    	    while ((length = inStream.read(buffer)) > 0){
    	    	outStream.write(buffer, 0, length);
    	    }
    	    inStream.close();
    	    outStream.close();
    	    System.out.println("File is copied successful!");
    	} catch(IOException e){
    		e.printStackTrace();
    	}
	}
}