package pk_controller;
import pk_database.DatabaseControl;
import pk_userUI.LoginMenu;
import java.util.*;
import pk_userUI.UserMenu;
public class UIController {
	
	public void displayLogin() {
		LoginMenu menu = new LoginMenu();
	}
	
	public void displayUserMenu() {
		UserMenu display = new UserMenu();
	}
	
}
