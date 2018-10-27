package pk_ui;

import java.util.ArrayList;

import javax.swing.*;

import pk_database.DatabaseControl;

public class UIcontroller extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable moviesTbl;
	private DatabaseControl DC;
	public UIcontroller(){
		DC = new DatabaseControl();
		this.setTitle("Test");
		this.setSize(500,500);
		ArrayList<String> movies = DC.getMovies();
		Object data [][] = new Object[50][50];
		
		for(int i = 0 ; i < movies.size() ; i++){
			String temp [] = movies.get(i).split(",");
				for(int j = 0 ; j < temp.length; j++){
					data[i][j] = temp[j];
				}
		}
		String colNames [] = {"MovieID" , "MovieName" , "MovieType" ,  "MovieRating"};
		moviesTbl = new JTable(data,colNames);
		this.add(moviesTbl);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	
	}
}
