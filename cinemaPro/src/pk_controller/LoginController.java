package pk_controller;
import java.util.ArrayList;
import pk_database.DatabaseControl;
public class LoginController{
	
	private boolean loginSuccess;
	private String  loginUsername;
	private String  loginPassword;
	private UIController ui;
	
	public LoginController( String in_Username , String in_Password ){
		this.loginUsername = in_Username;
		this.loginPassword = in_Password;
	}
	
	public void checkLogin(){
		DatabaseControl dc = new DatabaseControl();
		ArrayList<String> tempResults = dc.getUsers();
		System.out.println(tempResults);
		for( String temp : tempResults ){
			String tempArr [] = temp.split(",");

			if(loginUsername.matches(tempArr[0]) && loginPassword.matches(tempArr[1]))
				ui = new UIController();
				ui.displayUserMenu();
		}
	}
	
}