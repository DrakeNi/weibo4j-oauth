package weibo4j.examples.WeiboCrawler;

import weibo4j.Account;
import weibo4j.http.AccessToken;
import weibo4j.model.RateLimitStatus;
import weibo4j.model.WeiboException;

public class AccessTokenChecker {

	public static boolean isEmpty(AccessToken at){
		if(at==null) return true;
		else return false;
	}
	
	public static boolean isRemainingHits(AccessToken at) throws WeiboException{
		// No null input 
		Account am = new Account();
		am.setToken(at.getAccessToken());
		RateLimitStatus rlimit;
		
		rlimit = am.getAccountRateLimitStatus();
		int RemainingIpHits = rlimit.getRemainingIpHits();
		long RemainingUserHits = rlimit.getRemainingUserHits();
	    if((RemainingIpHits>0)&&(RemainingUserHits>0)){
	        System.out.println(at.getAccessToken().toString() + " has RemainingIpHits " + RemainingIpHits + "  has RemainingUserHits " + RemainingUserHits);
		    return true;
		    }
	    
	    else {
	    	
	    	System.out.println(at.getAccessToken().toString() + " has RemainingIpHits " + RemainingIpHits + "  has RemainingUserHits " + RemainingUserHits);
	    	return false;
	    }
		
		
		
	}
}
