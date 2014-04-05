package commandows;

public class Grep {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] searchTerm = "hello".toCharArray();
		char[] file = "stuff hello world hello stuff hello".toCharArray();
		int pointer = 0;
		
		for(int i=0; i<file.length; i++) {
			if(file[i] == searchTerm[pointer]) {
				if(pointer+1 >= searchTerm.length) {
					System.out.println("match!");
					// TBD: print out line instead of match!
					pointer = 0;
				}
				pointer++;
			} else {
				pointer = 0;
			}
		}
	}

	
	
}
