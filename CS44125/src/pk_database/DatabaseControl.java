package pk_database;

import java.util.ArrayList;

public class DatabaseControl {
	
	Movies_db moviesDB = new Movies_db();
	
	public DatabaseControl(){
	
	}
	
	public ArrayList<String> getMovies(){
		return moviesDB.getMovies();
	}
	
	
}
