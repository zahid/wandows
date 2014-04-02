package wandows;
public class Token {
	public int kind;

	public Token(String spelling) {
		kind = -1;
		for (int k = BIGGER; k <= WC; k++)
			if (spelling.equals(spellings[k])) {
				this.kind = (byte) k;
				break;
			}
	}

	public final static byte BIGGER = 0, // >
			CAL = 1, // cal
			CAT = 2, // cat
			ATTRIB = 3, // attrib
			CP = 4, // cp
			CUT = 5, // cut
			D = 6, // d
			ECHO = 7, // echo
			EXIT = 8, // exit
			FILE = 9, // file
			FIND = 10, // find
			GREP = 11, // grep
			HEAD = 12, // head
			LINK = 13, // link
			LS = 14, // ls
			DIR = 15, // dir
			MAN = 16, // man
			MKDIR = 17, // mkdir
			MV = 18, // mv
			PWD = 19, // pwd
			RM = 20, // rm
			RMDIR = 21, // rmdir
			TAIL = 22, // tail
			U = 23, // u
			WC = 24; // wc

	private final static String[] spellings = { ">", "cal", "cat", "attrib",
			"cp", "cut", "d", "echo", "exit", "file", "find", "grep", "head",
			"link", "ls", "dir", "man", "mkdir", "mv", "pwd", "rm", "rmdir",
			"tail", "u", "wc" };
}
