package pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * Servlet implementation class CandidateListServlet
 */
@WebServlet("/candidate_list")
public class CandidateList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/*
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		try (PrintWriter pw = response.getWriter()) {
			//Get the Cookies from Request Headers 
			//API HttpServletRequest
			Cookie[] cookies=request.getCookies();
			
			if(cookies!=null) 
			{
				pw.print("<h5>In candidate list page ....</h5>");
				pw.print("<h5> Validated user email "+ "</h5>");
				for(Cookie e:cookies)
				{
					if(e.getName().equals("user_dtls"))
					{
							pw.print("<h5>Validated user details: "+e.getValue()+"</h5>");
					}
					
				}
			}else {
				pw.print("<h5>Session Tracikng Failed,No Cookies!!!!!!!!!</h5>");
				
			
		}
		
		}
	}

}
