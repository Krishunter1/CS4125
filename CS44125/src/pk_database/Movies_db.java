package pk_database;

import java.io.*;

import java.util.ArrayList;

public class Movies_db{
	
	private ArrayList<String> Movies;
	public Movies_db(){
		Movies = new ArrayList<String>();
		loadMovies();
	}
	private void loadMovies(){
		File aFile = new File("Movies.txt");
		FileReader fr;
		try {
			fr = new FileReader(aFile);
			BufferedReader bfr = new BufferedReader(fr);
			String line ="";
			while((line =bfr.readLine())!=null){
				if( line == null) {break;}
				Movies.add(line);
			}
			fr.close();
			bfr.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<String> getMovies(){
		return Movies;
	}
}
