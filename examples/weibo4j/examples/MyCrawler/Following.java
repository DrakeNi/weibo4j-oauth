package weibo4j.examples.MyCrawler;

import java.util.ArrayList;
import java.util.List;

import weibo4j.Friendships;
import weibo4j.model.WeiboException;

public class Following {
	
	private String uid;
	public void Setuid(String uid){
		this.uid = uid;
	}
	
	
	
	List<String> Getfollowing(){
		
		List<String> fuids = new ArrayList<String>();
		UserLogin login = new UserLogin();
		login.SetUid("testni2012_1@163.com");
		login.SetPasswd("12345qwert");
		login.SetClientId("3948386404");
		login.SetClientSecret("5c6a6eb1aa48fab31a2a439e253b66ed");
		String access_token = (login.GetToken()).getAccessToken();
		Friendships fm = new Friendships();
		fm.client.setToken(access_token);
		
		try{
			
			String[] users = fm.getFriendsIdsByUid(this.uid);
			int cursors = users.length/5000 + 1;
			for(int i=0;i<cursors;i++){
				String[] temps = fm.getFriendsIdsByUid(this.uid, 5000, i*cursors);
				for(String u : temps){
					fuids.add(u);
				}
			}
		}catch(WeiboException e){
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
		return fuids;
		
	}
	

}
