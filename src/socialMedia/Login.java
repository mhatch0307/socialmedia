package socialMedia;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
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
	     String username = request.getParameter("username");
		  String password = request.getParameter("password");
		  DBAccess db = new DBAccess();
		  int userID = db.getUser(username, password);
		  if(userID > 0)
		  {
		     request.getSession().setAttribute("userID", userID);
		     request.getRequestDispatcher("poster.jsp").forward(request, response);
		  }
		  else
		  {
		     request.setAttribute("invalidLogin", "Username and/or password incorrect.");
		     request.getRequestDispatcher("login.jsp").forward(request, response);
		  }
	}

}
