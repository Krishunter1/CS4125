import java.io.*;
import java.util.*;
import javax.swing.*;
import java.lang.*;

public class LoginDB
{
	boolean realUser = false;
	String username;
	String password;
	
	LoginDB(String username, String password)
	{
		this.username = username;
		this.password = password;
	}
	
	boolean checkLogin() throws IOException
	{
		FileReader loginDatabase = new FileReader("database.txt");
		Scanner in = new Scanner(loginDatabase);
		String lineFromFile;
		String tempArray[];
		
		while (in.hasNext())
		{
			lineFromFile = in.nextLine();
			tempArray = lineFromFile.split(" ");
			if (username.matches(tempArray[0]) && password.matches(tempArray[1]))
				{
					return true;
				}
		}
		
		return false;
	}
}
			
			
		
	