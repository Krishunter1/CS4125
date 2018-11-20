package pk_controller;
import java.util.ArrayList;
import pk_database.DatabaseControl;
import pk_factory.Factory;
import pk_userUI.LoginMenu;
import pk_users.Customer;
import pk_users.Manager;
import pk_users.User;
public class LoginController{
	private UIController ui = new UIController();
	private User currentUser;
	
	public void checkLogin( String in_Username , String in_Password ){
		boolean success = false;
	
		DatabaseControl dc = null;
		try {
			dc = new DatabaseControl();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<User> tempUsers = new ArrayList<User>();
		tempUsers = dc.getUsers();
		for( User temp : tempUsers ){
			if( temp.getUsername().matches(in_Username) && temp.getPassword().matches(in_Password)){
				currentUser = temp;
				success = true;
			}
	
		}
		if(success && (currentUser instanceof User)) {
			ui.displayUserMenu(currentUser.getUserID());
		}else {
			ui.displayLogin();
		}
	}
	
	public void registerUser(String in_Username, String in_Password) {
		boolean success = false;
		
		DatabaseControl dc = null;
		dc = new DatabaseControl();
		ArrayList<User> tempUsers = new ArrayList<User>();
		tempUsers = dc.getUsers();
		for( User temp : tempUsers ){
			if(temp.getUsername().matches(in_Username)){
				success = true;
			}
		}
		if(!success) {
			dc.addUser(in_Username, in_Password);
			System.out.print("User Created");
			LoginMenu logi = new LoginMenu();
		}
	}
	
	public User getUser(){
		return currentUser;
	}
}