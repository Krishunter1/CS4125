package pk_controller;


import java.util.*;

import pk_business.Booking;
import pk_business.CalculatePrices;
import pk_business.Login;
import pk_business.ManagerBL;
import pk_business.Menu;
import pk_userUI.LoginMenu;
import pk_userUI.ManagerMenu;
import pk_userUI.UserMenu;
import pk_userUI.displaySeats;
import pk_users.User;
public class UIController {
	
	private Menu newMenu;
	private static int userId;
	private String[] seats;
	
	public void displayLogin() {
		LoginMenu menu = new LoginMenu();
	}
	
	public void displayUserMenu(int id) {
		UserMenu menu = new UserMenu(this);
	}
	public void displayManagerMenu(int id){
		ManagerMenu menu = new ManagerMenu(this);
	}
	
	public void checkLogin(String username, String password) {
		Login login = new Login();
		
		int openMenu = login.checkLogin(username, password);
		System.out.print("I got this far");
		
		if(openMenu == 1) {
			userId = login.getUser();
			displayUserMenu(userId);
		}
		else if (openMenu == 2){
			userId = login.getUser();
			displayManagerMenu(userId);
		}else {
			displayLogin();
		}
	}
	public void approveBooking ( int bookingID ){
		ManagerBL m = new ManagerBL();
		m.ApproveBooking(bookingID);
	}
	public ArrayList<String> getRequestedRefunds(){
		ManagerBL m = new ManagerBL();
		return m.getRequestedRefunds();
	}
	public String[] getMovieNames() {
		newMenu = new Menu();
		return newMenu.getMovieNames();
	}
	public String getGenre(String name) {
		return newMenu.getGenre(name);
	}
	
	public Date[] getDates(String name) {
		return newMenu.getDates(name);
	}
	
	public String[] getTimes(Date date) {
		return newMenu.getTimes(date);
	}
	
	public String[] getSeats(String time) {
		seats = newMenu.getSeats(time);
		return seats;
	}
	
	public void setSeats(String[] array, int numberOfSeats) {
		newMenu.setSeats(array, numberOfSeats);
	}
	
	public ArrayList<String> getUserBookings(){
		ArrayList<String> res = new ArrayList<>();
		ArrayList<Booking> b;
		b = newMenu.getBookings(userId);
		
		for( Booking temp : b ){
			res.add(temp.getID() + "," + temp.getMovie());
		}
		return res;
		 
	}
	
	public void addBooking(String paymentType) {
		newMenu.addBooking(paymentType,userId);
		
	}
	public String getSelectedDate(){
		return newMenu.getSelectedDate();
	}
	public double getTicketPrice( String _type , String _date){
		CalculatePrices c = new CalculatePrices();
		return c.getPrice(_type, _date);
	}
	public String getTicketDes( String _type , String _date){
		CalculatePrices c = new CalculatePrices();
		return c.getTicketDes(_type, _date);
	}
}
