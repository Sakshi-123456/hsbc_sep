<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <%@page import="java.util.*,com.facebookweb.service.FacebookWebServiceInterface,com.facebookweb.utility.ServiceFactory" %>

<%
FacebookWebServiceInterface fs=ServiceFactory.createObject("adminservice");
List<String> ll=fs.Country();


/* List<String> i=new ArrayList<String>();
i.add("India");
i.add("US");
onchange=loadstate()*/
String ss="<select id=cc name=country onchange=loadstate()>";
for(String l:ll){
	
	ss=ss+"<option value='"+l+"'>"+l+"</option>";
}
ss=ss+"</select>";
out.println(ss);
%>
</body>
</html>