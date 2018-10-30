public class user_DB
import java.io.*;
import java.util.ArrayList;
{
//userDB
	private ArrayList<String> Users;
	public user_db()
	{
		Users = new ArrayList<String>();
		loadUsers();
	}
public addUser(String username,String password)
{
try
{
	String line = username + "," + password;
	FileWriter fw = new FileWriter("User.txt", true);
	PrintWriter pw = new PrintWriter(fw);

	pw.println(line);
	pw.close();
	}
	catch(FileNotFoundException e){}
}

public boolean checkUser(String username, String password)
{
File aFile = new File("Users.txt");
		FileReader fr;
		try {
			fr = new FileReader(aFile);
			BufferedReader bfr = new BufferedReader(fr);
			String line ="";
			while((line =bfr.readLine())!=null)
			{
				if( line == null) {break;}
				Users.add(line);
			}
			fr.close();		
			bfr.close();
			}
			catch (FileNotFoundException e) 
		    {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
			catch (IOException e) 
			{
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
}
}