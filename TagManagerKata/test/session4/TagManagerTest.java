package session4;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;

import com.squeed.kata.nametag.NameTagManager;
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
	@Ignore
	public void when_event_has_one_attendee_but_no_downloaders_available_then_print_default_image()
			throws Exception {

	}

}