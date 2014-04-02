package wandows;
//import java.io.*;
import java.io.IOException;
import java.util.*;
import windix.*;

class Main {
	public static void main(String[] args) throws IOException {
		System.out.println("Hello, world!");
		Scanner keyboard = new Scanner(System.in);
		
		while (true) {
			System.out.print("PROMPT\\>");
			String[] input = keyboard.nextLine().split(" ");
			String[] arguments = new String[input.length-1];
			String command = input[0];
			Token token = new Token(command);
			
			for(int i=1; i<input.length; i++)
				arguments[i-1] = input[i];
			
			switch (token.kind) {
			case Token.BIGGER:
				break;
			case Token.CAL:
				//new Cal(arguments);
				break; // This is just a hint. You need to change the class Cal
						// to displays the current month calendar.
			case Token.CAT:
				break;
			case Token.ATTRIB:
				break;
			case Token.CP:
				break;
			case Token.CUT:
				break;
			case Token.D:
				break;
			case Token.ECHO:
				break;
			case Token.EXIT:
				System.exit(0);
				break;
			case Token.FILE:
				break;
			case Token.FIND:
				break;
			case Token.GREP:
				break;
			case Token.HEAD:
				break;
			case Token.LINK:
				break;
			case Token.LS:
				break;
			case Token.DIR:
				break;
			case Token.MAN:
				break;
			case Token.MKDIR:
				break;
			case Token.MV:
				new Mv(arguments);
				break;
			case Token.PWD:
				break;
			case Token.RM:
				break;
			case Token.RMDIR:
				break;
			case Token.TAIL:
				break;
			case Token.U:
				break;
			case Token.WC:
				new Wc(arguments);
				break;
			default:
				System.out.println("`" + command + "` is not recognized as an internal or external command, operable program or batch file.");
			}
		}
	}
}
