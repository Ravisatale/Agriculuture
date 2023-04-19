<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Table Data</title>
<style>
ul {
  list-style-type: none;
  margin: 0;
  padding: 0;
  overflow: hidden;
  background-color: #333;
}
li {
  float: left;
  border-right:3px solid #bbb;
}
li:last-child {
  border-right:3px solid #bbb;
}
li a {
  display: block;
  color: white;
  text-align: center;
  padding: 34px 36px;
  text-decoration: none;
}
li a:hover:not(.active) {
  background-color: #111;
}
.active {
  background-color: #04AA6D;
}
</style>
</head>
<body>

<% ResultSet rs=(ResultSet)session.getAttribute("ravi"); %>
<table cellpading=20px border=5px align="center">
<th>id</th>
<th>name</th>
<th>location</th>
<th>email</th>
<th>pass</th>

<% while(rs.next()) { %>
<tr>
<td><%=rs.getInt(1) %></td>
<td><%=rs.getString(2) %></td>
<td><%=rs.getString(3) %></td>
<td><%=rs.getString(4) %></td>
<td><%=rs.getString(5) %></td>

</tr>
<%} %>
</table>
<hr>
<ul>
  <li><a href="option.html">Home</a></li>
 
</ul>
</body>
</html>