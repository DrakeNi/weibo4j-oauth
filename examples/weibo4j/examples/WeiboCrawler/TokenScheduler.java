package weibo4j.examples.WeiboCrawler;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.sql.Timestamp;
import java.util.Date;

import weibo4j.http.AccessToken;

public class TokenScheduler {
	
	private int appRatelimit;
	private int userRatelimit;
	private int appNumber;
	private int userNumber;
	private long resetTime;
	private ArrayList<App> apps;
	private ArrayList<AppUser> appUsers;
	private ArrayList<AccessToken> accessTokens;
	private int current;
	
	public TokenScheduler(int appRatelimit, int userRatelimit, int appNumber, int userNumber, long resetTime){
	
		this.appRatelimit = appRatelimit;
		this.userRatelimit = userRatelimit;
		this.appNumber = appNumber;
		this.userNumber = userNumber;
		this.resetTime = resetTime;
		this.apps = new ArrayList<App>(appNumber);
		this.appUsers = new ArrayList<AppUser>(userNumber);
		this.accessTokens = new ArrayList<AccessToken>(appNumber*userNumber);
		
		//this.apps = null;
		//this.appUsers = null;
		//this.accessTokens = null;
		this.current = 0;
	}
	
	public void setApps(ArrayList<App> apps){
		
		if(apps.size()!=this.appNumber){
			System.out.println("Wrong Number of Apps!");
			return;
			}
		for(App a: apps){
			this.apps.add(a);
		}
	}
	
	public void setAppUsers(ArrayList<AppUser> appUsers){
		if(appUsers.size()!=this.userNumber){
			System.out.println("Wrong Number of AppUsers!");
			return;
		}
		for(AppUser au: appUsers){
			this.appUsers.add(au);
		}
		//this.appUsers = appUsers;
	}
	
	public void setAccessTokens(){
		
		for(App a : this.apps)
			for(AppUser au : this.appUsers){
				AccessToken at = AccessTokenIssuer.GetToken(a, au);
				this.accessTokens.add(at);
			}
	}
	
	public AccessToken getCurrentAccessToken(){
	
		System.out.println("Current AccessToken index is " + this.current);
		return accessTokens.get(this.current);
		
	}
	
	public AccessToken getNextAccessToken(){
		int Maxlength = this.accessTokens.size()-1;
		while(this.current<Maxlength){
			this.current++;
			System.out.println("AccessToken index is " + this.current);
			return accessTokens.get(this.current);
		}
		
		ResetToken();
		return accessTokens.get(this.current);
		
	}

	public void ResetToken() {
		// TODO Auto-generated method stub
		try {
			System.out.println("Program stops at " + new Timestamp(System.currentTimeMillis()));
			Thread.sleep(1000*60*10);
			setAccessTokens();
			this.current = 0;
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public int getCurrent(){
		return this.current;
	}
	
	public void printApp(){
		for(App a: this.apps){
			System.out.println(a.getClientId());
			System.out.println(a.getClientSecret());
		}
	}
	public void printAcesstoken(){
		int i = 0;
		for(AccessToken at: this.accessTokens){
			i++;
			if(at!=null){
				System.out.println(at.toString());
			}else{
				System.out.println("The" + i + "access_token is null");
			}
		}
		
	}
	
	
	
    

	
	

}
