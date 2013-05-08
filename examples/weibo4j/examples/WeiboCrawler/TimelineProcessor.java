package weibo4j.examples.WeiboCrawler;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import weibo4j.Account;
import weibo4j.Timeline;
import weibo4j.Users;
import weibo4j.http.AccessToken;
import weibo4j.model.Paging;
import weibo4j.model.RateLimitStatus;
import weibo4j.model.Status;
import weibo4j.model.StatusWapper;
import weibo4j.model.User;
import weibo4j.model.WeiboException;

public class TimelineProcessor {
	
	public static void getTimeline(String uid, TokenScheduler ts ) throws WeiboException, IOException{
		AccessToken access_token = ts.getCurrentAccessToken();
		while(AccessTokenChecker.isEmpty(access_token)||(!AccessTokenChecker.isRemainingHits(access_token))){
			access_token = ts.getNextAccessToken(); 
		}
		//String storageFolder = System.getProperty("user.dir")+System.getProperty("file.separator")+"crawlerdata";
		String fname =uid + "_timeline.txt";
		BufferedWriter bw = new BufferedWriter(new FileWriter(fname, true));
		
		Paging page = new Paging();
		page.setPage(1);
	    page.setCount(100);
	    Timeline tm = new Timeline();
		tm.client.setToken(access_token.getAccessToken());
		StatusWapper status = tm.getUserTimelineByUid(uid);
		List<Status> list =status.getStatuses();
		Iterator<Status> iter = list.iterator();
		if((!iter.hasNext())||status.getTotalNumber()==0){
			
			// handle the user who has no timeline, record the user's information
			System.out.println(status.getTotalNumber());
			System.out.println("There is no timeline or The number of timeline is zero !");
			AccessToken tempat = ts.getCurrentAccessToken();
			while(AccessTokenChecker.isEmpty(tempat)||(!AccessTokenChecker.isRemainingHits(tempat))){
				tempat = ts.getNextAccessToken();
			}
			Users um = new Users();
			String userinfo;
			um.client.setToken(tempat.getAccessToken());
			try{
			User user = um.showUserById(uid);
			bw.write(user.toString());
			bw.flush();
			bw.close();
			return;
			
			}catch(WeiboException e){
				System.out.println(e.getErrorCode());
				System.out.println(e.getError());
				System.out.println(e.getStatusCode());
				if(e.getErrorCode()==20003){
					System.out.println("User " + uid + " has been deleted!");
				}
				
				bw.write(uid);
				bw.flush();
				bw.close();
				return;
			}
			
			
			/*System.out.println(user.toString());
			bw.write(user.toString());
			bw.flush();
			bw.close();
			return;*/
		}
		
		//System.out.println(status.getTotalNumber());
		
		
	    //List<Status> list =status.getStatuses();
	    //Iterator<Status> iter = list.iterator();
	    /*if(!iter.hasNext()){
	    	System.out.println("fail to read timeline!");
	    	return;
	    }*/
		//Status cstatus = list.get(0);
	    Status cstatus = iter.next();
		User cuser = cstatus.getUser();
		bw.write(cuser.toString());
		bw.newLine();
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
				
				bw.write(s.toStatusString());
				bw.newLine();
				System.out.println("-----"+ s.getText() + "------");
			}
			j++;
			
		}
		bw.flush();
		bw.close();
		
		
		
	}

}
