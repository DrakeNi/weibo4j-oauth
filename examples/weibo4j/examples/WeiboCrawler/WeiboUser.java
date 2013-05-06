package weibo4j.examples.WeiboCrawler;

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
	
	public void setUid(String uid){
		this.uid = uid;
	}
	
	public String getUid(){
		return this.uid;
	}
	
	
	public void setFollowing(int following){
		this.following = following;
	}
	
	public int getFollowing(){
		return this.following;
	}
	
	/*public void Setcolor(Color color){
		this.color = color;
	}
	
	Color Getcolor(){
		return this.color;
	} */
	
	
	public void setDepth(int depth){
		this.depth = depth;
	}
	
	public int getDepth(){
		return this.depth;
	}
	
}
