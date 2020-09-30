<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%@page import="java.util.*,com.facebookweb.service.FacebookWebServiceInterface,com.facebookweb.utility.ServiceFactory,com.facebookweb.entity.FacebookWebUser" %>


<%FacebookWebServiceInterface fs=ServiceFactory.createObject("adminservice");
String sname=request.getParameter("statename");
FacebookWebUser ff=new FacebookWebUser();
ff.setCountry(sname);
List<String> i=fs.City(ff);

String ss="<select id=ss name=city >";
for(String ll:i){
	ss=ss+"<option value='"+ll+"'>"+ll+"</option>";
	
}
ss=ss+"</select>";
out.println(ss);
%>
</body>
</html>