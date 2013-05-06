package weibo4j.examples.account;

import weibo4j.Account;
import weibo4j.examples.MyCrawler.UserLogin;
import weibo4j.examples.oauth2.Log;
import weibo4j.http.AccessToken;
import weibo4j.model.RateLimitStatus;
import weibo4j.model.WeiboException;

public class GetAccountRateLimitStatus {

	public static void main(String[] args) {
		//String access_token =args[0];
		
		UserLogin login = new UserLogin();
		login.SetUid("xushun007@163.com");
		login.SetPasswd("19871211");
		login.SetClientId("3464070480");
		login.SetClientSecret("a00cf7dee38a6eba734f5db043ac5577");
		AccessToken nactken = login.GetToken();
		if(nactken==null){
			System.out.println("Error");
			return;
		}
		
		String access_token = (nactken).getAccessToken();
		System.out.println(nactken.toString());
		
		
		Account am = new Account();
		am.client.setToken(access_token);
		try {
            RateLimitStatus json = am.getAccountRateLimitStatus();
			Log.logInfo(json.toString());
			System.out.println(json.toString());
			System.out.println(json.getRemainingUserHits());
			System.out.println(json.getRateLimitRemaining());
			System.out.println(json.getRemainingIpHits());
		} catch (WeiboException e) {
			e.printStackTrace();
		}
	}

}
