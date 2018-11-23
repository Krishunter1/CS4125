package pk_users;
import java.util.ArrayList;

import pk_business.Booking;
import pk_refunds.Refund;

public class Manager extends User{
	
	private ArrayList<Booking> refundRequests;
	
	public Manager(){}
	public Manager( int in_userID , String in_username, String in_password){
		super(in_userID,in_username,in_password);
		refundRequests = new ArrayList<>();
	}
	public void loadRefundRequests( ArrayList<Booking> _refundRequests){
		_refundRequests = refundRequests;
	}
	public void printRefundRequests(){
		for(Booking abooking : refundRequests){
			System.out.println(abooking.getInfo());
		}
	}
	
	
}