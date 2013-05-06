package weibo4j.examples.WeiboCrawler;

public class AppUser {
	
	private String uname;
	private String password;
	
	public AppUser(String uname, String password){
		this.uname = uname;
		this.password = password;
	}
	
	public String getUname(){
		return this.uname;
	}
	
	public String getPassWord(){
		return this.password;
	}

}
