public class LoginController{
	
	private boolean loginSuccess;
	private String  loginUsername;
	private String  loginPassword;
	
	LoginController( String in_Username , String in_Password ){
		this.loginUsername = in_Username;
		this.loginPassword = in_Password;
	}
	
	public boolean checkLogin(){
		boolean success = false;
		DatabaseControl dc = new DatabaseControl("Users.txt");
		ArrayList<String> tempResults = dc.getData();
		
		for( String temp : tempResults ){
			String tempArr = temp.split(",");
			
			if(loginUsername.matches(tempArr[0]) && loginPassword.matches(tempArr[1]))
				success = truel;
		}
		return success;
	}
	
}