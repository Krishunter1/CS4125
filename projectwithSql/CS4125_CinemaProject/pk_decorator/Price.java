package pk_decorator;

public abstract class Price {
	protected String description = "Ticket";
	
	public String getDescription(){
		return description;
	}
	
	public abstract double price();
	
}
