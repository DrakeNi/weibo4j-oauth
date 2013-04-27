package weibo4j.examples.friendships;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import weibo4j.Friendships;
import weibo4j.examples.oauth2.Log;
import weibo4j.model.User;
import weibo4j.model.UserWapper;
import weibo4j.model.WeiboException;
import weibo4j.examples.MyCrawler.*;

public class GetFollowersById {

	public static void main(String[] args) {
		//String access_token = args[0];
		//String uid = args[1];
		
		
		String StorageFile = "MyWeibo.txt";
		
		UserLogin login = new UserLogin();
		login.SetUid("testni2012_1@163.com");
		login.SetPasswd("12345qwert");
		login.SetClientId("3948386404");
		//login.GetToken();
		String access_token = (login.GetToken()).getAccessToken();
		
		Friendships fm = new Friendships();
		fm.client.setToken(access_token);
		FileOp fobj = new FileOp();
		fobj.SetFname(StorageFile);
		
		
		try {
			Set uset = new HashSet();
			List<User> luser = new ArrayList<User>();
			UserWapper users = fm.getFollowersById("1793676782",50,50);
			long ltotal = users.getTotalNumber(); 
			//System.out.println()
			long m = ltotal/20+1;
			int count =0;
			int j =0;
			
			for(long i=0; i<m;i++){
				UserWapper susers = fm.getFollowersById("1793676782", 20, j*20);
				j++;
				
				for(User u : susers.getUsers()){
					//Log.logInfo(u.toString());
					System.out.println(u.toString());
					fobj.WriteByLine(u.toString());
					luser.add(u);
					uset.add(u);
					count++;
				}
			}
			/*for(User u : users.getUsers()){
				Log.logInfo(u.toString());
			}*/
			System.out.println(m);
			System.out.println(luser.size());
			System.out.println(uset.size());
			System.out.println(count);
			System.out.println(users.getNextCursor());
			System.out.println(users.getPreviousCursor());
			System.out.println(users.getTotalNumber());
			System.out.println(ltotal/20);
		} catch (WeiboException e) {
			e.printStackTrace();
		}

	}

}
