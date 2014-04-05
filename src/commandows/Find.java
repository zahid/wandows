package commandows;
import java.io.File;
import java.util.Scanner;

public class Find {
    public static void main(String[] args) {
    	Scanner keyboard = new Scanner(System.in);
    	String searchTerm = keyboard.nextLine();
    	
        walk("c:\\", searchTerm);
    }
    
    public static void walk(String path, String searchTerm) {
        File root = new File(path);
        File[] list = root.listFiles();

        if (list == null) return;

        for(int i=0; i<list.length; i++) {
        	File file = list[i];
        	
            if (file.isDirectory()) {
                walk(file.getAbsolutePath(), searchTerm);
            } else {
            	if(file.getName().equals(searchTerm))
            		System.out.println("Match: " + file.getAbsoluteFile());
            }
        }
    }
}
