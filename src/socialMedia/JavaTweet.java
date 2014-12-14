package socialMedia;

import java.io.IOException;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;

public class JavaTweet implements SocialMediaAccess
{
      private String consumerKey;
      private String consumerSecret;
      private String token;
      private String tokenSecret;
      Twitter twitter = new TwitterFactory().getInstance();
      
      public JavaTweet(String consumerKey, String consumerSecret, String token, String tokenSecret)
      {
         this.consumerKey = consumerKey;
         this.consumerSecret = consumerSecret;
         this.token = token;
         this.tokenSecret = tokenSecret;
      }
      
      @Override
      public void login()
      {
         
           twitter.setOAuthConsumer(consumerKey, consumerSecret);
           AccessToken accessToken = new AccessToken(token, tokenSecret);
           twitter.setOAuthAccessToken(accessToken);
      }
      
      @Override
      public void createTextPost(String post, String section)
            throws IOException
      {
         try {
            twitter.updateStatus(post);
         } catch (TwitterException te) {
            te.printStackTrace();
        
         }
      }
}