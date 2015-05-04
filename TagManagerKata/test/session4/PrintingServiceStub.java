package session4;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import com.squeed.kata.nametag.entities.Attendee;
import com.squeed.kata.nametag.services.PrintingService;

public class PrintingServiceStub implements PrintingService {

	private int count;
	private List<Image> imagesPrinted = new ArrayList<>();
	
	public void printNameTagFor(Attendee attendee, Image image){
		imagesPrinted.add(image);
		count++;
	}
	
	public int printingCount() {
		return count;
	}

	public Image getPrintedImage(int i) {
		return imagesPrinted.get(i);
	}

}
