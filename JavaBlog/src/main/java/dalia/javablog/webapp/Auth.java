package dalia.javablog.webapp;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import dalia.javablog.models.User;
import dalia.javablog.models.UserTable;

/**
 * Servlet implementation class Login
 */

@WebServlet(urlPatterns={"/login", "/register"})
public class Auth extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Auth() {
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
    
    protected String hashPassword(String password) {
    	String hashedPassword = null;
    	
    	try {
    		MessageDigest md = MessageDigest.getInstance("MD5");
    		md.update(password.getBytes());
    		byte[] bytes = md.digest();
    		
    		StringBuilder sb = new StringBuilder();
    		for (int i = 0; i < bytes.length; i++) {
    			sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
    		}
    		
    		hashedPassword = sb.toString();
    	} catch (NoSuchAlgorithmException e) {
    		e.printStackTrace();
    	}
    	
    	return hashedPassword;
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
		HttpSession session = null;
		
		RequestDispatcher rd = null;
		
		String requestPage = getRequestPage(request);
		if (requestPage.equals("register")) {
			String username = request.getParameter("username");
			String hashedPassword = hashPassword(request.getParameter("password"));
			User user = new User();
			user.setUsername(username);
			user.setPassword(hashedPassword);
			UserTable userTable = new UserTable();
			try {
				userTable.createUser(user);
				session = request.getSession();
				session.setAttribute("username", username);
				rd = request.getRequestDispatcher("index");
			} catch (SQLException e) {
				String duplicateUserError = "Username is unavailable";
				PrintWriter out = response.getWriter();
				out.println("<script type='text/javascript'>");
				out.println("alert(" + "'" + duplicateUserError + "'" + ");</script>");
				rd = request.getRequestDispatcher("WEB-INF/register.jsp");
			}
		} else if (requestPage.equals("login")) {
			String username = request.getParameter("username");
			String hashedPassword = hashPassword(request.getParameter("password"));
			UserTable userTable = new UserTable();
			User userResult = userTable.getUserByName(username);
			if (!(hashedPassword.equals(userResult.getPassword()))) {
				String invalidCredentialsError = "Invalid username or password";
				PrintWriter out = response.getWriter();
				out.println("<script type='text/javascript'>");
				out.println("alert(" + "'" + invalidCredentialsError + "'" + ");</script>");
				//rd = request.getRequestDispatcher("WEB-INF/login.jsp");
			} else {
				session = request.getSession();
				session.setAttribute("username", username);
				rd = request.getRequestDispatcher("index");
			}
		}
		
		rd.forward(request, response);
	}

}
