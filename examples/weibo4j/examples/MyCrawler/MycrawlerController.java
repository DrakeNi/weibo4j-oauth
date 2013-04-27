package weibo4j.examples.MyCrawler;


import java.util.ArrayList;
import java.util.List;

import weibo4j.Account;
import weibo4j.Timeline;
import weibo4j.examples.oauth2.Log;
import weibo4j.model.Paging;
import weibo4j.model.RateLimitStatus;
import weibo4j.model.Status;
import weibo4j.model.StatusWapper;
import weibo4j.model.WeiboException;
import weibo4j.org.json.JSONObject;

import weibo4j.Friendships;
import weibo4j.model.User;
import weibo4j.model.UserWapper;


public class MycrawlerController {

	/**
	 * @param args
	 */
	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		
		UserLogin login = new UserLogin();
		login.SetUid("testni2012_1@163.com");
		login.SetPasswd("12345qwert");
		login.SetClientId("3948386404");
		String access_token = (login.GetToken()).getAccessToken();
		
		
		Timeline tm = new Timeline();
		tm.client.setToken(access_token);
		Friendships fm = new Friendships();
		fm.client.setToken(access_token);
		
		
		try {
			
			//List<Status> list = new ArrayList<Status>();
			Paging page = new Paging();
			page.setPage(1);
			page.setCount(100);
			//StatusWapper status = tm.getUserTimelineByName("kingofKorea", page, 0, 0);
			//StatusWapper status = tm.getUserTimelineByName("kingofkorea", page,0,0);
			StatusWapper status = tm.getUserTimelineByName("百度技术沙龙");
			//StatusWapper status = tm.getUserTimelineByUid("1751151042");
			List<Status> list =status.getStatuses();
			Status cstatus = list.get(0);
			User cuser = cstatus.getUser();
			String cuid = cuser.getId();
			int followings = cuser.getFriendsCount();
			
			List<String> luids = new ArrayList<String>();
			
			int cursors = followings/5000 +1;
			for(int i=0; i<cursors;i++){
				String[] users = fm.getFriendsIdsByUid(cuid,5000,i*cursors);
				int usize = users.length;
				System.out.println(usize);
				for(int j=0; j<usize;j++){
					luids.add(users[j]);
				}
			}
			
			int ucount =0;
			for(String tuid : luids){
				System.out.println(tuid);
				ucount++;
				
			}
			
			System.out.println(cursors);
			System.out.println(followings);
			System.out.println(ucount);
			//fm.getFriendsIdsByUid(cuid, 500, 1);
			
			
			
			long ltotal = status.getTotalNumber();
			//int total = ltotal.intValue();
			
			
			
			long m = ltotal/100+1;
			
			int count =0;
			int j =1;
			
			for(long i=0; i<m;i++){
				
				page.setPage(j);
				StatusWapper statusn = tm.getUserTimelineByName("百度技术沙龙", page,0,0);
				for(Status s : statusn.getStatuses()){
					System.out.println("-----"+ s.getText() + "------");
					System.out.println(s.getUser().getStatusesCount());
					System.out.println();
					count++;
				}
				j++;
				
				
				
			}
			
			System.out.println(m);
			System.out.println(count);
			//System.out.println(c);
			System.out.println(cstatus.getUser().getName());
			System.out.println(ltotal);
			
			
			
			
			for(Status s : status.getStatuses()){
				//Log.logInfo(s.toString());
				System.out.println(s.toString());
				i++;
			}
			
			//System.out.println(status.getTotalNumber());
			//System.out.println(status.)
			
			
			UserWapper users = fm.getFriendsByScreenName("kingfokorea");
			
			for(User u : users.getUsers())
			{
				System.out.println(u.toString());
			}
			System.out.println(users.getNextCursor());
			System.out.println(users.getPreviousCursor());
			System.out.println(users.getTotalNumber());
			
			//Log.logInfo(status.toString());
		} catch (WeiboException e) {
			e.printStackTrace();
		}
		
		Account am = new Account();
		am.client.setToken((login.GetToken()).getAccessToken());
		try {
            RateLimitStatus json = am.getAccountRateLimitStatus();
			Log.logInfo(json.toString());
		} catch (WeiboException e) {
			e.printStackTrace();
		}

	}*/

}
