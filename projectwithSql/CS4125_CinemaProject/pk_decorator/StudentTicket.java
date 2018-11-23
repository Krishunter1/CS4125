package pk_decorator;

public class StudentTicket extends Price {
	
	public StudentTicket(){
		description = "Student Ticket";
	}

	@Override
	public double price() {
		return 7.00;
	}
}
