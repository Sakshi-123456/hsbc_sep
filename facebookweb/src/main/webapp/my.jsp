<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%
String n=request.getParameter("name");

if(n.equals("Sakshi"))
		{%>
	<font color=red> INVALID USER </font>
	<% 	}
else
{ %>
	<font color=green> VALID USER </font>
<%  }
%>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

</body>
</html>