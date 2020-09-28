package com.whatsappweb.service;


import com.whatsappweb.dao.WhatsAppWebDAOInterface;
import com.whatsappweb.entity.WhatsAppWebUser;
import com.whatsappweb.utility.DAOFactory;

public class WhatsAppWebService implements WhatsAppWebServiceInterface {
	WhatsAppWebDAOInterface wd;
	public WhatsAppWebService()
	{
		wd=DAOFactory.createObject("admindao");
	}
	public int registerService(WhatsAppWebUser ff) {
		// TODO Auto-generated method stub
		return wd.registerDAO(ff);
	}
	
	public boolean loginProfile(WhatsAppWebUser ff) {
		// TODO Auto-generated method stub
		return wd.loginDAO(ff);
	}

}
