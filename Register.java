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

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			PrintWriter out=response.getWriter();
			int id=(int)(Math.random()*10000);
			String fname=request.getParameter("fname");
			String lname=request.getParameter("lname");
			String aid=request.getParameter("aid");
			String password1=request.getParameter("password1");
			String password2=request.getParameter("password2");
			String email=request.getParameter("email");
			String num=request.getParameter("num");
			
			Connection cn=GetData.getCn();
			PreparedStatement ps=cn.prepareStatement("insert into register values(?,?,?,?,?,?,?,?)");
			ps.setInt(1, id);
			ps.setString(2, fname);
			ps.setString(3, lname);
			ps.setString(4, aid);
			ps.setString(5, password1);
			ps.setString(6, password2);
			ps.setString(7, email);
			ps.setString(8, num);
			ps.execute();
			out.print("Registration success for ID :"+id);
			RequestDispatcher rd=request.getRequestDispatcher("login.html");
			rd.include(request, response);
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}
