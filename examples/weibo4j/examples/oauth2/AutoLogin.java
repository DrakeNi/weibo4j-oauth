package weibo4j.examples.oauth2;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;

import weibo4j.Oauth;
import weibo4j.http.AccessToken;
import weibo4j.model.WeiboException;
import weibo4j.util.BareBonesBrowserLaunch;


public class AutoLogin {
	
	
	/*public static AccessToken refreshToken(){ 
        Properties props = new Properties(); 
        try { 
                props.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("sina_account.properties"));
                String url = props.getProperty("url");模拟登录的地址，https://api.weibo.com/oauth2/authorize 
                PostMethod postMethod = new PostMethod(url); 
                postMethod.addParameter("client_id", props.getProperty("client_id"));//your client id 
                postMethod.addParameter("redirect_uri", props.getProperty("redirect_uri"));//your url 
                postMethod.addParameter("userId", props.getProperty("userId"));//需要获取微薄的use id 
                postMethod.addParameter("passwd", props.getProperty("passwd")); 
                postMethod.addParameter("isLoginSina", "0"); 
                postMethod.addParameter("action", "submit"); 
                postMethod.addParameter("response_type", props.getProperty("response_type"));//code 
                HttpMethodParams param = postMethod.getParams(); 
                param.setContentCharset("UTF-8"); 
                List<Header> headers = new ArrayList<Header>(); 
                headers.add(new Header("Referer", "https://api.weibo.com/oauth2/authorize?client_id=3948386404&redirect_uri=https://api.weibo.com/oauth2/default.html&from=sina&response_type=code"));//伪造referer 
                headers.add(new Header("Host", "api.weibo.com")); 
                headers.add(new Header("User-Agent", "Mozilla/5.0 (Windows NT 6.1; rv:11.0) Gecko/20100101 Firefox/11.0")); 
                HttpClient client  = new HttpClient(); 
                client.getHostConfiguration().getParams().setParameter("http.default-headers", headers); 
                client.executeMethod(postMethod); 
                int status = postMethod.getStatusCode(); 
                if(status != 302){ 
                        Log.error("refresh token failed"); 
                        return null; 
                } 
                Header location = postMethod.getResponseHeader("Location"); 
                if(location != null){ 
                        String retUrl = location.getValue(); 
                        int begin = retUrl.indexOf("code="); 
                        if(begin != -1){ 
                                int end = retUrl.indexOf("&", begin); 
                                if(end == -1) 
                                        end = retUrl.length(); 
                                String code = retUrl.substring(begin+5, end); 
                                if(code != null){
                                	            Oauth oauth = new Oauth(); 
                                                AccessToken token = oauth.getAccessTokenByCode(code); 
                                                System.out.println(token);
                                                return token; 
                                                //System.out.println(token);
                                } 
                        } 
                } 
        } catch (FileNotFoundException e) { 
                Log.error("error" + e); 
        } catch (IOException e) { 
                Log.error("error" + e); 
        } catch (WeiboException e) {
			// TODO Auto-generated catch block
        	if(401 == e.getStatusCode()){
				Log.logInfo("Unable to get the access token.");
			}else{
			e.printStackTrace();
			}
		} 
        Log.error("refresh token failed"); 
        return null; 
} */
	
	
	
	public static void main(String [] args) throws WeiboException, IOException{
		
		
		 Oauth oauth = new Oauth();
		// BareBonesBrowserLaunch.openURL(oauth.authorize("code"));
		 String referer = oauth.authorize("code");
		 
		
		 Properties props = new Properties(); 
	        try { 
	                props.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("sina_account.properties"));
	                String url = props.getProperty("url");/*模拟登录的地址，https://api.weibo.com/oauth2/authorize*/ 
	                PostMethod postMethod = new PostMethod(url); 
	                postMethod.addParameter("client_id", props.getProperty("client_id"));//your client id 
	                postMethod.addParameter("redirect_uri", props.getProperty("redirect_uri"));//your url 
	                postMethod.addParameter("userId", props.getProperty("userId"));//需要获取微薄的use id 
	                postMethod.addParameter("passwd", props.getProperty("passwd")); 
	                postMethod.addParameter("isLoginSina", "0"); 
	                postMethod.addParameter("action", "submit"); 
	                postMethod.addParameter("response_type", props.getProperty("response_type"));//code 
	                HttpMethodParams param = postMethod.getParams(); 
	                param.setContentCharset("UTF-8"); 
	                List<Header> headers = new ArrayList<Header>(); 
	                headers.add(new Header("Referer", referer));//伪造referer 
	                headers.add(new Header("Host", "api.weibo.com")); 
	                headers.add(new Header("User-Agent", "Mozilla/5.0 (Windows NT 6.1; rv:11.0) Gecko/20100101 Firefox/11.0")); 
	                HttpClient client  = new HttpClient(); 
	                client.getHostConfiguration().getParams().setParameter("http.default-headers", headers); 
	                client.executeMethod(postMethod); 
	                int status = postMethod.getStatusCode(); 
	                System.out.println(status);
	                if(status != 302){ 
	                        Log.error("refresh token failed"); 
	                        //return null; 
	                } 
	                Header location = postMethod.getResponseHeader("Location"); 
	                if(location != null){ 
	                        String retUrl = location.getValue(); 
	                        int begin = retUrl.indexOf("code="); 
	                        if(begin != -1){ 
	                                int end = retUrl.indexOf("&", begin); 
	                                if(end == -1) 
	                                        end = retUrl.length(); 
	                                String code = retUrl.substring(begin+5, end); 
	                                if(code != null){
	                                	            //Oauth oauth = new Oauth(); 
	                                                AccessToken token = oauth.getAccessTokenByCode(code); 
	                                                System.out.println(token);
	                                                //return token; 
	                                                System.out.println(token);
	                                                System.out.println("Success!");
	                                } 
	                        } 
	                } 
	        } catch (FileNotFoundException e) { 
	                Log.error("error" + e); 
	        } catch (IOException e) { 
	                Log.error("error" + e); 
	        } catch (WeiboException e) {
				// TODO Auto-generated catch block
	        	if(401 == e.getStatusCode()){
					Log.logInfo("Unable to get the access token.");
				}else{
				e.printStackTrace();
				}
			} 
	        Log.error("refresh token failed"); 
	        // return null; 
		
		
		
		/*Oauth oauth = new Oauth();
		BareBonesBrowserLaunch.openURL(oauth.authorize("code"));
		System.out.println(oauth.authorize("code"));
		System.out.print("Hit enter when it's done.[Enter]:");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String code = br.readLine();
		Log.logInfo("code: " + code);
		try{
			System.out.println(oauth.getAccessTokenByCode(code));
		} catch (WeiboException e) {
			if(401 == e.getStatusCode()){
				Log.logInfo("Unable to get the access token.");
			}else{
				e.printStackTrace();
			}
		}*/
	}
	
	
	
	
	
	

}
