package session4;

import static org.junit.Assert.assertEquals;

import java.awt.Image;

import org.junit.Ignore;
import org.junit.Test;

import com.squeed.kata.nametag.NameTagManager;
import com.squeed.kata.nametag.entities.Attendee;
import com.squeed.kata.nametag.entities.Event;

public class TagManagerTest {
	@Test
	public void when_event_is_empty_nothing_is_printed() throws Exception {
		Event event = new EmptyEvent();
		PrintingServiceStub printingService = new PrintingServiceStub();
		NameTagManager testeee = new NameTagManagerImpl(printingService);

		testeee.printNameTagsForEvent(event);
		
		assertEquals(0, printingService.printingCount());
	}

	@Test
	public void when_event_has_one_attendee_but_no_downloaders_available_then_print_default_image()
			throws Exception {
		PrintingServiceStub printingService = new PrintingServiceStub();
		Image defaultImage = null;
		Attendee a_person = new AttendeeFake("Will Jobe");
		Event event = new EventFake(a_person, defaultImage);
		
		NameTagManager testee = new NameTagManagerImpl(printingService);
		
		testee.printNameTagsForEvent(event);
		
		assertEquals(defaultImage, printingService.getPrintedImage(0));

	}

}