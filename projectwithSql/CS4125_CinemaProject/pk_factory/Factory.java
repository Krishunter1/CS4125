package pk_factory;

import pk_users.Customer;
import pk_users.Manager;
import pk_users.User;

public class Factory {
	
	private User instance;
	public Factory(){
		
	}
	public User instanceManager(int _id , String _username , String _password){
		instance = new Manager( _id ,  _username ,  _password);
		return instance;
	}
	public User instanceCustomer(int _id , String _username , String _password){
		instance = new Customer( _id ,  _username ,  _password);
		return instance;
	}
	
}
