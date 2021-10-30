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
@WebServlet("/UserLog")
public class UserLog extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			PrintWriter out=response.getWriter();
			String aid=request.getParameter("aid");
			String apass=request.getParameter("apass");
			Connection cn=GetData.getCn();
			PreparedStatement ps=cn.prepareStatement("select aid,password1 from register where aid=? and password1=? ");
			ps.setString(1, aid);
			ps.setString(2, apass);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				HttpSession ses=request.getSession();
				ses.setAttribute("aid",rs.getString(1));
				HttpSession ses1=request.getSession();
				ses1.setAttribute("password1",rs.getString(2));
				RequestDispatcher rd=request.getRequestDispatcher("userhome.jsp");
				rd.forward(request, response);
			}else {
				out.print("wrong userid or password");
				RequestDispatcher rd=request.getRequestDispatcher("login.html");
				rd.include(request, response);
			}
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}
