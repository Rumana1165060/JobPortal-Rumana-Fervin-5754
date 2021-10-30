<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ApplyJob</title>
<link rel="stylesheet" href="list.css">
<link rel="stylesheet" href="Navigationstyle.css">
<style>
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
.center {
  display: block;
  margin-left: auto;
  margin-right: auto;
  width: 50%;
}
tables {
  border-collapse: collapse;
  width: 80%;
 }

th {
  height: 50px;
}
</style>

</head>
<center>
<body>
<%@page import="java.sql.*,calldatabase.*" %>
<table>
<td><div class="topnav"><img src="title.png" height="50" width="50"></div></td><br>
<td><div class="topnav"><a href="home.html">&#160;&#160;&#160;Home&#160;&#160;&#160;</a></div></td>
<td><div class="topnav"><a href="ApplyJob.jsp">&#160;&#160;&#160;Apply Job&#160;&#160;&#160;</a></div></td>

<!-- <td><div class="navbar">
<div class="dropdown">
    <button class="dropbtn">&#160;Job List&#160;
      <i class="fa fa-caret-down"></i>
    </button>
    <div class="dropdown-content">
      <a href="datascience.html">Data Science</a>
      <a href="digitalmarketing.html">Digital Marketing</a>
      <a href="medicalprofessionals.html">Medical Professionals</a>
     <a href="machinelearningexperts.html">Machine Learning Experts</a>
      <a href="blockchaindevelopers.html">Blockchain Developers</a>
      <a href="softwareengineers.html">Software Engineers</a>
      <a href="charteredaccountant.html">Chartered Accountant</a>
      <a href="lawyers.html">Lawyers</a> 
    </div>
  </div>
</div></td> -->
<td><div class="topnav"><a href="contactus.html">&#160;Contact Us&#160;</a></div></td>
<td><div class="topnav"><a href="index.html">&#160;&#160;&#160;Logout&#160;&#160;&#160;</a></div></td>
</table>
<%
session=request.getSession(false);
String cname=(String)session.getAttribute("fname");
%>
<font color="white">Welcome :<%=cname %></font>

</li>
</ul>
</td>
</tr>
</table>
<form action="ApplyJob">
<table border="1" style="background-color:#aeeaf4">
<tr><th colspan="2"><center>Apply Job Here</center></th></tr>
<tr><th colspan="2"><img src="apply.jpg" alt="apply" class="center"></th></tr>
<tr><th>Job Title</th><th>Company</th><th>Location</th><th>Select</th></tr>
<%
try{
	Connection cn=GetData.getCn();
	PreparedStatement ps=cn.prepareStatement("select  title,company,location,sid from job");
	ResultSet rs=ps.executeQuery();
	while(rs.next()){
%>
<tr>
<td><%=rs.getString(1) %></td>
<td><%=rs.getString(2) %></td>
<td><%=rs.getString(3) %></td>
<td><input type="radio" name="sc" value=<%=rs.getString(4) %>></td>
</tr>
<%} %>
<%}catch(Exception e){
	out.print(e);
}
	%>
<tr><td colspan="5"><input type="submit" class="btn" class="center" value="Apply Here"></td></tr>
</table>
</form>
</body>
</center>
</html>