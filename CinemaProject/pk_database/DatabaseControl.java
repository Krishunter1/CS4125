package pk_database;

import java.util.ArrayList;

public class DatabaseControl {
		
		private Connection conn;
		public DatabaseControl( String in_filePath ){
			conn = new Connection( in_filePath );
		}
		
}
