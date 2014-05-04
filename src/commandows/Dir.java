package commandows;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

import wandows.Main;

public class Dir {
	public Dir(String[] args) throws IOException {
		String directory;
		int dirCount = 0, fileCount = 0, totalBytes = 0;
		long totalFileBytes = 0, totalDirBytes = 0;
		
		if(args.length > 0)
			directory = args[0];
		else
			directory = Main.getCurrentWorkingDirectory();

		File file = new File(directory);

		if(file.exists() && file.isDirectory()) {
			// get volume info
			Main.outln("   Directory of " + file.getCanonicalPath() + "\n");
			
			File[] files = file.listFiles();
			for (File f : files) {
				// list all files in directory
				String strLine = "";
				
				// get date/time last modified
				Date d = new Date(file.lastModified());
				String timestamp = new SimpleDateFormat("MM/dd/yyyy hh:ss").format(d);
				
				strLine += timestamp;
				
				if (f.isDirectory()) {
					strLine += "\t<DIR>\t";
					totalFileBytes += f.length();
					dirCount++;
				} else {
					strLine += "\t\t";
					totalDirBytes += f.getFreeSpace();
					fileCount++;
				}
				
				strLine += f.getName() + "\n";
				Main.outln(strLine);
			}
			
			Main.outln("\t" + fileCount + " File(s)\t" + totalFileBytes + " bytes");
			Main.outln("\t" + dirCount + " Dir(s)\t" + totalDirBytes + " bytes free");
		} else {
			Main.outln("not a directory");
		}
	}
}
