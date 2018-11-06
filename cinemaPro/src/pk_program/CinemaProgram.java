package pk_program;
import java.util.*;
import pk_controller.UIController;

public class CinemaProgram {

	public static void main( String [] args) {
		UIController uc = new UIController();
		ArrayList<String> users = new ArrayList<String>();
		users = uc.getUsers();
		
		System.out.print(users.size());
	}

}
