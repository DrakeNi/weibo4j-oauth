/**
 * 
 */
package weibo4j.examples.MyCrawler;

/**
 * @author nxd
 *
 */

import java.util.Queue;
import java.util.LinkedList;

public class WeiboCrawler {

	/**
	 * @param args
	 */
	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		int MaxDepth = 3;
		String seed="1793676782";
		
		WeiboUser iuser = new WeiboUser(seed, 0);
		
	    if(MaxDepth == -1){
	    	Queue<WeiboUser> queue = new LinkedList<WeiboUser>();
	    	queue.offer(iuser);
	    	
	    	while(!(queue.isEmpty())){
	    		String u = queue.poll().Getuid();
	    		TimeLine t = new TimeLine();
	    		Following uf = new Following();
	    		t.Setuid(u);
	    		uf.Setuid(u);
	    		t.GetTimeLine();
	    		for(String uid : uf.Getfollowing()){
	    			WeiboUser tempuser = new WeiboUser(uid, -1);
	    			queue.offer(tempuser);
	    		}
	    		
	    		
	    	}
	    	
	    }else{
	    	
	    	if(MaxDepth ==0)
	    	{
	    		TimeLine t = new TimeLine();
	    		Following uf = new Following();
	    		t.Setuid(iuser.Getuid());
	    		uf.Setuid(iuser.Getuid());
	    		t.GetTimeLine();
	    		uf.Getfollowing();
	    		return;
	    	}
	    	
	    	Queue<WeiboUser> queue = new LinkedList<WeiboUser>();
	    	queue.offer(iuser);
	    	int level = 0;
	    	while((!queue.isEmpty())){
	    		WeiboUser wuser = queue.poll();
	    		if(wuser.Getdepth()>MaxDepth){
	    			break;
	    		}
	    		String u = wuser.Getuid();
	    		TimeLine t = new TimeLine();
	    		Following uf = new Following();
	    		t.Setuid(u);
	    		uf.Setuid(u);
	    		t.GetTimeLine();
	    		for(String uid : uf.Getfollowing()){
	    			WeiboUser tempuser = new WeiboUser(uid, level+1);
	    			queue.offer(tempuser);
	    		}
	    		level++;
	    		
	    	}
	    	
	    }
		

	}*/

}
