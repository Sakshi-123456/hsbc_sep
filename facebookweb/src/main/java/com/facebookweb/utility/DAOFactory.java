package com.facebookweb.utility;

import com.facebookweb.dao.FacebookWebDAO;
import com.facebookweb.dao.FacebookWebDAOInterface;
import com.facebookweb.service.FacebookWebService;
import com.facebookweb.service.FacebookWebServiceInterface;

public class DAOFactory {
private DAOFactory()
{
	
}
public static FacebookWebDAOInterface createObject(String nn)
{
	FacebookWebDAOInterface id=null;
	if(nn.equals("admindao"))
		id=new FacebookWebDAO();
	return id;
}
}
