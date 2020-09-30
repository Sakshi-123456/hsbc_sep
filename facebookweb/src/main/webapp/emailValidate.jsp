<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@page import="java.util.*,com.facebookweb.entity.FacebookUser,com.facebookweb.service.FacebookWebServiceInterface,com.facebookweb.utility.ServiceFactory" %>


<%
String email=request.getParameter("email");
FacebookUser ff=new FacebookUser();
ff.setEmail(email);
FacebookWebServiceInterface fs=ServiceFactory.createObject("adminservice");
 boolean i= fs.emailValidate(ff);
if(i==true)
{%>
 <font color=red> Please enter different email </font>
<%}else{
%>
<font color=green> Valid Email </font>
<% } %>


</body>
</html>