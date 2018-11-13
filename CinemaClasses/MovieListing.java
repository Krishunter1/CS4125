public class MovieListing 
{
	private int listingID;
	private Movie movie;
	private int listingDate;
	private int listingTime;
	private boolean listingIsActive = false;
	private Seat listingSeats;
	
	public MovieListing()
	{
	}
	
	public MovieListing(int listingID, Movie movie, int listingDate, int listingTime, boolean listingIsActive, Seat listingSeats)
	{
		this.listingID = listingID;
		this.movie = movie;
		this.listingDate = listingDate;
		this.listingTime = listingTime;
		this.listingIsActive = listingIsActive;
		this.listingSeats = listingSeats;
	}
	
	public int getListingID()
	{
		return listingID;
	}
	
	public int getMovieID()
	{
		return movie.getMovieID();
	}
	
	public int getListingDate()
	{
		return listingDate;
	}
	
	public int getListingTime()
	{
		return listingTime;
	}
	
	public boolean getListingActive()
	{
		return listingIsActive;
	}
	
	public String getListingInfo()
	{
		String output = " ";
		output += listingID;
		output += listingDate;
		output += listingTime;
		output += movie.getMovieName();
		return output;
	}
	
	public void reserveSeats(int, int)
	{
	}
}
		
		
	
	