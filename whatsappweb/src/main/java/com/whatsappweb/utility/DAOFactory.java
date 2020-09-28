package com.whatsappweb.utility;



import com.whatsappweb.dao.WhatsAppWebDAO;
import com.whatsappweb.dao.WhatsAppWebDAOInterface;

public class DAOFactory {
private DAOFactory()
{
	
}
public static WhatsAppWebDAOInterface createObject(String nn)
{
	WhatsAppWebDAOInterface id=null;
	if(nn.equals("admindao"))
		id=new WhatsAppWebDAO();
	return id;
}
}
