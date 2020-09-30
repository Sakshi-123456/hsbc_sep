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



String cname=request.getParameter("countryname");
FacebookWebUser ff=new FacebookWebUser();
ff.setCountry(cname);
List<String> ll=fs.State(ff);
/* if(cname.equals("India")){
	i.add("Karnataka");
	i.add("Punjab");
}
if(cname.equals("US")){
	i.add("Sansfransisko");
	i.add("Bostan");
} 
onchange=loadcity()*/

String ss="<select id=ss name=state onchange=loadcity()>";
for(String l:ll){
	ss=ss+"<option value='"+l+"'>"+l+"</option>";
}
ss=ss+"</select>";
out.println(ss);
%>
</body>
</html>