package socialMedia;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class register
 */
@WebServlet("/register")
public class Register extends HttpServlet {
   private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // TODO Auto-generated method stub
   }

   /**
    * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // TODO Auto-generated method stub
        DBAccess db = new DBAccess();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String twitConsKey = request.getParameter("twitterConsumerKey");
        String twitConsSecret = request.getParameter("twitterConsumerSecret");
        String twitToken = request.getParameter("twitterToken");
        String twitTokenSecret = request.getParameter("twitterTokenSecret");
        String tumbConsKey = request.getParameter("tumblrConsumerKey");
        String tumbConsSecret = request.getParameter("tumblrConsumerSecret");
        String tumbToken = request.getParameter("tumblrToken");
        String tumbTokenSecret = request.getParameter("tumblrTokenSecret");
        
       request.getSession().setAttribute("username", username);
       request.getSession().setAttribute("password", password);
       request.getSession().setAttribute("twitterConsumerKey", twitConsKey);
       request.getSession().setAttribute("twitterConsumerSecret", twitConsSecret);
       request.getSession().setAttribute("twitterToken", twitToken);
       request.getSession().setAttribute("twitterTokenSecret", twitTokenSecret);
       request.getSession().setAttribute("tumblrConsumerKey", tumbConsKey);
       request.getSession().setAttribute("tumblrConsumerSecret", tumbConsSecret);
       request.getSession().setAttribute("tumblrToken", tumbToken);
       request.getSession().setAttribute("tumblrTokenSecret", tumbTokenSecret);
       request.getRequestDispatcher("register.jsp").forward(request, response);
       db.insertUser(username, password);
       db.insertSocialMediaSite("Twitter");
             //db.insertUserAccess(userId, siteID, twitConsKey, twitConsSecret, twitToken, twitTokenSecret );
       db.insertUser(username, password);
       db.insertSocialMediaSite("Tumbler");
           //db.insertUserAccess(userId, siteID, tumbConsKey, tumbConsSecret, tumbToken, tumbTokenSecret );
           
   }

}
