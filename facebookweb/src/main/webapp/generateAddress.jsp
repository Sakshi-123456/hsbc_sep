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
String address=request.getParameter("address");
FacebookUser ff=new FacebookUser();
ff.setAddress(address);
FacebookWebServiceInterface fs=ServiceFactory.createObject("adminservice");
 
boolean i=false;
if(i==true)
{%>
 <font color=red> Please enter different email </font>
<%}else{
%>
<font color=green> Valid Email </font>
<% } %>

</body>
</html>