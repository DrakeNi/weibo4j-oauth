package weibo4j.examples.MyCrawler;

import java.util.ArrayList;
import java.util.List;

import weibo4j.Account;
import weibo4j.Timeline;
import weibo4j.examples.oauth2.Log;
import weibo4j.http.AccessToken;
import weibo4j.model.Paging;
import weibo4j.model.RateLimitStatus;
import weibo4j.model.Status;
import weibo4j.model.StatusWapper;
import weibo4j.model.WeiboException;
import weibo4j.org.json.JSONObject;

import weibo4j.Friendships;
import weibo4j.model.User;
import weibo4j.model.UserWapper;

public class WeiboProcessing {
	
	private String uid;
	public static int count = 1;
	
	public void Setuid(String uid){
		this.uid = uid;
	}
	
	/*public void init(){
		 UserInfo[] userpool = new UserInfo[7];
		 userpool[0] = new UserInfo("shiwei072@hotmail.com", "0627401072");
		 userpool[1] = new UserInfo("xushun007@163.com", "19871211");
		 userpool[2] = new UserInfo("sw072@sina.com", "626105826");
		 userpool[3] = new UserInfo("sw072@qq.com", "0627401072");
		 userpool[4] = new UserInfo("shiwei072@qq.com", "0627401072");
		 userpool[5] = new UserInfo("shiwei072@163.com", "0627401072");
		 userpool[6] = new UserInfo("glwu_1027@sina.com", "wgl_1027");
		
		 App[] apppool = new App[30];
		 apppool[0] = new App("3464070480", "a00cf7dee38a6eba734f5db043ac5577");
	     apppool[1] = new App("1839397649", "1941ac2ea412a5cfa042744416d1c7ce");
	     apppool[2] = new App("1514022179", "8f80e67a2508773d3561a20e8d742c62");
	     apppool[3] = new App("891709287", "104cf9ad7dae7481680adbf4da9cfddf");
	     apppool[4] = new App("1293764891", "240d96fa09f587fd8c61259e616a367e");
	     apppool[5] = new App("1423577858", "d567587e5540a88cc6d6ff329a34242c");
	     apppool[6] = new App("3622590978", "9c56bb1b9aee20ff417d00dc409a325b");
	     apppool[7] = new App("2380047577", "9d18060b4bc18b40e02a404073f2523f");
	     apppool[8] = new App("3940805556", "276bc83d08907dfc793bb1ea290a94e1");
	     apppool[9] = new App("1305366389", "22e95353d3bc67558dada9b3b98c844f");
	     apppool[10] = new App("1611904274", "c301ef0b87aec31d47eab5ce04e21251");
	     apppool[11] = new App("311684636", "66d0350e8bbc2900efbf81ad3cad1e31");
	     apppool[12] = new App("2018303502", "1e1b555a4c73ca43969994121dc2e3db");
	     apppool[13] = new App("777429791", "2badbc671cca5eb851fcd1a83ad1f08e");
	     apppool[14] = new App("1892378734", "acf4d8e15e010e4ffefb4ecdfdae5180");
	     apppool[15] = new App("2927517534", "53e0b6561333ee2064950618082165f7");
	     apppool[16] = new App("1653696056", "af4d760c89c172cdedf547662b9bbc1e");
	     apppool[17] = new App("3506191689", "8c2289a080bd57b4f4ab6db314164fea");
	     apppool[18] = new App("3707212747", "97d941305f86c1b401e8dd5acbc40abe");
	     apppool[19] = new App("3572993456", "58d5fa5175af696d4e2ee5c94321f3bf");
	     apppool[20] = new App("3618166185", "34c35237f16f6b918f48faeaaa5ffd1b");
	     apppool[21] = new App("487777658", "8a3952e50d1f1e704b6ca0970619379f");
	     apppool[22] = new App("2682307911", "c00ee1fb826a3d4ec2f3ca6b61467aa8");
	     apppool[23] = new App("4186041441", "dc08775385fcf5c5793c57ca5546390e");
	     apppool[24] = new App("2273640796", "facd338e5807b1f069a29795329d549d");
	     apppool[25] = new App("2166845988", "c11b5411efc8881f1f7a4d40b9d66686");
	     apppool[26] = new App("680940983", "259c46814a32f6299e0c3fed91469acb");
	     apppool[27] = new App("192889470", "3a1bea3d88cad0db0f153f36604b55e3");
	     apppool[28] = new App("1316448426", "264093741cf5e52abea1315fc7563ae2");
	     apppool[29] = new App("3388800590", "b697aa0b08fdc89be1e79c9d32b109c2");
	}*/
	
	public AccessToken GetToken(String uname, String passwd, String ClientId, String ClientSecret){
		
		UserLogin login = new UserLogin();
		login.SetUid(uname);
		login.SetPasswd(passwd);
		login.SetClientId(ClientId);
		login.SetClientSecret(ClientSecret);
		return login.GetToken();
		
	}
	
	public void GetTimeLine(UserInfo[] userpool, App[] apppool){
		
		
		
		
		Account am = new Account();
		String StorageFile = "Timeline.txt";
		
		Timeline tm = new Timeline();
		
		
		
		FileOp fobj = new FileOp();
		fobj.SetFname(StorageFile);
		try{
			Paging page = new Paging();
			page.setPage(1);
			page.setCount(100);
//			StatusWapper status;
			/*if(count>3000){
				
			}
			int uc = count % 1000;
			int ca = (count -1 ) /1000;
			int cu = (uc-1) /150;
			AccessToken as = GetToken(userpool[cu].GetUname(), userpool[cu].GetPassWord(), apppool[ca].GetClientId(),apppool[ca].GetClientSecret());
			String access_token = as.getAccessToken();*/
			
			
			String access_token = AssignAccessToken(this.count,userpool,apppool );
			am.setToken(access_token);
			RateLimitStatus rlimit = am.getAccountRateLimitStatus();
			System.out.println("remaining ip hits is "+ rlimit.getRemainingIpHits());
			System.out.println("remaining User hits is "+ rlimit.getRemainingUserHits());
			/*if((rlimit.getRemainingIpHits()>0)&&(rlimit.getRemainingUserHits()>0))
			{
				tm.client.setToken(access_token);
//				status = tm.getUserTimelineByUid(this.uid);
				//count++;
			}else{
				int ucurrent = count % 1000;
				int currapp = (count-1)/1000;
				int curruser = (ucurrent-1)/150;
				//UserInfo ui = new UserInfo();
				
				String naccess_token = (GetToken(userpool[curruser].GetUname(),userpool[curruser].GetPassWord(),apppool[currapp].GetClientId(),apppool[currapp].GetClientSecret())).getAccessToken();
				tm.client.setToken(naccess_token);
				
			}*/
			/*tm.client.setToken(access_token);
			StatusWapper status = tm.getUserTimelineByUid(this.uid);
			count++;*/
			tm.client.setToken(access_token);
			StatusWapper status = tm.getUserTimelineByUid(this.uid);
			this.count++;
			System.out.println(this.count);
			List<Status> list =status.getStatuses();
			Status cstatus = list.get(0);
			User cuser = cstatus.getUser();
			String cuid = cuser.getId();
			
			long ltotal = status.getTotalNumber();
			long m = ltotal/100 +1;
			int j = 1;
			
			for(long i =0; i<m;i++){
				page.setPage(j);
				String taccesstoken = AssignAccessToken(this.count,userpool,apppool );
				Timeline tm1 = new Timeline();
				tm1.setToken(taccesstoken);
				StatusWapper statusn = tm1.getUserTimelineByUid(this.uid, page,0,0);
				this.count++;
				System.out.println(this.count);
				for(Status s : statusn.getStatuses()){
					fobj.WriteByLine(s.toString());
					System.out.println("-----"+ s.getText() + "------");
					//System.out.println(s.getUser().getStatusesCount());
					//System.out.println();
					//count++;
				}
				j++;
				
			}
			
		}catch(WeiboException e){
			e.printStackTrace();
		} 
		
	}

   
	public  String AssignAccessToken(int count, UserInfo[] userpool, App[] apppool){
		
		if((count%30000)== 0){
			try {
				Thread.sleep(10*60*1000);
				this.count = 1;
				int uc = this.count % 1000;
				int ca = (this.count -1 ) /1000;
				int cu = (uc-1) /150;
				AccessToken as = GetToken(userpool[cu].GetUname(), userpool[cu].GetPassWord(), apppool[ca].GetClientId(),apppool[ca].GetClientSecret());
				return as.getAccessToken();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		int uc = count % 1000;
		int ca = (count -1 ) /1000;
		int cu = (uc-1) /150;
		System.out.println("------------ cu is " + cu);
		AccessToken as = GetToken(userpool[cu].GetUname(), userpool[cu].GetPassWord(), apppool[ca].GetClientId(),apppool[ca].GetClientSecret());
		return as.getAccessToken();
	}
	

	
	public List<String> Getfollowing(UserInfo[] userpool, App[] apppool){
		
		List<String> fuids = new ArrayList<String>();
		/*UserLogin login = new UserLogin();
		login.SetUid("testni2012_1@163.com");
		login.SetPasswd("12345qwert");
		login.SetClientId("3948386404");
		login.SetClientSecret("5c6a6eb1aa48fab31a2a439e253b66ed");*/
		String access_token = AssignAccessToken(count,userpool,apppool);
		
		//String access_token = as.getAccessToken();
		
		
		Friendships fm = new Friendships();
		fm.client.setToken(access_token);
		
		try{
			
			String[] users = fm.getFriendsIdsByUid(this.uid);
			count++;
			System.out.println(count);
			int cursors = users.length/5000 + 1;
			for(int i=0;i<cursors;i++){
				Friendships fm1 = new Friendships();
				String taccesstoken = AssignAccessToken(count,userpool,apppool);
				fm1.client.setToken(taccesstoken);
				String[] temps = fm1.getFriendsIdsByUid(this.uid, 5000, i*cursors);
				count++;
				System.out.println(count);
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
