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
 * Servlet implementation class Update
 */
@WebServlet("/Update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			PrintWriter out=response.getWriter();
			HttpSession s=request.getSession(false);
			int id=(int)s.getAttribute("spid");
			String title=request.getParameter("title");
			String company=request.getParameter("company");
			String location=request.getParameter("location");
			Connection cn=GetData.getCn();
			PreparedStatement ps=cn.prepareStatement("update job set title=?,company=?,location=? where sid=?");
			ps.setString(1, title);
			ps.setString(2, company);
			ps.setString(3, location);
			ps.setInt(4, id);
			ps.execute();
			out.print("Record updated...");
			RequestDispatcher rd=request.getRequestDispatcher("adminhome.html");
			rd.include(request, response);
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}
