package pk_decorator;

public class AdultTicket extends Price {
	
	public AdultTicket( ){
		description = "Adult Ticket";
	}

	@Override
	public double price() {
		return 15.00;
	}
}
