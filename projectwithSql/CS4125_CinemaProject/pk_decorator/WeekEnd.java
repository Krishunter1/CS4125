package pk_decorator;

public class WeekEnd extends PriceDecorator{
	
	Price price;
	
	public WeekEnd( Price _price ){
		price = _price;
	}

	@Override
	public double price() {
		return price.price() + 4.00;
	}
	
	public String getDescription(){
		return price.getDescription() + " Weekend ";
	}
	
}
