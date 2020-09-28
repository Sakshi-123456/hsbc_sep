package com.whatsappweb.utility;


import com.whatsappweb.service.WhatsAppWebService;
import com.whatsappweb.service.WhatsAppWebServiceInterface;

public class ServiceFactory {
	private ServiceFactory()
	{
		
	}
	public static WhatsAppWebServiceInterface createObject(String nn)
	{
		WhatsAppWebServiceInterface is=null;
		if(nn.equals("adminservice"))
			is=new WhatsAppWebService();
		return is;
	}
}
