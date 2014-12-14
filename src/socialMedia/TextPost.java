package socialMedia;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TumblerPost
 */
@WebServlet("/TumblerPost")
public class TextPost extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TextPost() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   System.out.println("here");
      System.out.println(request.getParameter("post"));
      String post = request.getParameter("post");
      int userID = Integer.parseInt(request.getParameter("userID"));
      DBAccess db = new DBAccess();
      SocialMediaAccess site = db.getSocialMediaSite(userID, 1);
      site.login();
      site.createTextPost(post, null);
      
      site = db.getSocialMediaSite(userID, 2);
      site.login();
      site.createTextPost(post, null);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   System.out.println("here");
	   String post = request.getParameter("post");
	   int userID = Integer.parseInt(request.getParameter("userID"));
	   DBAccess db = new DBAccess();
      SocialMediaAccess site = db.getSocialMediaSite(userID, 1);
      site.login();
      site.createTextPost(post, null);
      
      site = db.getSocialMediaSite(userID, 2);
      site.login();
      site.createTextPost(post, null);
      
      /*site = db.getSocialMediaSite(userID, 3);
      site.login();
      site.createTextPost(post, null);
      */
      request.getSession().setAttribute("userID", userID);
      request.getRequestDispatcher("poster.jsp").forward(request, response);
	}

}
