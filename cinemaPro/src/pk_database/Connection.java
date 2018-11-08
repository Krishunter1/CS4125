package pk_database;

import java.io.*;

import java.util.ArrayList;

public class Connection {
	
	private ArrayList<String> results  = new ArrayList<>();
	private File filePath;
	
	public Connection( String in_filePath ){	
		filePath = new File(in_filePath);
		loadFile();
	}
	
	private void loadFile(){
		
		FileReader fr;
		
		try{
			
			fr = new FileReader(filePath);
			
			BufferedReader bfr = new BufferedReader(fr);
			
			String line = "";
			
			while( ( line = bfr.readLine()) != null ){
				results.add(line);
			}
			
			bfr.close();
			fr.close();
			
		}catch (FileNotFoundException e) {
			System.out.print("File cannot be found");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}
	}

	public ArrayList<String> getData(){
		return results;
	}
	public void addInfo( String in_info ){
		results.add(in_info);
	}
	public void updateFile(){
		FileWriter fw;
		try {
			fw = new FileWriter(filePath);
			BufferedWriter bfw = new BufferedWriter(fw);
			for(String temp : results){
				bfw.append(temp);
			}

			fw.close();
			bfw.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
