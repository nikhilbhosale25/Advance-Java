package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDaoImpl;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDaoImpl userDao;
	/**
	 * @see Servlet#init()
	 */
	public void init() throws ServletException {
		
		try {
			userDao = new UserDaoImpl();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new ServletException("err in init of " + getClass(), e);
		}
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		try {
			userDao.cleanUp();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("err in destroy of " + getClass() + " " + e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		try(PrintWriter pw=response.getWriter())
		{
			String FirstName=request.getParameter("fn");
			String LastName=request.getParameter("ln");
			String email=request.getParameter("em");
			String Password=request.getParameter("pass");
			String DateofBirth=request.getParameter("dob");
			
			String result=userDao.RegisterUser(FirstName, LastName, email, Password, DateofBirth);
			pw.print(result);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
