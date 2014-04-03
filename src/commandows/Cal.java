package commandows;
import java.io.*;
import java.util.StringTokenizer;
import java.lang.reflect.*;

public class Cal {
	public Cal(String pars) {
		f(pars);
	}

	private void f(String s) {
		if (s.equals("")) {
			System.out.println("java file is missing.");
			return;
		}
		StringTokenizer tok = new StringTokenizer(s);
		String name = "MyCal";
		File f = new File("bin\\" + name + ".class");
		if (!f.exists()) {
			System.out.println(name + ".class does not exist.");
			return;
		}
		int count = tok.countTokens();
		String[] args = new String[count];
		for (int i = 0; i < count; i++)
			args[i] = tok.nextToken();
		Class c = null;
		try {
			c = Class.forName(name);
			Class[] parType = new Class[] { String[].class };
			Method m = c.getDeclaredMethod("main", parType);
			Object[] o = new Object[] { args };
			m.invoke(null, o);
		} catch (Exception e) {
			System.out.println(e);
			return;
		}
	}
}