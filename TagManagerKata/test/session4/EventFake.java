package session4;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import com.squeed.kata.nametag.entities.Attendee;
import com.squeed.kata.nametag.entities.Event;

public class EventFake implements Event {

	private List<Attendee> a_persons = new ArrayList<>();
	private Image defaultImage;
	public EventFake(Attendee a_person, Image defaultImage) {
		this.a_persons.add(a_person);
		this.defaultImage = defaultImage;
	}

	@Override
	public List<Attendee> getExpectedAttendees() {
		return a_persons;
	}

	@Override
	public Image getDefaultImage() {
		return defaultImage;
	}

}
