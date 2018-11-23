package pk_business;

public class Context {
	
	private State _state;
	
	public Context () {
		_state = null;
	}
	
	public void setState( State _state){
		this._state = _state;
	}
	public State getState (){
		return _state;
	}
}
