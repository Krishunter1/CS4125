package pk_business;
import java.util.ArrayList;


import pk_controller.UIController;
import pk_database.DatabaseControl;
import pk_factory.Factory;
import pk_userUI.LoginMenu;
import pk_users.Customer;
import pk_users.Manager;
import pk_users.User;
public class Login{
	private UIController ui = new UIController();
	private User currentUser;
	
	public int checkLogin( String in_Username , String in_Password ){
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
					System.out.print(temp.getClass());
					success = true;
			}
			
		}
		//System.out.print(temp.getClass());
		if(success && (currentUser instanceof Customer)) {
			return 1;
		}else if (success && (currentUser instanceof Manager)){
			return 2;
		}else{
			return 0;
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
			ui.displayLogin();
		}
	}
	
	public int getUser(){
		return currentUser.getUserID();
	}
}