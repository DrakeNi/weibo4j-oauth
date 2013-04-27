package weibo4j.examples.account;

import weibo4j.Account;
import weibo4j.examples.MyCrawler.UserLogin;
import weibo4j.examples.oauth2.Log;
import weibo4j.model.RateLimitStatus;
import weibo4j.model.WeiboException;

public class GetAccountRateLimitStatus {

	public static void main(String[] args) {
		//String access_token =args[0];
		
		UserLogin login = new UserLogin();
		login.SetUid("testni2012_1@163.com");
		login.SetPasswd("12345qwert");
		login.SetClientId("3948386404");
		login.SetClientSecret("5c6a6eb1aa48fab31a2a439e253b66ed");
		String access_token = (login.GetToken()).getAccessToken();
		
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
