package pk_program;
import java.util.*;

import pk_bookings.Booking;
import pk_business.Login;
import pk_controller.UIController;
import pk_database.DatabaseControl;
import pk_users.Customer;
import pk_users.Manager;
import pk_users.User;

public class CinemaProgram {

	public static void main ( String args [] ){
		UIController uc = new UIController();
		uc.displayLogin();
		/**LoginController lc = new LoginController();
		System.out.print(lc.checkLogin("danielk1995","password1"));
		User currentUser;
		currentUser = lc.getUser();
		if(currentUser instanceof Manager)
			System.out.println("User is a Manager"); 
		else if(currentUser instanceof Customer)
			System.out.println("User is a Customer");
		**/
	}

}
