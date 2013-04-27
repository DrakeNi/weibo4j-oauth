package weibo4j.examples.friendships;

import weibo4j.Friendships;
import weibo4j.examples.oauth2.Log;
import weibo4j.examples.MyCrawler.FileOp;
import weibo4j.examples.MyCrawler.UserLogin;
import weibo4j.model.User;
import weibo4j.model.UserWapper;
import weibo4j.model.WeiboException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GetFriendsByName {

	public static void main(String[] args) {
		//String access_token = args[0];
		//String name = args[1];
		
		String StorageFile = "MyFriendsIds.txt";
		
		UserLogin login = new UserLogin();
		login.SetUid("testni2012_1@163.com");
		login.SetPasswd("12345qwert");
		login.SetClientId("3948386404");
		String access_token = (login.GetToken()).getAccessToken();
		
		Friendships fm = new Friendships();
		fm.client.setToken(access_token);
		
		FileOp fobj = new FileOp();
		fobj.SetFname(StorageFile);
		
		try {
			
			Set uset = new HashSet();
			List<String> luser = new ArrayList<String>();
			
			UserWapper users = fm.getFriendsByID("1793676782");
			//String[] users = fm.getFriendsIdsByUid("1793676782", 50, 50);
			long ltotal = users.getTotalNumber();
			long m = ltotal/5000 +1;
			int count = 0;
			int j = 0;
			
			for(long i=0; i<m; i++){
				String[] susers = fm.getFriendsIdsByUid("1793676782", 5000, j*5000);
				j++;
				
			   for(String u : susers){
				//System.out.println(u.toString());
				fobj.WriteByLine(u.toString());
				
				
				luser.add(u);
				uset.add(u);
				count++;
			    }
		       }
			  System.out.println(m);
			  System.out.println(luser.size());
			  System.out.println(uset.size());
			  System.out.println(count);
			  //System.out.println(users.getNextCursor());
			  //System.out.println(users.getPreviousCursor());
			  System.out.println(users.getTotalNumber());
			  System.out.println(ltotal/20);
			
		    }catch (WeiboException e) {
			   e.printStackTrace();
		    }

	}

}
