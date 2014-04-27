package commandows;
import wandows.*;

public class Up {
	public Up() {
		if(Main.getCommandHistory().size() >= Main.getHistoryLevel() && Main.getHistoryLevel() > 0) {
				Main.setHistoryLevel(Main.getHistoryLevel()-1);
				
		    	// prevent caret controls while the process is executing
				CaretListenerLabel.isRunning = true;
		    	
				String updatedText = Main.getTextHistory() + Main.getCommandHistory().get(Main.getHistoryLevel());
				Main.setTypingAreaText(updatedText);
				
				// prevent caret controls while the process is executing
				CaretListenerLabel.isRunning = false;
		}
	}
}
