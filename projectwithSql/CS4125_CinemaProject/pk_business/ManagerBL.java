package pk_business;

import java.util.ArrayList;

import pk_controller.UIController;
import pk_database.DatabaseControl;
import pk_users.User;

public class ManagerBL {
	
	private UIController ui = new UIController();
	//private User currentUser;
	private DatabaseControl dc = new DatabaseControl();
	private ArrayList<Booking> bookings = new ArrayList<>();
	
	
	public ArrayList<String> getRequestedRefunds(){
		return dc.getRequestedRefunds();
	}
	public void ApproveBooking (int bookingID ){
		ArrayList<Booking> b = dc.getAllBookings();
		Booking t = new Booking();
		for(Booking temp : b){
			if(temp.getID() == bookingID){
				temp.setApproved();
				t = temp;
			}
		}
		dc.updateBooking(t);
	}
	

}
