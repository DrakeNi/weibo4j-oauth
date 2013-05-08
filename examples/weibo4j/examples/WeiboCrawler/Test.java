package weibo4j.examples.WeiboCrawler;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

//import weibo4j.examples.MyCrawler.WeiboProcessing;
//import weibo4j.examples.MyCrawler.WeiboUser;
import weibo4j.examples.WeiboCrawler.App;
import weibo4j.examples.WeiboCrawler.AppUser;
import weibo4j.http.AccessToken;
import weibo4j.model.WeiboException;

public class Test {

	/**
	 * @param args
	 * @throws IOException 
	 */
	
	
	public static void main(String[] args){
		// TODO Auto-generated method stub
		
		
		AppUser[] userpool = new AppUser[7];
		//userpool[0] = new AppUser("shiwei072@hotmail.com", "0627401072");
		userpool[1] = new AppUser("glwu_1027@sina.com", "wgl_1027");
		userpool[0] = new AppUser("xushun007@163.com", "19871211");
		//userpool[1] = new AppUser("xushun007@163.com", "19871211");
		userpool[2] = new AppUser("sw072@sina.com", "626105826");
		userpool[3] = new AppUser("sw072@qq.com", "0627401072");
		userpool[4] = new AppUser("shiwei072@qq.com", "0627401072");
		userpool[5] = new AppUser("shiwei072@163.com", "0627401072");
		//userpool[6] = new AppUser("glwu_1027@sina.com", "wgl_1027");
		
		userpool[6] = new AppUser("shiwei072@hotmail.com", "0627401072");
		
		App[] apppool = new App[30];
		apppool[0] = new App("3464070480", "a00cf7dee38a6eba734f5db043ac5577", "http://shiwei072.weibo.com/callback");
	    apppool[1] = new App("1839397649", "1941ac2ea412a5cfa042744416d1c7ce", "http://shiwei072.weibo.com/callback");
	    apppool[2] = new App("1514022179", "8f80e67a2508773d3561a20e8d742c62", "http://shiwei072.weibo.com/callback");
	    apppool[3] = new App("891709287", "104cf9ad7dae7481680adbf4da9cfddf", "http://shiwei072.weibo.com/callback");
	    apppool[4] = new App("1293764891", "240d96fa09f587fd8c61259e616a367e", "http://shiwei072.weibo.com/callback");
	    apppool[5] = new App("1423577858", "d567587e5540a88cc6d6ff329a34242c", "http://shiwei072.weibo.com/callback");
	    apppool[6] = new App("3622590978", "9c56bb1b9aee20ff417d00dc409a325b", "http://shiwei072.weibo.com/callback");
	    apppool[7] = new App("2380047577", "9d18060b4bc18b40e02a404073f2523f", "http://shiwei072.weibo.com/callback");
	    apppool[8] = new App("3940805556", "276bc83d08907dfc793bb1ea290a94e1", "http://shiwei072.weibo.com/callback");
	    apppool[9] = new App("1305366389", "22e95353d3bc67558dada9b3b98c844f", "http://shiwei072.weibo.com/callback");
	    apppool[10] = new App("1611904274", "c301ef0b87aec31d47eab5ce04e21251", "http://shiwei072.weibo.com/callback");
	    apppool[11] = new App("311684636", "66d0350e8bbc2900efbf81ad3cad1e31", "http://shiwei072.weibo.com/callback");
	    apppool[12] = new App("2018303502", "1e1b555a4c73ca43969994121dc2e3db", "http://shiwei072.weibo.com/callback");
	    apppool[13] = new App("777429791", "2badbc671cca5eb851fcd1a83ad1f08e", "http://shiwei072.weibo.com/callback");
	    apppool[14] = new App("1892378734", "acf4d8e15e010e4ffefb4ecdfdae5180", "http://shiwei072.weibo.com/callback");
        apppool[15] = new App("2927517534", "53e0b6561333ee2064950618082165f7", "http://shiwei072.weibo.com/callback");
        apppool[16] = new App("1653696056", "af4d760c89c172cdedf547662b9bbc1e", "http://shiwei072.weibo.com/callback");
	    apppool[17] = new App("3506191689", "8c2289a080bd57b4f4ab6db314164fea", "http://shiwei072.weibo.com/callback");
	    apppool[18] = new App("3707212747", "97d941305f86c1b401e8dd5acbc40abe", "http://shiwei072.weibo.com/callback");
	    apppool[19] = new App("3572993456", "58d5fa5175af696d4e2ee5c94321f3bf", "http://shiwei072.weibo.com/callback");
	    apppool[20] = new App("3618166185", "34c35237f16f6b918f48faeaaa5ffd1b", "http://shiwei072.weibo.com/callback");
	    apppool[21] = new App("487777658", "8a3952e50d1f1e704b6ca0970619379f", "http://shiwei072.weibo.com/callback");
	    apppool[22] = new App("2682307911", "c00ee1fb826a3d4ec2f3ca6b61467aa8", "http://shiwei072.weibo.com/callback");
	    apppool[23] = new App("4186041441", "dc08775385fcf5c5793c57ca5546390e", "http://shiwei072.weibo.com/callback");
	    apppool[24] = new App("2273640796", "facd338e5807b1f069a29795329d549d", "http://shiwei072.weibo.com/callback");
	    apppool[25] = new App("2166845988", "c11b5411efc8881f1f7a4d40b9d66686", "http://shiwei072.weibo.com/callback");
	    apppool[26] = new App("680940983", "259c46814a32f6299e0c3fed91469acb", "http://shiwei072.weibo.com/callback");
	    apppool[27] = new App("192889470", "3a1bea3d88cad0db0f153f36604b55e3", "http://shiwei072.weibo.com/callback");
	    apppool[28] = new App("1316448426", "264093741cf5e52abea1315fc7563ae2", "http://shiwei072.weibo.com/callback");
	    apppool[29] = new App("3388800590", "b697aa0b08fdc89be1e79c9d32b109c2", "http://shiwei072.weibo.com/callback");
	    
	    String app_redir_url = "http://shiwei072.weibo.com/callback";
	    
	    ArrayList<App> apps = new ArrayList<App>(30);
	    for(int i=0; i<30; i++){
	    	apps.add(apppool[i]);
	    }
	    
	    ArrayList<AppUser> appusers= new ArrayList<AppUser>(7);
	    for(int i=0; i<7; i++){
	    	appusers.add(userpool[i]);
	    }
        
	    TokenScheduler token_scheduler = new TokenScheduler(1000,150,30,7,1000*60*60);
	    token_scheduler.setApps(apps);
	    token_scheduler.setAppUsers(appusers);
	    token_scheduler.printApp();
	    token_scheduler.setAccessTokens();
	    token_scheduler.printAcesstoken();
	    
	    try{
	    ArrayList<String> uids = new ArrayList<String>();
	    
	    //String fname ="uids_1_100.txt";
	    String fname = "nouser.txt";
	    //String fname = "test1.txt";
	    //FileReader reader = new FileReader(fname);
	    BufferedReader br = new BufferedReader(new FileReader(fname));
	    String str = null;
	    int count = 0;
	    while((str = br.readLine())!=null){
	    	uids.add(str.trim());
	    	System.out.println("reading uids: " + str.trim());
	    	count++;
	    }
	    br.close();
	    System.out.println("Successfully read line " + count + " uids");
	    
	    Iterator<String> iter = uids.iterator();
	    while(iter.hasNext()){
	    	String u = iter.next();
	    	TimelineProcessor.getTimeline(u, token_scheduler);
	    	FollowingProcessor.getFollowing(u, token_scheduler);	
	    	System.out.println("Done!");
	    }
	    
	    
	    /*int MaxDepth = 1;
		String seed="3069695371";
		WeiboUser iuser = new WeiboUser(seed, 0);
		try{
		if(MaxDepth == -1){
	    	Queue<WeiboUser> queue = new LinkedList<WeiboUser>();
	    	queue.offer(iuser);
	    	
	    	while(!(queue.isEmpty())){
	    		String u = queue.poll().getUid();
	    		//WeiboProcessing wp = new WeiboProcessing();
	    		//wp.Setuid(u);
	    		//wp.GetTimeLine(userpool, apppool);
	    
				TimelineProcessor.getTimeline(u, token_scheduler);
				
				for(String uid : FollowingProcessor.getFollowing(u, token_scheduler)){
					WeiboUser tempuser = new WeiboUser(uid, -1);
					queue.offer(tempuser);
				}
			}
	    	
	    }else{
	    	if(MaxDepth ==0)
	    	{
	    		
	    		//WeiboProcessing wp = new WeiboProcessing();
	    		//wp.Setuid(iuser.Getuid());
	    		//wp.GetTimeLine(userpool, apppool);
	    		//wp.Getfollowing(userpool, apppool);
	    		TimelineProcessor.getTimeline(iuser.getUid(), token_scheduler);
	    		FollowingProcessor.getFollowing(iuser.getUid(), token_scheduler);
	    		System.out.println("Crawling done!");
	    		return;
	    	}
	    	
	    	Queue<WeiboUser> queue = new LinkedList<WeiboUser>();
	    	queue.offer(iuser);
	    	int level = 0;
	    	while((!queue.isEmpty())){
	    		WeiboUser wuser = queue.poll();
	    		if(wuser.getDepth()>MaxDepth){
	    			break;
	    		}
	    		String u = wuser.getUid();
	    		//WeiboProcessing wp = new WeiboProcessing();
	    		//wp.Setuid(u);
	    		//wp.GetTimeLine(userpool, apppool);
	    		
				TimelineProcessor.getTimeline(u, token_scheduler);
				
	    		
	    		for(String uid : FollowingProcessor.getFollowing(u, token_scheduler)){
	    			WeiboUser tempuser = new WeiboUser(uid, level+1);
	    			queue.offer(tempuser);
	    		}
	    		level++;
	    		
	    	}
	    	System.out.println(" level " + level + " crawling is done!");*/
	    	
		}
		catch (WeiboException e)
		{
			e.printStackTrace();
		}
	    catch(FileNotFoundException e){
	    	e.printStackTrace();
	    }
		catch(IOException e){
			e.printStackTrace();
		}
	    
		
	    
	}

}
