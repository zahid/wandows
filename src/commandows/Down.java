package commandows;

import wandows.CaretListenerLabel;
import wandows.Main;

public class Down {
	public Down() {
		if(Main.getCommandHistory().size() >= Main.getHistoryLevel() && Main.getHistoryLevel() < Main.getCommandHistory().size()) {
			Main.setHistoryLevel(Main.getHistoryLevel()+1);
			
	    	// prevent caret controls while the process is executing
			CaretListenerLabel.isRunning = true;
	    	
			String updatedText = Main.getTextHistory() + Main.getCommandHistory().get(Main.getHistoryLevel()-1);
			Main.setTypingAreaText(updatedText);
			
			// prevent caret controls while the process is executing
			CaretListenerLabel.isRunning = false;
		}
	}
}
