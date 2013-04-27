package weibo4j.examples.friendships;

import weibo4j.Friendships;
import weibo4j.model.User;
import weibo4j.model.UserWapper;
import weibo4j.model.WeiboException;
import weibo4j.examples.MyCrawler.*;


public class GetFriendsByID {

	public static void main(String[] args) {
		//String access_token = args[0];
		//String id = args[1];
		
		UserLogin login = new UserLogin();
		login.SetUid("testni2012_1@163.com");
		login.SetPasswd("12345qwert");
		login.SetClientId("3948386404");
		String access_token = (login.GetToken()).getAccessToken();
		
		Friendships fm = new Friendships();
		fm.client.setToken(access_token);
		try {
			UserWapper users = fm.getFriendsByID("1793676782");
			for(User u : users.getUsers()){
				System.out.println(u.toString());
			}
			System.out.println(users.getNextCursor());
			System.out.println(users.getPreviousCursor());
			System.out.println(users.getTotalNumber());
		} catch (WeiboException e) {
			e.printStackTrace();
		}

	}

}
