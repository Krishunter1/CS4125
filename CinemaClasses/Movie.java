public class Movie
{
	int movieID;
	String movieName;
	String movieGenre;
	
	public Movie()
	{
	}
	
	public Movie(int movieID, String movieName, String movieGenre)
	{
		this.movieID = movieID;
		this.movieName = movieName;
		this.movieGenre = movieGenre;
	}
	
	public int getMovieID()
	{
		return movieID;
	}
	
	public String getMovieName()
	{
		return movieName;
	}
	
	public String getMovieGenre()
	{
		return movieGenre;
	}
	
	public void setMovieID(int newID)
	{
		movieID = newID;
	}
	
	public void setMovieName(String newName)
	{
		movieName = newName;
	}
	
	public void setMovieGenre(String newGenre)
	{
		movieGenre = newGenre;
	}
}