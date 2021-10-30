package allserv;
import java.sql.*;
import calldatabase.*;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class UserLog
 */
@WebServlet("/AdminLogin")
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			PrintWriter out=response.getWriter();
			String aid=request.getParameter("aid");
			String apass=request.getParameter("apass");
			if(aid.equals("admin5754") && (apass.equals("Rumanver1@"))) {
				RequestDispatcher rd=request.getRequestDispatcher("adminhome.html");
				rd.forward(request, response);
			}
				/*ses.setAttribute("fname",aid);*/
				
		else {
				out.print("wrong userid or password");
				RequestDispatcher rd=request.getRequestDispatcher("adminlogin.html");
				rd.include(request, response);
			}
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}
