package session4;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import com.squeed.kata.nametag.entities.Attendee;
import com.squeed.kata.nametag.entities.Event;

public class EmptyEvent implements Event {

	public EmptyEvent(){
		return;
	}

	@Override
	public List<Attendee> getExpectedAttendees() {
		return new ArrayList<>();
	}

	@Override
	public Image getDefaultImage() {
		// TODO Auto-generated method stub
		return null;
	}
}
