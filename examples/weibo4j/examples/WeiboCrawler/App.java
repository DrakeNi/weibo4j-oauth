package weibo4j.examples.WeiboCrawler;

public class App {

	private String ClientId;
	private String ClientSecret;
	private String redirect_url;
	
	public App(String ClientId, String ClientSecret, String redirect_url){
		this.ClientId = ClientId;
		this.ClientSecret = ClientSecret;
		this.redirect_url = redirect_url;
	}
	
	public String getClientId(){
		return this.ClientId;
	}
	
	public String getClientSecret(){
		return this.ClientSecret;
	}
	
	public String getRedirectUrl(){
		return this.redirect_url;	
	}

}
