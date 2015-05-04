package session4;

import com.squeed.kata.nametag.NameTagManager;
import com.squeed.kata.nametag.entities.Event;
import com.squeed.kata.nametag.services.PrintingService;

public class NameTagManagerImpl implements NameTagManager {

	private PrintingService printingService;
	
	public NameTagManagerImpl(PrintingService printingService) {
		this.printingService = printingService;
	}

	@Override
	public void printNameTagsForEvent(Event event) {
		//printingService.printNameTagFor(null, null);
	}

}
