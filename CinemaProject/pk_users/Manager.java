package pk_users;
import java.util.ArrayList;

public class Manager implements User{
	
	private ArrayList<Refund> refundRequests;
	
	Manager( int in_userID , String in_username, String in_password){
		refundRequest = ArrayList<Refund>();
	}
	
	public ArrayList<Refund> showRefundRequests(){
		return refundRequests;
	}
	
	public Refund approveRefundRequest( Refund in_refund ){
		
		in_refund.setStatus("Approve");
		
		return in_refund;
	}
}