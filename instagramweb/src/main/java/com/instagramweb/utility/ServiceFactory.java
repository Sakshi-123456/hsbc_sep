package com.instagramweb.utility;


import com.instagramweb.service.InstagramWebService;
import com.instagramweb.service.InstagramWebServiceInterface;

public class ServiceFactory {
	private ServiceFactory()
	{
		
	}
	public static InstagramWebServiceInterface createObject(String nn)
	{
		InstagramWebServiceInterface is=null;
		if(nn.equals("adminservice"))
			is=new InstagramWebService();
		return is;
	}
}
