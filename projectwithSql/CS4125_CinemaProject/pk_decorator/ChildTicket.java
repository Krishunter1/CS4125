package pk_decorator;

public class ChildTicket extends Price {
	
	public ChildTicket(){
		description = "Child Ticket";
	}

	@Override
	public double price() {
		return 5.00;
	}
}
