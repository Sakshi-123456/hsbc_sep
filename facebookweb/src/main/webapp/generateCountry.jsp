<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@page import="java.util.*,com.facebookweb.dao.FacebookWebDAOInterface,com.facebookweb.utility.DAOFactory" %>


<%FacebookWebDAOInterface fs=DAOFactory.createObject("admindao");
List<String> i=fs.generateCountryDAO(); %>

<%
String ss="<select>";
for(String ll:i){
	ss=ss+"<option>"+ll+"</option>";
}
ss=ss+"</select>";
out.println(ss);
%>
</body>
</html>