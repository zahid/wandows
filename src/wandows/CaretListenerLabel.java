package wandows;

import javax.swing.JTextArea;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

public class CaretListenerLabel extends JTextArea implements CaretListener {
	public static int uneditableMark = 0;
	public JTextArea txtArea;
	public static boolean isRunning = false;

	public void caretUpdate(CaretEvent e) {	
		if(txtArea.getCaretPosition() < uneditableMark && !isRunning) {
			// past non-editable mark
			if(txtArea.getSelectionStart() != txtArea.getSelectionEnd()) {
				// a selection was made that goes past the mark, so fix it
				int selEnd = txtArea.getSelectionEnd();
				
				txtArea.setCaretPosition(uneditableMark);
				txtArea.select(selEnd, uneditableMark);
			} else {
				// move cursor back to lower bound
				txtArea.setCaretPosition(uneditableMark);
			}
		}
	}
}