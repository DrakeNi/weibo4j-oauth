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


public class TimeLine {
	
	private String uid;
	
	public void Setuid(String uid){
		this.uid = uid;
	}
	
	public void GetTimeLine(){
		String StorageFile = "Timeline.txt";
		UserLogin login = new UserLogin();
		login.SetUid("testni2012_1@163.com");
		login.SetPasswd("12345qwert");
		login.SetClientId("3948386404");
		login.SetClientSecret("5c6a6eb1aa48fab31a2a439e253b66ed");
		String access_token = (login.GetToken()).getAccessToken();
		
		Timeline tm = new Timeline();
		tm.client.setToken(access_token);
		FileOp fobj = new FileOp();
		fobj.SetFname(StorageFile);
		
		try{
			Paging page = new Paging();
			page.setPage(1);
			page.setCount(100);
			StatusWapper status = tm.getUserTimelineByUid(this.uid);
			List<Status> list =status.getStatuses();
			Status cstatus = list.get(0);
			User cuser = cstatus.getUser();
			String cuid = cuser.getId();
			
			long ltotal = status.getTotalNumber();
			long m = ltotal/100 +1;
			int j = 1;
			
			for(long i =0; i<m;i++){
				page.setPage(j);
				StatusWapper statusn = tm.getUserTimelineByUid(this.uid, page,0,0);
				for(Status s : statusn.getStatuses()){
					fobj.WriteByLine(s.toString());
					System.out.println("-----"+ s.getText() + "------");
					System.out.println(s.getUser().getStatusesCount());
					System.out.println();
					//count++;
				}
				j++;
				
			}
			
		}catch(WeiboException e){
			e.printStackTrace();
		}
	}

}
