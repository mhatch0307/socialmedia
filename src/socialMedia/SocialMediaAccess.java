package socialMedia;

import java.io.IOException;

public interface SocialMediaAccess
{
   /**
    * Used to login into social media site
    */
   public void login();
   
   /**
    * create post on social media site
    * @param post - the message to be posted
    * @param section - this may not be neccessary for your site
    * @throws IOException
    */
   public void createTextPost(String post, String section) throws IOException;
}
