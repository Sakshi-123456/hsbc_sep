<%@page import="com.facebookweb.entity.FacebookUser,com.facebookweb.service.FacebookWebServiceInterface,com.facebookweb.utility.ServiceFactory" %>
<%
		
		FacebookWebServiceInterface fs=ServiceFactory.createObject("adminservice");
		
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		String email=request.getParameter("email");
		String address=request.getParameter("address");
		
		response.setContentType("text/html");
		
		FacebookUser ff=new FacebookUser();
		ff.setName(name);
		ff.setPassword(password);
		ff.setEmail(email);
		ff.setAddress(address);
		
		int i=fs.registerService(ff);
	
		if(i>0) {%>
	        Registration successful <a href=login.html>Continue....</a>
			Your name is <%= name%>
			<br>Your Password is <%= password %>
			 <% } else { %>
		           Could not create profile
		<% } %>
	
		