package weibo4j.examples.WeiboCrawler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;

import weibo4j.Oauth;
import weibo4j.examples.oauth2.Log;
import weibo4j.http.AccessToken;
import weibo4j.model.WeiboException;

public class AccessTokenIssuer {
	
	public static AccessToken GetToken(App app, AppUser user){
		
		
		// Get Referer URL
				 Oauth oauth = new Oauth();
				 String referer="";
				try {
					referer = oauth.authorize("code");
				} catch (WeiboException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				 
				 
				 //Simulating Desktop Apps Login with UserId and Passwd (Parameter)
				 String url = "https://api.weibo.com/oauth2/authorize";
				 PostMethod postMethod = new PostMethod(url); 
				 postMethod.addParameter("client_id", app.getClientId());
				 //postMethod.addParameter("redirect_uri", "https://api.weibo.com/oauth2/default.html");
				 postMethod.addParameter("redirect_uri", app.getRedirectUrl());
				 postMethod.addParameter("userId", user.getUname());
				 postMethod.addParameter("passwd", user.getPassWord());
				 postMethod.addParameter("isLoginSina", "0"); 
				 postMethod.addParameter("action", "submit"); 
				 postMethod.addParameter("response_type", "code");// Using code type
				 HttpMethodParams param = postMethod.getParams(); 
				 param.setContentCharset("UTF-8"); 
				 
				 // Using HttpClient to submit and Obtain redirect url
				 List<Header> headers = new ArrayList<Header>(); 
				 headers.add(new Header("Referer", referer));//伪造referer 
		         headers.add(new Header("Host", "api.weibo.com")); 
		         headers.add(new Header("User-Agent", "Mozilla/5.0 (Windows NT 6.1; rv:11.0) Gecko/20100101 Firefox/11.0")); 
		         HttpClient client  = new HttpClient(); 
		         client.getHostConfiguration().getParams().setParameter("http.default-headers", headers); 
		         try {
					client.executeMethod(postMethod);
				} catch (HttpException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
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
		                     	            //Oauth oauth = new Oauth(); 
		                                     AccessToken token;
											try {
												//token = oauth.getAccessTokenByCode(code);
												token = oauth.getMyAccessTokenBycode(code, app.getClientId(), app.getClientSecret(), app.getRedirectUrl());
			                                     //System.out.println(token);
												String temp =  (token==null) ? "Empty" : token.toString();
			                                     System.out.println("Successfully apply for accesstoken" + temp);
			                                     return token;
											} catch (WeiboException e) {
												// TODO Auto-generated catch block
												if(401 == e.getStatusCode()){
												Log.logInfo("Unable to get the access token.");
												}else{
												e.printStackTrace();
												}
											} 
		                                     
		                } 
		          } 
		         		
		    }
		         Log.error("refresh token failed"); 
		         return null;
		}
		
}

