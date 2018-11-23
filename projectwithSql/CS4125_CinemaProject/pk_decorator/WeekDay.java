package pk_decorator;

public class WeekDay extends PriceDecorator{
	
	Price price;
	
	public WeekDay( Price _price ){
		price = _price;
	}

	@Override
	public double price() {
		return price.price() + 6.00;
	}
	
	public String getDescription(){
		return price.getDescription() + " Weekday ";
	}
	
}
