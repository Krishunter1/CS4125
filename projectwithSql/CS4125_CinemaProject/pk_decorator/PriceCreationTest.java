package pk_decorator;

import java.text.*;
import java.util.ArrayList;
import java.util.Calendar;

public class PriceCreationTest {

	public static void main(String[] args) {
		ArrayList<Price> tickets = new ArrayList<>();
		tickets.add(new WeekDay(new AdultTicket()));
		tickets.add(new WeekDay(new ChildTicket()));
		tickets.add(new WeekDay(new StudentTicket()));
		tickets.add(new WeekEnd(new AdultTicket()));
		tickets.add(new WeekEnd(new ChildTicket()));
		tickets.add(new WeekEnd(new StudentTicket()));
		
		System.out.println("Prices during the week");
		for(int i = 0; i < 3 ; i++){
			Price p = tickets.get(i);
			System.out.println(p.getDescription() + " : " + p.price() );
		}
		System.out.println("Prices during the week");
		for(int i = 3; i < 6 ; i++){
			Price p = tickets.get(i);
			System.out.println(p.getDescription() + " : " + p.price() );
		}
		
	}

}
