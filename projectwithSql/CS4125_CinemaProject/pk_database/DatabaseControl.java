package pk_database;

import java.util.ArrayList;
import java.util.Date;

import pk_business.Booking;

import java.sql.PreparedStatement;

import pk_factory.Factory;
import pk_movies.Movie;
import pk_movies.MovieListing;
import pk_refunds.Refund;
import pk_users.User;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.sql.DriverManager;

public class DatabaseControl {
		
	private Connection connect;
	private Statement statement;
	private ResultSet resultSet;
	private PreparedStatement preparedStatement;
	private Factory uf;
	private int seatId;
	
	public DatabaseControl(){
		try {
			loadDatabase();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void loadDatabase() throws Exception {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection("jdbc:mysql://localhost:4444/project","puser","pass");
			statement = connect.createStatement();
			}catch(Exception e) {
				throw e;
			}
	}
	
	public ArrayList<User> getUsers() {
		ArrayList<User> users = new ArrayList<>();
		uf= new Factory();
		try {
			resultSet = statement.executeQuery("select * from users");
			while(resultSet.next()) {
				if(resultSet.getInt(4) == 1) {
				users.add(uf.instanceCustomer(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3)));
				}
				else if(resultSet.getInt(4) == 2)  {
					users.add(uf.instanceManager(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3)));
				}
			}
			resultSet.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return users;
	}
	
	public ArrayList<Movie> getMovies(){
		ArrayList<Movie> movies = new ArrayList<>();
		try {
			resultSet = statement.executeQuery("select * from movies");
			while(resultSet.next()) {
				movies.add(new Movie(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3)));
				}
			resultSet.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return movies;
	}
	
	public void addUser(String username, String password) {
		try {
			preparedStatement = connect.prepareStatement("insert into Users values (default, ?, ?, '1')");
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public ArrayList<MovieListing> getDates(String name) {
		ArrayList<MovieListing> listings = new ArrayList<>();
		try { 
			preparedStatement = connect.prepareStatement("Select listId, movie,date, time  from movieListings JOIN movies ON movieListings.movie=movies.movieId where movieName = ?");
			preparedStatement.setString(1, name);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				int listingId = resultSet.getInt(1);
				int movieId = resultSet.getInt(2);
				java.util.Date date = resultSet.getDate(3);
				String time = resultSet.getString(4);
				listings.add(new MovieListing(listingId, movieId, date, time));
			}
			preparedStatement.close();
			resultSet.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listings;
	}
	
	public String getSeats(int listId) {
		String seats = "";
		try {
			preparedStatement = connect.prepareStatement("Select seatsId, seat from seats where listingId = ?");
			preparedStatement.setInt(1, listId);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
			seatId = resultSet.getInt(1);
			seats = resultSet.getString(2);
			}
			preparedStatement.close();
			resultSet.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return seats;
	}
	public void updateBooking ( Booking b){
		try{

			preparedStatement = connect.prepareStatement(" Update Bookings set refundRq = ? where bookingId = ?;");
			preparedStatement.setInt(1, b.getState());
			preparedStatement.setInt(2,b.getID());
			preparedStatement.execute();
			
			
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void setSeats(String seat) {
		try {
			System.out.print(seat);
			preparedStatement = connect.prepareStatement("UPDATE seats SET seat = ? WHERE seatsId = ?");
			preparedStatement.setString(1, seat);
			preparedStatement.setInt(2, seatId);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void addBooking(int userId, int listingId, int seatNo , String paymentTyp ) {
		try {
			System.out.print(userId);
			preparedStatement = connect.prepareStatement("insert into bookings values (default, ?, ?,?,?, default)");
			preparedStatement.setInt(1, userId);
			preparedStatement.setInt(2, listingId);
			preparedStatement.setInt(3, seatNo);
			preparedStatement.setString(4, paymentTyp);
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public ArrayList<Booking> getRefundRequests(){
		ArrayList<Booking> refundsRequested = new ArrayList<>();
		try {
			preparedStatement = connect.prepareStatement("select * from bookings where refundRq = 1;");
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
			Booking tempBooking = new Booking(resultSet.getInt(1),resultSet.getInt(2),resultSet.getInt(3),resultSet.getInt(4),resultSet.getString(5));
			tempBooking.setRequested();
			refundsRequested.add(tempBooking);
			}
			preparedStatement.close();
			resultSet.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return refundsRequested;
	}
	public ArrayList<Booking> getAllBookings(){
		
		ArrayList<Booking> result = new ArrayList<Booking>();
		
		
		try{
			preparedStatement = connect.prepareStatement("select * from bookings");
			resultSet = preparedStatement.executeQuery();
			while( resultSet.next()){
				Booking b = new Booking ( resultSet.getInt(1) ,resultSet.getInt(2) ,resultSet.getInt(3),resultSet.getInt(4), resultSet.getString(5));
				//if(resultSet.getInt(6) == 1)
					b.setRequested();
				result.add(b);
			}
			
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return result;
	}
	public ArrayList<Booking> getCurrentUserBookings(int userId){
		ArrayList<Booking> bookings = new ArrayList<>();
		try{
			preparedStatement = connect.prepareStatement("select * from bookings where userId = ?;");
			preparedStatement.setInt(1, userId);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
			Booking tempBooking = new Booking(resultSet.getInt(0),resultSet.getInt(1),resultSet.getInt(2),resultSet.getInt(3),resultSet.getString(4));
			
			}
			preparedStatement.close();
			resultSet.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bookings;
	}
	public ArrayList<String> getRequestedRefunds(){
		ArrayList<String> result = new ArrayList<>();
		
		try{
			preparedStatement = connect.prepareStatement(" select bookingID , username , movieName from bookings,users,movielistings,movies where bookings.userId = users.userId && bookings.listingId = movielistings.listId && refundRq = 1;");
			resultSet = preparedStatement.executeQuery();
			if(resultSet!=null){
				while(resultSet.next()){
					result.add( resultSet.getString(1) + "," + resultSet.getString(2) + "," + resultSet.getString(3) + "," + "Requested");
				}}
		
		preparedStatement.close();
		resultSet.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
		
	}

}
