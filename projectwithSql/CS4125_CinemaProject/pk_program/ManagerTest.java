package pk_program;

import pk_database.DatabaseControl;
import pk_users.Manager;
import pk_users.User;

public class ManagerTest {
	
	public static void main (String args [] ){
		
		DatabaseControl dc = new DatabaseControl();
		Manager manager = new Manager();
		manager.loadRefundRequests(dc.getRefundRequests());
		manager.printRefundRequests();
	}
}
