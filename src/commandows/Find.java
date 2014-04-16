package commandows;
import java.io.File;

import wandows.Main;

public class Find {
	public static int matches = 0;
	
    public Find(String[] args) {
    	String searchTerm = args[0];
    	
        findRecursive("c:\\", searchTerm);
        System.out.println("Search for `" + searchTerm + "` yielded " + matches + " results.");
    }
    
    public static void findRecursive(String path, String searchTerm) {
        File root = new File(path);
        File[] list = root.listFiles();

        if (list == null) return;

        for(int i=0; i<list.length; i++) {
        	File file = list[i];
        	
            if (file.isDirectory()) {
            	findRecursive(file.getAbsolutePath(), searchTerm);
            } else {
            	if(file.getName().equals(searchTerm)) {
            		Main.outln(file.getAbsoluteFile().getName());
            		matches++;
            	}
            }
        }
    }
}
