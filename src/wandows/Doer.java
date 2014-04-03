package wandows;

import java.io.File;
import java.lang.reflect.Method;
import java.util.StringTokenizer;

//import commandows.*;

public class Doer {
	public static void doThis(String command) {
		if (command.equals("")) {
			System.out.println("source file is missing.");
			return;
		}
		StringTokenizer token = new StringTokenizer(command);
		String name = token.nextToken();
		String capital = String.valueOf(name.charAt(0)).toUpperCase();
		name = capital + name.substring(1);
		
		File file = new File("bin/commandows/" + name + ".class");
		name = "commandows." + name;		
		
		if (!file.exists()) {
			System.out.println(name + ".class does not exist. " + file.getAbsolutePath());
			return;
		}
		int count = token.countTokens();
		String[] args = new String[count];
		for (int i = 0; i < count; i++)
			args[i] = token.nextToken();
		Class c = null;
		try {
			c = Class.forName(name);
			Class[] parType = new Class[] { String[].class };
			Method m = c.getDeclaredMethod("main", parType);
			Object[] o = new Object[] { args };
			m.invoke(null, o);
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
			return;
		}
	}
}
