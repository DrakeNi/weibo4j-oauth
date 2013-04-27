package weibo4j.examples.MyCrawler;

public class App {
	
	private String ClientId;
	private String ClientSecret;
	
	public App(String ClientId, String ClientSecret){
		this.ClientId = ClientId;
		this.ClientSecret = ClientSecret;
	}
	
	public String GetClientId(){
		return this.ClientId;
	}
	
	public String GetClientSecret(){
		return this.ClientSecret;
	}

}
