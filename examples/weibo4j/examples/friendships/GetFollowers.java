package weibo4j.examples.friendships;

import weibo4j.Friendships;
import weibo4j.examples.oauth2.Log;
import weibo4j.model.User;
import weibo4j.model.UserWapper;
import weibo4j.model.WeiboException;

public class GetFollowers {

	public static void main(String[] args) {
		String access_token ="2.00gQF5xBgfBN_Ea0b9d10674xYXjdE";
		Friendships fm = new Friendships();
		fm.client.setToken(access_token);
		String screen_name ="Xudongni";
		try {
			UserWapper users = fm.getFollowersByName(screen_name);
			for(User u : users.getUsers()){
				Log.logInfo(u.toString());
			}
			System.out.println(users.getNextCursor());
			System.out.println(users.getPreviousCursor());
			System.out.println(users.getTotalNumber());
		} catch (WeiboException e) {
			e.printStackTrace();
		}
	}

}
