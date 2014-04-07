package wandows;
import java.io.IOException;
import java.util.*;
import commandows.*;

class Main {
	public static void main(String[] args) throws IOException {
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
				new Cal();
				break; 
			case Token.CAT:
				new Cat(arguments);
				break;
			case Token.ATTRIB:
				new Attrib(arguments);
				break;
			case Token.CP:
				new Cp(arguments);
				break;
			case Token.CUT:
				new Cut(arguments);
				break;
			case Token.D:
				break;
			case Token.ECHO:
				new Echo(arguments);
				break;
			case Token.EXIT:
				System.exit(0);
				break;
			case Token.FILE:
				new File(arguments);
				break;
			case Token.FIND:
				new Find(arguments);
				break;
			case Token.GREP:
				new Grep(arguments);
				break;
			case Token.HEAD:
				break;
			case Token.LINK:
				new Link(arguments);
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
				new Pwd();
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
