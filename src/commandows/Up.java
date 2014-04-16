package commandows;
import wandows.*;

public class Up {
	public Up() {
		if(Main.commandHistory.size() >= Main.historyLevel && Main.historyLevel > 0) {
				Main.historyLevel--;
				
		    	// prevent caret controls while the process is executing
				CaretListenerLabel.isRunning = true;
		    	
				String updatedText = Main.textHistory+ Main.commandHistory.get(Main.historyLevel);
				Main.typingArea.setText(updatedText);
				
				// prevent caret controls while the process is executing
				CaretListenerLabel.isRunning = false;
		}
	}
}
