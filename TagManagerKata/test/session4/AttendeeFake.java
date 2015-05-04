package session4;

import com.squeed.kata.nametag.entities.Attendee;

public class AttendeeFake implements Attendee {

	private String name;
	public AttendeeFake(String name){
		this.name = name;
	}
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getEmailAddress() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getTwitterHandle() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getLinkedInProfileId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getFacebookProfileId() {
		// TODO Auto-generated method stub
		return null;
	}

}
