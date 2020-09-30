package com.facebookweb.utility;

import com.facebookweb.service.FacebookWebService;
import com.facebookweb.service.FacebookWebServiceInterface;

public class ServiceFactory {
	private ServiceFactory()
	{
		
	}
	public static FacebookWebServiceInterface createObject(String nn)
	{
		FacebookWebServiceInterface is=null;
		if(nn.equals("adminservice"))
			is=new FacebookWebService();
		return is;
	}
}
