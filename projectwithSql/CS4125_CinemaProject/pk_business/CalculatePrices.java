package pk_business;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import pk_decorator.*;


public class CalculatePrices {

	private Price p;
	private void initPrice(String type , String date){
		double result = 0.00;
		Calendar c = Calendar.getInstance();
		Date d = new Date();
		try {
			d = new SimpleDateFormat("yyyy-MM-dd").parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SimpleDateFormat simpleDateformat = new SimpleDateFormat("E"); // the day of the week abbreviated
        System.out.println(simpleDateformat.format(d));
 
        simpleDateformat = new SimpleDateFormat("EEEE"); // the day of the week spelled out completely
        System.out.println(simpleDateformat.format(d));
 
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(d);
        System.out.println(calendar.get(Calendar.DAY_OF_WEEK)); 
        
        String day = simpleDateformat.format(d);
        
        if(day.matches("Sunday") || day.matches("Friday") || day.matches("Saturday")){
        		if(type.matches("Adult")){
        			p = new WeekEnd(new AdultTicket());
        		}else if (type.matches("Student")){
        			p = new WeekEnd(new StudentTicket());
        		}else if	(type.matches("Child")){
        			p = new WeekEnd(new ChildTicket());
        		}
        }else {
	        	if(type.matches("Adult")){
	    			p = new WeekDay(new AdultTicket());
	    		}else if (type.matches("Student")){
	    			p = new WeekDay(new StudentTicket());
	    		}else if	(type.matches("Child")){
	    			p = new WeekDay(new ChildTicket());
	    		}
        }
	}
	
	public double getPrice( String type , String date){
		initPrice(type,date);
        return p.price();
	}
	public String getTicketDes( String type , String date ){
		initPrice(type,date);
		return p.getDescription();
	}
}
