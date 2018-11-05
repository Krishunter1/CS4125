package pk_controller;
import pk_database.DatabaseControl;
import pk_users.User;
public class BookingController {
	
		private DatabaseControl dbc;
		
		public BookingController( String in_filePath ){
			dbc = new DatabaseControl();
		}
		
		public boolean confirmBooking( int in_seatNumber , User in_user , String in_movieTitle , String movieTime ){
			return true;
		}
		public String showBooking(){
			return "";
		}
		
}
