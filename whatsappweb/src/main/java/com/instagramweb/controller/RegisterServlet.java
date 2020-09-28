package com.instagramweb.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.whatsappweb.entity.WhatsAppWebUser;
import com.whatsappweb.service.WhatsAppWebServiceInterface;
import com.whatsappweb.utility.ServiceFactory;

/**
 * Servlet implementation class RegisterProfile
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
  
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
       WhatsAppWebServiceInterface fs=ServiceFactory.createObject("adminservice");
		
		String name=request.getParameter("name");//arguments will be from html (name=name)
		String password=request.getParameter("password");//arguments will be from html (name=password)
		String email=request.getParameter("email");//arguments will be from html (name=email)
		String address=request.getParameter("address");//arguments will be from html (name=password)
		
		response.setContentType("text/html");//format for response
		PrintWriter out=response.getWriter();//write response on the browser- print statement
		
		WhatsAppWebUser ff=new WhatsAppWebUser();
		ff.setName(name);
		ff.setPassword(password);
		ff.setEmail(email);
		ff.setAddress(address);
		
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
	}

}
