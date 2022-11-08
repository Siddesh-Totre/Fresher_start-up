package trail;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/nextpage")
public class first extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException 
	{
		String uname = req.getParameter("Un");
		String pwd = req.getParameter("pw");
		PrintWriter out = resp.getWriter();
		
		/*out.print("<html><body bgcolor='grey'>"
				+ "<h1>Details are:-> "+uname+" "+pwd+" "
				+ "Thank YOU !!!!! </h1></body></html>");*/
		
	try {	
	   if( pwd.equals("root") )
		{
			RequestDispatcher rd = req.getRequestDispatcher("/welcome");
			rd.forward(req, resp);
		}
		else
		{
			out.print("<html><body>"
					+ "<h1>Sorry Username or password in incorrect!!!"
					+ "</h1></body></html>");
			
			RequestDispatcher rd = req.getRequestDispatcher("NewFile.html");
			rd.include(req, resp);
			
		}	
	}catch (Exception e)	{
		e.printStackTrace();
	}
	}
}
