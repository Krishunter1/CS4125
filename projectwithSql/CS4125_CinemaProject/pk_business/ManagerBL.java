package pk_business;

import java.util.ArrayList;

import pk_controller.UIController;
import pk_database.DatabaseControl;
import pk_users.User;

public class ManagerBL {
	
	private UIController ui = new UIController();
	private User currentUser;
	private DatabaseControl dc = new DatabaseControl();
	
	public ArrayList<Booking> getRequestedRefunds(){
		return dc.getRefundRequests();
	}
}
