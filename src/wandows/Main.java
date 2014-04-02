package wandows;
//import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		while (true) {
			System.out.print("PROMPT\\>");
			String command = keyboard.next();
			String arguments = keyboard.nextLine();
			Token token = new Token(command);
			switch (token.kind) {
			case Token.BIGGER:
				break;
			case Token.CAL:
				new Cal(arguments);
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
				break;
			default:
				System.out.println("Wrong command.");
			}
		}
	}
}
