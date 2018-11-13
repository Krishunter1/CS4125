package pk_database;

import java.util.ArrayList;

import pk_factory.Factory;
import pk_movies.Movie;
import pk_movies.MovieListing;
import pk_users.User;

public class DatabaseControl {
		
		private Connection conn;
		// Change array list types from strings to appropriate types
		private ArrayList<Movie> movies;
		private ArrayList<User> users;
		private ArrayList<MovieListing> movieListings;
		private Factory uf;
		
		public DatabaseControl(){
			
		}
		private void loadUsers(){
			Connection conn2 = new Connection("Users.txt");
			ArrayList<String> tempUsers = conn2.getData();
			for( String temp : tempUsers){
				String temp2[] = temp.split(",");
				if(Integer.parseInt(temp2[3]) == 1){
					users.add(uf.instanceCustomer(Integer.parseInt(temp2[0]),temp2[1],temp2[2]));
				}else if(Integer.parseInt(temp2[3]) == 2){
					users.add(uf.instanceManager(Integer.parseInt(temp2[0]),temp2[1],temp2[2]));
				}
			}
			
		}
		public ArrayList<User> getUsers(){
			loadUsers();
			return users;
		}
		public ArrayList<Movie> getMovies(){
			
			Connection aConn = new Connection("Movies.txt");
			ArrayList<String> tempMovies = aConn.getData();
			
			for( String temp : tempMovies){
				String tempArr [] = temp.split(",");
				movies.add(new Movie( Integer.parseInt(tempArr[0]) , tempArr[1] , tempArr[2]));
				
			}
			
			
			
			return movies;
		}
		public ArrayList<MovieListing> getMovieListings(){
			
			
			return movieListings;
		}
		/*
		public ArrayList<Seat> getSeat(){
			return seats;
		}
		public ArrayList<RefundRequests>(){
			return RefundRequests;
		}
		public void updateMovie( int in_id , String in_name , String in_genre){
			Movie tempMovie = new Movie(in_id,in_name,in_genre);
			
			for(Movie m : movies){
				if(tempMovie.getID() == m.getID()){
					m = tempMovie;
				}
			}
			
		}
		public void convertToString(Object obj){
			if (obj instanceof Movie){
				
			}
					
				
		}*/

}
