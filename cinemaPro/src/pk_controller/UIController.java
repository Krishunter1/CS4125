package pk_controller;
import pk_database.DatabaseControl;
import java.util.*;
public class UIController {
	
	public DatabaseControl dbc;

	
	public UIController(){
		dbc = new DatabaseControl();
	}
	public ArrayList<String> getUsers(){
		return dbc.getUsers();
	}
	
}
