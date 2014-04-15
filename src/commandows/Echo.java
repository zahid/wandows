package commandows;

public class Echo {

	public Echo(String[] args) {
		String strOutput = "";
		
		if(args.length > 0)
			for(int i=0; i<args.length; i++)
				strOutput += args[i].trim() + " ";
		
		System.out.println(strOutput.trim());
	}
	
}
