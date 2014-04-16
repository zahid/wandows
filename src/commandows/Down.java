package commandows;

import wandows.CaretListenerLabel;
import wandows.Main;

public class Down {
	public Down() {
		if(Main.commandHistory.size() >= Main.historyLevel && Main.historyLevel < Main.commandHistory.size()) {
			Main.historyLevel++;
			
	    	// prevent caret controls while the process is executing
			CaretListenerLabel.isRunning = true;
	    	
			String updatedText = Main.textHistory+ Main.commandHistory.get(Main.historyLevel-1);
			Main.typingArea.setText(updatedText);
			
			// prevent caret controls while the process is executing
			CaretListenerLabel.isRunning = false;
		}
	}
}
