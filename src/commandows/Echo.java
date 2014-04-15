package commandows;

import wandows.Main;

public class Echo {

	public Echo(String[] args) {
		String strOutput = "";
		
		if(args.length > 0)
			for(int i=0; i<args.length; i++)
				strOutput += args[i].trim() + " ";
		Main.outln(strOutput.trim());
	}
	
}
