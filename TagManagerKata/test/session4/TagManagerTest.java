package session4;

import static org.junit.Assert.*;

import java.awt.Image;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.squeed.kata.nametag.NameTagManager;
import com.squeed.kata.nametag.entities.Attendee;
import com.squeed.kata.nametag.entities.Event;
import com.squeed.kata.nametag.services.PrintingService;

@RunWith(MockitoJUnitRunner.class)
public class TagManagerTest {
	private NameTagManagerImpl testee;
	
	@Mock
	private Event event;
	@Mock
	private PrintingService printingService;
	@Mock
	private Attendee a_person;

	@Mock
	private Image defaultImage;


	@Before
	public void setup(){
		testee = new NameTagManagerImpl(printingService);
		
		Mockito.when(event.getDefaultImage()).thenReturn(defaultImage);
		
	}
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
	
	
	@Test
	public void same_As_first_test_with_mock() throws Exception {

		testee.printNameTagsForEvent(event);
		
		Mockito.verifyZeroInteractions(printingService);
	}
	
	@Test
	public void same_as_second_test_with_mock() throws Exception {
		List<Attendee> persons = Arrays.asList(a_person);
		Mockito.when(event.getExpectedAttendees()).thenReturn(persons);
		
		testee.printNameTagsForEvent(event);
		
		Mockito.verify(printingService).printNameTagFor(a_person, defaultImage);
	}
}