package commandows;

public class Echo {

	public Echo(String[] args) {
		try {
			System.out.println(args[0]);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
	
}
