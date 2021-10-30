<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Job Info</title>
<link rel="stylesheet" href="list.css">
<link rel="stylesheet" href="Navigationstyle.css">
<style type="text/css">
.btn {
  background-color: #242ea6;
  border: none;
  color: black;
  padding: 15px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 4px 2px;
  cursor: pointer;
}
</style>

</head>
<body>
<%@page import="java.sql.*,calldatabase.*" %>
<table>
<td><div class="topnav"><img src="title.png" height="50" width="50"></div></td><br>
<td><div class="topnav"><a href="adminhome.html">&#160;&#160;&#160;Home&#160;&#160;&#160;</a></div></td>
<td><div class="topnav"><a href="create.html">&#160;Add Job List&#160;</a></div></td>
<td><div class="topnav"><a href="update.html">&#160;Update Job List&#160;</a></div></td>
<td><div class="topnav"><a href="delete.html">&#160;Delete Job List&#160;</a></div></td>
<td><div class="topnav"><a href="showjob.jsp">&#160;Job Status&#160;</a></div></td>
<td><div class="topnav"><a href="adminlogin.html">&#160;&#160;&#160;Logout&#160;&#160;&#160;</a></div></td>
</table>
<center>
<table border="1" style="background-color:#aeeaf4">
<tr><th colspan="5">Job Info</th></tr>
<tr><td><b>ID</b></td><td><b>Title</b></td><td><b>Company</b></td><td><b>Location</b></td><td><b>Status</b></td></tr>
<%
try{
	Connection cn=GetData.getCn();
	PreparedStatement ps=cn.prepareStatement("select * from job");
	ResultSet rs=ps.executeQuery();
	while(rs.next()){
%>
<tr>
<td><%=rs.getString(1) %></td>
<td><%=rs.getString(2) %></td>
<td><%=rs.getString(3) %></td>
<td><%=rs.getString(4) %></td>
<td><%=rs.getString(5) %></td>
</tr>
<%} %>
<%}catch(Exception e){
	out.print(e);
} %>
</table>
</center>
</body>
</html>