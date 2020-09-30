package com.facebookview.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.facebookweb.entity.FacebookUser;
import com.facebookweb.service.FacebookWebServiceInterface;
import com.facebookweb.utility.ServiceFactory;

/**
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		FacebookWebServiceInterface fs=ServiceFactory.createObject("adminservice");
		
		String name=request.getParameter("name");//arguments will be from html (name=name)
		String password=request.getParameter("password");//arguments will be from html (name=password)
		String email=request.getParameter("email");//arguments will be from html (name=email)
		String address=request.getParameter("address");//arguments will be from html (name=password)
		
		response.setContentType("text/html");//format for response
		PrintWriter out=response.getWriter();//write response on the browser- print statement
		
		FacebookUser ff=new FacebookUser();
		ff.setName(name);
		ff.setPassword(password);
		ff.setEmail(email);
		//ff.setAddress(address);
		boolean b=fs.emailValidate(ff);
		int i=fs.registerService(ff);
		out.println("<html><body>");
		if(i>0)
		{
			out.println("Registration successful <a href=login.html>Continue....</a>");
			out.println("Your name is "+name);
			out.println("Your password is "+password);
		}
		else
		{
			out.println("Could not create profile");
		}
		out.println("</html></body>");
		/*out.println("<html><body>");//print info after clicking register button
			out.println("Your name is"+n1);
			out.println("<br> Your password is "+n2);
			out.println("<br> Your email is "+n3);
			out.println("<br> Your address is "+n4);
		out.println("</html></body>");
		*/
	}

	
}
