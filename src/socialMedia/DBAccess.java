package socialMedia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBAccess
{
   final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   final String DB_URL = "jdbc:mysql://127.12.171.130/socialmedia";

   //  Database credentials
   final static String USER = "socialmedia";
   final static String PASS = "password";
   public SocialMediaAccess getSocialMediaSite(int userID, int siteID)
   {  
      SocialMediaAccess socialMediaSite = null;   
      switch(siteID)
      {
         case 1:
            socialMediaSite = buildTumblrAccess(userID);
            break;
         case 2:
            socialMediaSite = buildJavaTweet(userID);
            break;
         case 3:
            socialMediaSite = buildFacebookAccess(userID);
            break;
      }
      return socialMediaSite;
   }
   
   /**
    * Creates an instance of TumblrAccess with data based on the userID
    * @param userID
    * @return
    */
   public TumblrAccess buildTumblrAccess(int userID)
   {
      String sql = "SELECT * "
            + "FROM "
               + "userAccess"
            + " WHERE "
               + "user_id = " + userID + " AND "
               + "socialMediaSite_id = 1";
       Connection conn = null;
       PreparedStatement stmt = null;
       ResultSet rs;
       String consumerKey = "";
       String consumerSecret = "";
       String token = "";
       String tokenSecret = "";
       
       try
       {
          //Register JDBC driver
          Class.forName("com.mysql.jdbc.Driver");
          conn = DriverManager.getConnection(DB_URL, USER, PASS);
          
          //Execute a query
          stmt = conn.prepareStatement(sql);
          rs = stmt.executeQuery();
          
          while(rs.next()){
             System.out.println(rs.getInt("id"));
             consumerKey = rs.getString("consumerKey");
             consumerSecret = rs.getString("consumerSecret");
             token = rs.getString("token");
             tokenSecret = rs.getString("tokenSecret");
          }
          rs.close();
       }
       catch (SQLException e)
       {
          // TODO Auto-generated catch block
          e.printStackTrace();
       }
       catch (ClassNotFoundException e)
       {
          // TODO Auto-generated catch block
          e.printStackTrace();
       }
       return new TumblrAccess(consumerKey, consumerSecret, token, tokenSecret);
   }
   
   /**
    * Creates an instance of JavaTweet with data based on the userID
    * @param userID
    * @return
    */
   public JavaTweet buildJavaTweet(int userID)
   {
      String sql = "SELECT * "
            + "FROM "
               + "userAccess"
            + " WHERE "
               + "user_id = " + userID + " AND "
               + "socialMediaSite_id = 2";
       Connection conn = null;
       PreparedStatement stmt = null;
       ResultSet rs;
       String consumerKey = "";
       String consumerSecret = "";
       String token = "";
       String tokenSecret = "";
       try
       {
          //Register JDBC driver
          Class.forName("com.mysql.jdbc.Driver");
          conn = DriverManager.getConnection(DB_URL, USER, PASS);
          
          //Execute a query
          stmt = conn.prepareStatement(sql);
          rs = stmt.executeQuery();
          
          while(rs.next()){
             System.out.println(rs.getInt("id"));
             consumerKey = rs.getString("consumerKey");
             consumerSecret = rs.getString("consumerSecret");
             token = rs.getString("token");
             tokenSecret = rs.getString("tokenSecret");
          }
          rs.close();
       }
       catch (SQLException e)
       {
          // TODO Auto-generated catch block
          e.printStackTrace();
       }
       catch (ClassNotFoundException e)
       {
          // TODO Auto-generated catch block
          e.printStackTrace();
       }
       return new JavaTweet(consumerKey,consumerSecret, token, tokenSecret);
   }
   
   /**
    * 
    * @param userID
    */
   public FacebookAccess buildFacebookAccess(int userID)
   {
      String sql = "SELECT * "
            + "FROM "
               + "userAccess"
            + " WHERE "
               + "user_id = " + userID + " AND "
               + "socialMediaSite_id = 3";
       Connection conn = null;
       PreparedStatement stmt = null;
       ResultSet rs;
       String consumerKey = "";
       String token = "";
       String tokenSecret = "";
       
       try
       {
          //Register JDBC driver
          Class.forName("com.mysql.jdbc.Driver");
          conn = DriverManager.getConnection(DB_URL, USER, PASS);
          
          //Execute a query
          stmt = conn.prepareStatement(sql);
          rs = stmt.executeQuery();
          
          while(rs.next()){
             System.out.println(rs.getInt("id"));
             consumerKey = rs.getString("consumerKey");
             token = rs.getString("token");
             tokenSecret = rs.getString("tokenSecret");
          }
          rs.close();
       }
       catch (SQLException e)
       {
          // TODO Auto-generated catch block
          e.printStackTrace();
       }
       catch (ClassNotFoundException e)
       {
          // TODO Auto-generated catch block
          e.printStackTrace();
       }
       return new FacebookAccess(consumerKey, token, tokenSecret);
   }
   
   public void insertUser(String username, String password)
   {
       String sql = "INSERT INTO user (username, password) "
                 + " VALUES("+username+","+password+")";
    
       Connection conn = null;
       PreparedStatement stmt = null;
       ResultSet rs;
       
       try
       {
          //Register JDBC driver
          Class.forName("com.mysql.jdbc.Driver");
          conn = DriverManager.getConnection(DB_URL, USER, PASS);
          
          //Execute a query
          stmt = conn.prepareStatement(sql);
          rs = stmt.executeQuery();
          rs.close();
       }
       catch (SQLException e)
       {
          // TODO Auto-generated catch block
          e.printStackTrace();
       }
       catch (ClassNotFoundException e)
       {
          // TODO Auto-generated catch block
          e.printStackTrace();
       }
   }
   
   /**
    * 
    * @param username
    * @param password
    * @return userID
    */
   public int getUser(String username, String password)
   {
      String sql = "SELECT id FROM users WHERE username = '" + username + "' AND password = '" + password + "'";
      Connection conn = null;
      PreparedStatement stmt = null;
      ResultSet rs;
      int userID = 0;
      
      try
      {
         //Register JDBC driver
         Class.forName("com.mysql.jdbc.Driver");
         conn = DriverManager.getConnection(DB_URL, USER, PASS);
         
         //Execute a query
         stmt = conn.prepareStatement(sql);
         rs = stmt.executeQuery();
         
         while(rs.next()){
            userID = rs.getInt("id");
         }
         rs.close();
      }
      catch (SQLException e)
      {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      catch (ClassNotFoundException e)
      {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      return userID;
   }
   
   public void insertSocialMediaSite(String name)
   {
      String sql = "INSERT INTO socialMediaSites (name) "
            + " VALUES("+name+")";

      Connection conn = null;
      PreparedStatement stmt = null;
      ResultSet rs;
     
      try
      {
         //Register JDBC driver
         Class.forName("com.mysql.jdbc.Driver");
         conn = DriverManager.getConnection(DB_URL, USER, PASS);
        
         //Execute a query
         stmt = conn.prepareStatement(sql);
         rs = stmt.executeQuery();
         rs.close();
      }
      catch (SQLException e)
      {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      catch (ClassNotFoundException e)
      {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
   }
   
   public void insertUserAccess(int userID, int siteID,
                                 String consumerKey, String consumerSecret, 
                                 String token, String tokenSecret)
   {
      String sql = "INSERT INTO userAccess (user_id, socialMediaSite_id, consumerKey, "
            + "consumerSecret, token, tokenSecret) "
            + " VALUES("+userID+","+siteID+","+consumerKey+","+consumerSecret+","+token+","+tokenSecret+")";

      Connection conn = null;
      PreparedStatement stmt = null;
      ResultSet rs;
     
      try
      {
         //Register JDBC driver
         Class.forName("com.mysql.jdbc.Driver");
         conn = DriverManager.getConnection(DB_URL, USER, PASS);
        
         //Execute a query
         stmt = conn.prepareStatement(sql);
         rs = stmt.executeQuery();
         rs.close();
      }
      catch (SQLException e)
      {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      catch (ClassNotFoundException e)
      {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
   }
}
