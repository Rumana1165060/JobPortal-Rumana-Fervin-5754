<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Home</title>
<link rel="stylesheet" href="list.css">
<link rel="stylesheet" href="Navigationstyle.css">
</head>
<center>
<body background="wel job.jpg">
<table>
<td><div class="topnav"><img src="title.png" height="50" width="50"></div></td><br>
<td><div class="topnav"><a href="userhome.jsp">&#160;&#160;&#160;Home&#160;&#160;&#160;</a></div></td>
<td><div class="navbar">
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
</div></td>
<td><div class="topnav"><a href="ApplyJob.jsp">&#160;&#160;&#160;Apply Job&#160;&#160;&#160;</a></div></td>
<td><div class="topnav"><a href="contactus.html">&#160;Contact Us&#160;</a></div></td>
<td><div class="topnav"><a href="index.html">&#160;&#160;&#160;Logout&#160;&#160;&#160;</a></div></td>
<%
session=request.getSession(false);
String cname=(String)session.getAttribute("fname");
%>
<font color="white">Welcome :<%=cname %></font>
</table>

</body></center>
</html>