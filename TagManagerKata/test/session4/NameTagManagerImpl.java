package session4;

import java.awt.Image;

import com.squeed.kata.nametag.NameTagManager;
import com.squeed.kata.nametag.entities.Attendee;
import com.squeed.kata.nametag.entities.Event;
import com.squeed.kata.nametag.services.PrintingService;

public class NameTagManagerImpl implements NameTagManager {

	private PrintingService printingService;
	
	public NameTagManagerImpl(PrintingService printingService) {
		this.printingService = printingService;
	}

	@Override
	public void printNameTagsForEvent(Event event) {
		for(Attendee a : event.getExpectedAttendees()){
			Image image = event.getDefaultImage();
			printingService.printNameTagFor(a, image);
		}
	}

}
