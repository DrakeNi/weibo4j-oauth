package weibo4j.examples.WeiboCrawler;

public class AppUser {
	
	private String uname;
	private String password;
	
	public AppUser(String uname, String password){
		this.uname = uname;
		this.password = password;
	}
	
	public String GetUname(){
		return this.uname;
	}
	
	public String GetPassWord(){
		return this.password;
	}

}
