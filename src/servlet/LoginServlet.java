package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
    }
    
    private boolean checkUser(String username, String password) {
    	ApplicationContext ap=ApplicationContext.getInstance();
    	return ap.find(username, password);
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(checkUser(request.getParameter("username"), request.getParameter("password"))) {
			request.setAttribute("user", "Logged in as: "+request.getParameter("username"));
			loggedUser=request.getParameter("username");
		}
		else {
			PrintWriter out = response.getWriter();
			out.println("<html><body>Incorrect username or password.</body></html>");
			return;
		}
		request.getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
	}
	public static String loggedUser;
}
