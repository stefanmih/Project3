package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public HomeServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getParameter("listall") != null) {
			request.setAttribute("table", ApplicationContext.getInstance().listCities());
		}
		request.setAttribute("user", "Logged in as: " + LoginServlet.loggedUser);
		if (request.getParameter("dodajgrad") != null) {
			ApplicationContext.getInstance().addCity((String) request.getParameter("naziv"),
					(String) request.getParameter("pttbroj"));
			request.setAttribute("table", "City Added.");
		}
		if (request.getParameter("izbrisi") != null) {
			String search = (String) request.getParameter("pttbrojdelete");
			if (ApplicationContext.getInstance().deleteCity(search))
				request.setAttribute("table", "City Deleted.");
			else
				request.setAttribute("table", "City not found.");
		}
		if (request.getParameter("nadji") != null) {
			String search = (String) request.getParameter("pttbrojfind");
			if (ApplicationContext.getInstance().findCity(search)!=null)
				request.setAttribute("table", "City Founded."+"\n"+ApplicationContext.getInstance().findCity(search));
			else
				request.setAttribute("table", "City not found.");
		}
		request.getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
	}

}
