package weibo4j.examples.MyCrawler;

public class UserInfo {
	
	private String uname;
	private String password;
	
	public UserInfo(String uname, String password){
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
