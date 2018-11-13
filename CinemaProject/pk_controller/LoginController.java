package pk_controller;
import java.util.ArrayList;
import pk_database.DatabaseControl;
import pk_factory.Factory;
import pk_users.Customer;
import pk_users.Manager;
import pk_users.User;
public class LoginController{
	
	private User currentUser;
	
	public LoginController(){}
	
	public boolean checkLogin( String in_Username , String in_Password ){
		boolean success = false;
	
		DatabaseControl dc = new DatabaseControl();
		ArrayList<User> tempUsers = new ArrayList<User>();
		tempUsers = dc.getUsers();
		Factory uf = new Factory();
		for( User temp : tempUsers ){
			if( temp.getUsername().matches(in_Username) || temp.getPassword().matches(in_Password)){
				currentUser = temp;
				success = true;
			}
	
		}
		return success;
	}
	public User getUser(){
		return currentUser;
	}
}