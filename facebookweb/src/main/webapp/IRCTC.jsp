<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@page import="com.facebookweb.entity.IrctcUser,java.util.*,com.facebookweb.service.FacebookWebServiceInterface,com.facebookweb.utility.ServiceFactory" %>

<% 
String city=request.getParameter("city");//its also a jquey part
IrctcUser iu=new IrctcUser();
iu.setCity(city);
FacebookWebServiceInterface is=ServiceFactory.createObject("adminservice");
List<IrctcUser> ll=is.sourceService();
System.out.println(ll.size()+" users found");
if(city==""){
	//out.println("No data");
}
else{
List<String> ll1=new ArrayList<String>();
for(IrctcUser u:ll) {
	if (u.getCity().toUpperCase().startsWith(city.toUpperCase())) {
        //ll1.add(u.getCity());//this one is also working fine required when you want to print list at once
        out.println(u.getCity() + "<br>");//this also working  prints one by one
    }
}
//out.println(ll1);
}
%>
</body>
</html>