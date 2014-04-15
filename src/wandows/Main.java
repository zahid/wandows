package wandows;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.*;
import java.io.IOException;
import javax.swing.*;
import commandows.Attrib;
import commandows.Cal;
import commandows.Cat;
import commandows.Cp;
import commandows.Cut;
import commandows.Echo;
import commandows.File;
import commandows.Find;
import commandows.Grep;
import commandows.Head;
import commandows.Link;
import commandows.Mv;
import commandows.Pwd;
import commandows.Tail;
import commandows.Wc;
 
public class Main extends JFrame implements KeyListener, ActionListener {
    public static JTextArea typingArea;
    
    static final String newline = System.getProperty("line.separator");
    public static int uneditableMark = 10; // point at which text is uneditable
    public static String textHistory = ""; // history of text that cannot be erased next time
     
     
   public static  CaretListenerLabel caretListenerLabel =
    	    new CaretListenerLabel(); // NOTE: this is still broken...
     

 	public static void main(String[] args) throws IOException {
 		Main gui = new Main();
		caretListenerLabel.txtArea = typingArea;
		typingArea.addCaretListener(caretListenerLabel);
 	}
     
     public static void runCommand(String cmd) throws IOException {
    		prompt();
			String[] input = cmd.trim().split(" ");
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
				prompt();
				break; 
			case Token.CAT:
				new Cat(arguments);
				prompt();
				break;
			case Token.ATTRIB:
				new Attrib(arguments);
				prompt();
				break;
			case Token.CP:
				new Cp(arguments);
				prompt();
				break;
			case Token.CUT:
				new Cut(arguments);
				prompt();
				break;
			case Token.D:
				break;
			case Token.ECHO:
				new Echo(arguments);
				prompt();
				break;
			case Token.EXIT:
				System.exit(0);
				break;
			case Token.FILE:
				new File(arguments);
				prompt();
				break;
			case Token.FIND:
				new Find(arguments);
				prompt();
				break;
			case Token.GREP:
				new Grep(arguments);
				prompt();
				break;
			case Token.HEAD:
				new Head(arguments);
				prompt();
				break;
			case Token.LINK:
				new Link(arguments);
				prompt();
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
				prompt();
				break;
			case Token.PWD:
				new Pwd();
				break;
			case Token.RM:
				break;
			case Token.RMDIR:
				break;
			case Token.TAIL:
				new Tail(arguments);
				prompt();
				break;
			case Token.U:
				break;
			case Token.WC:
				new Wc(arguments);
				prompt();
				break;
			default:
				System.out.println(command);
				out("\n`" + command + "` is not recognized as an internal or external command, operable program or batch file.");
			}
			
     }
     
     public static void prompt() {
    	 out("\nPROMPT//>");
    	 
     }
     
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        
        if(typingArea.getCaretPosition() < uneditableMark+1) {
        	// cannot erase before character, disable backspace
        	typingArea.getInputMap().put(KeyStroke.getKeyStroke("BACK_SPACE"), "none");
        } else if(keyCode == 10) {
        	// enter key pressed, find and run command
        	String command = typingArea.getText().substring(uneditableMark, typingArea.getText().length());
        	
        	try {
				runCommand(command);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        } else {
        	// re-enable backspace
        	typingArea.getInputMap().put(KeyStroke.getKeyStroke("BACK_SPACE"), null);
        }
    }
    
    public static void out(String text) {
    	String updatedText = typingArea.getText() + text;
    	typingArea.setText(updatedText);
    	textHistory = updatedText;
    	uneditableMark = typingArea.getText().length();
    	CaretListenerLabel.uneditableMark = uneditableMark;
    }
    
   private void addComponentsToPane() {
       typingArea = new JTextArea();
       typingArea.addKeyListener(this);
       
       JScrollPane scrollPane = new JScrollPane(typingArea);
       scrollPane.setPreferredSize(new Dimension(375, 125));
        
       getContentPane().add(scrollPane, BorderLayout.CENTER);
       
       out("PROMPT//>");
   }
   
   public Main() {
       // create and set up the window
	   this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   this.addComponentsToPane();
	   this.pack();
	   this.setVisible(true);
   }
     
    public void keyReleased(KeyEvent e) { }
    
    public void keyTyped(KeyEvent e) { }

    public void actionPerformed(ActionEvent e) {
        typingArea.requestFocusInWindow();
    }
}
