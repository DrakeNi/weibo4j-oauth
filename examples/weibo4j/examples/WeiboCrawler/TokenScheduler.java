package weibo4j.examples.WeiboCrawler;

import java.util.ArrayList;
import java.util.List;

import weibo4j.http.AccessToken;

public class TokenScheduler {
	
	private int appRlimit;
	private int userRlimit;
	private int NumofApp;
	private int NumofUser;
	private long timeInterval;
	
	private ArrayList<AccessToken> atArray = new ArrayList(); 
	private AccessToken current;
	
	//AccessTokey Array
	//private ArrayList appArray = new ArrayList();
	//private ArrayList userArray = new ArrayList();
	//private ArrayList actokenArray = new ArrayList();
	public TokenScheduler(int rm, int rn, int m, int n, long ti, ArrayList<AccessToken> al){
		this.appRlimit = rm;
		this.userRlimit = rn;
		this.NumofApp = m;
		this.NumofUser = n;
		this.timeInterval = ti;
		atArray = al;
		for(int i=0; i<atArray.size();i++){
			if(atArray.get(i)!=null){
				this.current = atArray.get(i);
				break;
			}
		}
	}
    
	public AccessToken getAccessToken(){
		
		int cidx = atArray.indexOf(current);
		AccessToken temp;
		
		for(int i=cidx; i<atArray.size();i++){
			if(atArray.get(i)!=null){
				temp = atArray.get(i);
				if(cidx==atArray.size()-1){
					ReSetToken();
					return atArray.get(atArray.size()-1);
				}
				current = atArray.get(i+1);
				return temp;
			}
		}
		return null;
		//return temp;
		
	}
	
	public AccessToken ReSetToken(){
		
	     ;
	     
	     
		
		
		
		
		
		
	}
	
	

}
