<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Table Data</title>
</head>
<body>

<% ResultSet rs=(ResultSet)session.getAttribute("ravi"); %>
<table cellpading=20px border=5px>

<th>crop</th>
<th>rate</th>
<th>id</th>


<% while(rs.next()) { %>
<tr>
<td><%=rs.getString(1) %></td>
<td><%=rs.getInt(2) %></td>
<td><%=rs.getInt(3) %></td>

</tr>
<%} %>
</table>
</body>
</html>