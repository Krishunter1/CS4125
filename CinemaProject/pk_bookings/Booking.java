package pk_bookings;

import pk_movies.Movie;
import pk_movies.Seat;
import pk_users.User;

public class Booking {
	
	private int bookingID;
	private Seat aSeat;
	private Movie aMovie;
	private User aUser;
	private String PaymentType;
	
	public Booking(){}
	
	public Booking(int in_bookingID, Seat in_Seat , Movie in_Movie , User in_User , String in_PaymentType ){
		bookingID = in_bookingID;
		aSeat  = in_Seat;
		aMovie = in_Movie;
		aUser  = in_User;
	}
}
