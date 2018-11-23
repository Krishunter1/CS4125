package pk_business;

public class Approved implements State {

	@Override
	public void doAction(Context _context) {
		_context.setState(this);
	}

	@Override
	public int getState() {
		// TODO Auto-generated method stub
		return 3;
	}

	@Override
	public String getStringState() {
		// TODO Auto-generated method stub
		return "Approved";
	}

	
 
}
