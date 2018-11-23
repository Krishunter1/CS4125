package pk_business;

public interface State {
	void doAction(Context _context);
	int getState();
	String getStringState();
}
