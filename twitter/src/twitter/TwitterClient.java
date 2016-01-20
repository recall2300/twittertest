package twitter;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;

public class TwitterClient {
	private Twitter twitter;
	private RequestToken requestToken = null;
	private AccessToken accessToken = null;
	private final String CONSUMER_KEY = "oi9uv7nIxPqcTTKu3WpOQeW4C";
	private final String CONSUMER_SECRET = "d26Hq4TMBo2uNOplbI5hbmKObXKB4BUgl335ODOYNfymawVkv3";
	
	public RequestToken getRequestToken(){
		twitter = new TwitterFactory().getInstance();
		twitter.setOAuthConsumer(CONSUMER_KEY, CONSUMER_SECRET);
		requestToken = null;
		try{
			requestToken = twitter.getOAuthRequestToken();
			
		}catch(TwitterException te){
			te.printStackTrace();
		}
		return requestToken;
	}
	
	public AccessToken getAccessToken(String oauthToken, RequestToken requestToken){
		twitter = new TwitterFactory().getInstance();
		twitter.setOAuthConsumer(CONSUMER_KEY, CONSUMER_SECRET);
		if(requestToken.getToken().equals(oauthToken)){
			try{
				accessToken = twitter.getOAuthAccessToken(requestToken);
				twitter.setOAuthAccessToken(accessToken);
			} catch(TwitterException te){
				te.printStackTrace();
			
			}
		}
		else{
			System.out.println("oauth_token error");
		}
		return accessToken;
	}
	
}
 