package weibo4j.examples.WeiboCrawler;

import java.util.List;

import weibo4j.Account;
import weibo4j.Timeline;
import weibo4j.http.AccessToken;
import weibo4j.model.Paging;
import weibo4j.model.RateLimitStatus;
import weibo4j.model.Status;
import weibo4j.model.StatusWapper;
import weibo4j.model.User;
import weibo4j.model.WeiboException;

public class TimelineProcessor {
	
	public static void getTimeline(String uid, TokenScheduler ts ) throws WeiboException{
		AccessToken access_token = ts.getCurrentAccessToken();
		while(AccessTokenChecker.isEmpty(access_token)||(!AccessTokenChecker.isRemainingHits(access_token))){
			access_token = ts.getNextAccessToken(); 
		}
		Paging page = new Paging();
		page.setPage(1);
	    page.setCount(100);
	    Timeline tm = new Timeline();
		tm.client.setToken(access_token.getAccessToken());
		StatusWapper status = tm.getUserTimelineByUid(uid);
		if(status.getTotalNumber()==0){
			System.out.println(status.getTotalNumber());
			System.out.println("There is no timeline!");
			return;
		}
		
		//System.out.println(status.getTotalNumber());
	    List<Status> list =status.getStatuses();
		Status cstatus = list.get(0);
		User cuser = cstatus.getUser();
		String cuid = cuser.getId();
	    long ltotal = status.getTotalNumber();
		long m = ltotal/100 +1;
		int j = 1;
		for(long i=0; i<m; i++){
			page.setPage(j);
			AccessToken access_token_temp = ts.getCurrentAccessToken();
			while(AccessTokenChecker.isEmpty(access_token_temp)||(!AccessTokenChecker.isRemainingHits(access_token_temp))){
				access_token_temp = ts.getNextAccessToken();
			}
			Timeline tm1 = new Timeline();
			tm1.setToken(access_token_temp.getAccessToken());
			StatusWapper status1 = tm1.getUserTimelineByUid(uid, page,0,0);
			for(Status s : status1.getStatuses()){
				//fobj.WriteByLine(s.toString());
				System.out.println("-----"+ s.getText() + "------");
			}
			j++;
			
		}
		
		
		
	}

}
