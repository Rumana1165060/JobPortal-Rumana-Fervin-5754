package allserv;
import java.sql.*;
import java.util.*;
import java.util.Date;

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
 * Servlet implementation class Rent
 */
@WebServlet("/ApplyJob")
public class ApplyJob extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			PrintWriter out=response.getWriter();
			String sid=request.getParameter("sc");
			HttpSession s1=request.getSession(false);
			String aid=(String)s1.getAttribute("aid");
			String dte="22-10-21";
			System.out.println(sid);
			System.out.println(aid);
			String sql_space="update job set status='applied' where sid=?";
			String sql_book="insert into applying values(?,?,?)";
			Connection cn=GetData.getCn();
			PreparedStatement ps=cn.prepareStatement(sql_space);
			ps.setString(1, sid);
			ps.execute();
			
			PreparedStatement ps1=cn.prepareStatement(sql_book);
			ps1.setString(1, sid);
			ps1.setString(2, aid);
			ps1.setString(3, dte);
			ps1.execute();
			
			out.print("Job Applied successfully...");
			RequestDispatcher rd=request.getRequestDispatcher("userhome.jsp");
			rd.include(request, response);
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}
