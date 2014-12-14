package socialMedia;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import com.tumblr.jumblr.JumblrClient;
import com.tumblr.jumblr.types.User;

public class TumblrAccess implements SocialMediaAccess
{
   private JumblrClient client;
   private User user;
   private String username;
   private String consumerKey;
   private String consumerSecret;
   private String token;
   private String tokenSecret;
   
   /**
    * 
    * @param consumerKey
    * @param consumerSecret
    * @param token
    * @param tokenSecret
    * @param blog
    */
   public TumblrAccess(String consumerKey, String consumerSecret, String token, String tokenSecret)
   {  
      this.consumerKey = consumerKey;
      this.consumerSecret = consumerSecret;
      this.token = token;
      this.tokenSecret = tokenSecret;
   }
   
   /**
    * 
    */
   public void login()
   {
      // Authenticate via OAuth
      client = new JumblrClient(
        consumerKey,
        consumerSecret
      );
      client.setToken(
        token,
        tokenSecret
      );
      user = client.user();
      username = user.getName();
   }
   
   /**
    * @param post
    * @param blog
    * @throws IOException
    */
   public void createTextPost(String post, String section) throws IOException
   {
      Map<String, String> detail = new HashMap<String, String>();
      detail.put("body", post);
      detail.put("type", "text");
      section = (section == null)? username : section;
      client.postCreate(section, detail);
   }
}
