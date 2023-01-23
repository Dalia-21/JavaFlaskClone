package dalia.javablog.webapp;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Servlet implementation class Login
 */

@WebServlet(urlPatterns={"/login", "/register"})
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    protected String getRequestPage(HttpServletRequest request) {
		URI uri = null;
		try {
			uri = new URI(request.getRequestURL().toString());
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		String path = uri.getPath();
		return path.substring(path.lastIndexOf('/') + 1);
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		String requestPage = getRequestPage(request);
		if (requestPage.equals("login")) {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/login.jsp");
			rd.forward(request, response);
		} else if (requestPage.equals("register")) {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/register.jsp");
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		PrintWriter out = response.getWriter();
		out.println("<p>Hello " + username + ". Your password is " + password + "</p>");
		out.close();
	}

}
