package commandows;

import wandows.Main;

public class Pwd {
	public Pwd() {
		Main.outln(System.getProperty("user.dir"));
	}
}
