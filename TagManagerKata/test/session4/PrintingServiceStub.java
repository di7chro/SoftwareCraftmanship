package session4;

import java.awt.Image;

import com.squeed.kata.nametag.entities.Attendee;
import com.squeed.kata.nametag.services.PrintingService;

public class PrintingServiceStub implements PrintingService {

	private int count;
	
	public void printNameTagFor(Attendee attendee, Image image){
		count++;
	}
	
	public int printingCount() {
		return count;
	}

}
