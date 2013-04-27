/**
 * 
 */
package weibo4j.examples.MyCrawler;

/**
 * @author nxd
 *
 */
public class WeiboUser {
	
	private String uid;
	private int following;
	//private Color color;
	private int depth;
	
	public WeiboUser(String uid, int depth){
		this.uid = uid;
		this.following = 0;
		//this.color = Color.White;
		this.depth = depth;
		
	}
	
	public void Setuid(String uid){
		this.uid = uid;
	}
	
	public String Getuid(){
		return this.uid;
	}
	
	
	public void Setfollowing(int following){
		this.following = following;
	}
	
	public int Getfollowing(){
		return this.following;
	}
	
	/*public void Setcolor(Color color){
		this.color = color;
	}
	
	Color Getcolor(){
		return this.color;
	} */
	
	
	public void Setdepth(int depth){
		this.depth = depth;
	}
	
	int Getdepth(){
		return this.depth;
	}
}
