package socialMedia;
import java.io.IOException;

import facebook4j.Account;
import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.FacebookFactory;
import facebook4j.Post;
import facebook4j.PostUpdate;
import facebook4j.ResponseList;
import facebook4j.auth.AccessToken;
import facebook4j.conf.ConfigurationBuilder;

public class FacebookAccess implements SocialMediaAccess
{
   private String accessToken;
   private String secret;
   private String appId;
   private Facebook facebook;
   
   public FacebookAccess(String accessToken, String appId, String secret) {
      this.accessToken = accessToken;
      this.secret = secret;
      this.appId = appId;
   }

   @Override
   public void login() 
   {
      facebook = new FacebookFactory().getInstance();
      facebook.setOAuthAppId(appId, secret);
      facebook.setOAuthPermissions("email,publish_stream, publish_actions, id, name, first_name, last_name, generic");
      facebook.setOAuthAccessToken(new AccessToken(accessToken, null));    
   }

   @Override
   public void createTextPost(String post, String section) throws IOException
   {
      try {
         facebook.postStatusMessage(post);

      } catch (FacebookException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
   }

}
