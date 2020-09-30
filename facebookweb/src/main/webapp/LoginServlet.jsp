<%@page import="com.facebookweb.entity.FacebookUser,com.facebookweb.service.FacebookWebServiceInterface, com.facebookweb.utility.ServiceFactory" %>


		<%
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		
		
		FacebookUser ff=new FacebookUser();
		ff.setName(name);
		ff.setPassword(password);
		
		
		FacebookWebServiceInterface fs=ServiceFactory.createObject("adminservice");
		boolean i=fs.loginProfile(ff);
		
		response.setContentType("text/html");
	
	
		if(i) {
			
			HttpSession ss=request.getSession(true);
			ss.setAttribute("userid", name);
			ss.setAttribute("pass", password);
			%>
			welcome <%= name %>   <a href=TimeLine>timeline</a>   <a href=FriendList.html>FriendList</a>
			<% }else{ %>
		         Invalid id and password
		 <%@ include file="login.html" %>
		 
			
			
		
<% } %>
