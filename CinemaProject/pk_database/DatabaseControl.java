package pk_database;

import java.util.ArrayList;

public class DatabaseControl {
		
		private Connection conn;
		// Change array list types from strings to appropriate types
		private ArrayList<String> movies;
		private ArrayList<String> users;
		
		
		public DatabaseControl(){
			loadData();
		}
		private void loadData(){
			movies = new ArrayList<String>();
			conn = new Connection("Movies.txt");
			movies = conn.getData();
			users = new ArrayList<String>();
			Connection conn2 = new Connection("Users.txt");
			users = conn2.getData();
			
		}
		public ArrayList<String> getUsers(){
			return users;
		}
		
}
