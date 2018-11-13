package pk_refunds;

public class Refund
{
	private int refundID;
	private Booking bookingRequested;
	private User userRequested;
	private String status;
	
	public Refund()
	{
	}
	
	public Refund(int refundID, Booking bookingRequested, User userRequested, String status)
	{
		this.refundID = refundID;
		this.bookingRequested = bookingRequested;
		this.userRequested = userRequested;
		this.status = status;
	}
	
	public int getRefundID()
	{
		return refundID;
	}
	
	public Booking getBooking()
	{
		return bookingRequested;
	}
	
	public String getStatus()
	{
		return status;
	}
	
	public void setStatus(String status)
	{
		this.status = status;
	}
	
}