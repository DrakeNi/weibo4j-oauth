package weibo4j.examples.WeiboCrawler;

import java.util.ArrayList;
import java.util.List;

import weibo4j.Friendships;
import weibo4j.http.AccessToken;
import weibo4j.model.WeiboException;

public class FollowingProcessor {
	
	public static List<String> getFollowing(String uid, TokenScheduler ts) throws WeiboException{
		
		List<String> fuids = new ArrayList<String>();
		
		AccessToken access_token = ts.getCurrentAccessToken();
		while(AccessTokenChecker.isEmpty(access_token)||(!AccessTokenChecker.isRemainingHits(access_token))){
			access_token = ts.getNextAccessToken(); 
		}
		Friendships fm = new Friendships();
		fm.client.setToken(access_token.getAccessToken());
		
		String[] users = fm.getFriendsIdsByUid(uid);
		int cursors = users.length/5000 + 1;
		for(int i=0;i<cursors;i++){
			Friendships fm1 = new Friendships();
			AccessToken access_token_temp = ts.getCurrentAccessToken();
			while(AccessTokenChecker.isEmpty(access_token_temp)||(!AccessTokenChecker.isRemainingHits(access_token_temp))){
				access_token_temp = ts.getNextAccessToken(); 
			}
			fm1.client.setToken(access_token_temp.getAccessToken());
			String[] temps = fm1.getFriendsIdsByUid(uid);
			for(String s : temps){
				fuids.add(s);
			}
		}
		return fuids;
		
	}

}
