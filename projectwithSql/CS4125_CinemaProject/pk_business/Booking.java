package pk_business;

import pk_database.DatabaseControl;
import pk_movies.Movie;
import pk_movies.Seat;
import pk_users.User;

public class Booking {
	private DatabaseControl du;
	private int bookingid;
	private int userId;
	private int listingId;
	private int seatId;
	private int seatNo;
	private String paymentTyp;
	private Context state;
	
	public Booking(int bookingid,int userId, int listingId, int seatNo , String paymentTyp ){
		this.bookingid = bookingid;
		this.userId = userId;
		this.listingId = listingId;
		this.seatNo = seatNo;
		this.paymentTyp = paymentTyp;
		state = new Context();
		NotRequested s = new NotRequested();
		s.doAction(state);
		state.setState(s);
	}
	
	public Booking(int userId, int listingId, int seatNo , String paymentTyp) {
		this.userId = userId;
		this.listingId = listingId;
		this.seatNo = seatNo;
		this.paymentTyp = paymentTyp;
	}

	public Booking() {
		// TODO Auto-generated constructor stub
	}

	public void updateDatabase() {
		du = new DatabaseControl();
		du.addBooking(userId, listingId,seatNo,paymentTyp);
	}
	public int getID(){
		return bookingid;
	}
	public int getUserID(){
		return userId;
	}
	public int getMovie(){
		return listingId;
	}
	public String getInfo(){
		return "This is some information\n this is more info\n this is the last bit of info";
	}
	public void setRequested(){
		Requested req = new Requested();
		req.doAction(state);
		state.setState(req);
	}
	public int getState(){
		 return state.getState().getState();
		
	}
	public String getStateStr(){
		 return state.getState().getStringState();
		
	}
	public void setApproved(){
		Approved app = new Approved();
		app.doAction(state);
		state.setState(app);
	}
}
