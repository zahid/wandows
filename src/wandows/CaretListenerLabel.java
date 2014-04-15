package wandows;

import javax.swing.JTextArea;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

class CaretListenerLabel extends JTextArea implements CaretListener {
	public static int uneditableMark = 0;
	public JTextArea txtArea;

	public void caretUpdate(CaretEvent e) {
		System.out.println(e.getMark());
		
		System.out.println("SelStart: " + txtArea.getSelectionStart() + ", SelEnd: " + txtArea.getSelectionEnd() + ", Caret: " + txtArea.getCaretPosition());
		
		if(txtArea.getCaretPosition() < uneditableMark) {
			System.out.println("past mark");
			
			if(txtArea.getSelectionStart()  != txtArea.getSelectionEnd()) {
				System.out.println("selection made");
				// a selection was made, so fix it
				int selEnd = txtArea.getSelectionEnd();
				
				txtArea.setCaretPosition(uneditableMark);
				txtArea.select(selEnd, uneditableMark);
			} else {
				txtArea.setCaretPosition(uneditableMark);
			}
		}
	}
}