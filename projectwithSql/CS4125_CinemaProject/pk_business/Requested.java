package pk_business;

public class Requested implements State {

	@Override
	public void doAction(Context _context) {
		_context.setState(this);
		
	}
	
	public int getState(){
		return 1;
	}

	@Override
	public String getStringState() {
		// TODO Auto-generated method stub
		return "Requested";
	}
	
	
}
