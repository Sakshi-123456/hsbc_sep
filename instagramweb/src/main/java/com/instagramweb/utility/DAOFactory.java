package com.instagramweb.utility;


import com.instagramweb.dao.InstagramWebDAO;
import com.instagramweb.dao.InstagramWebDAOInterface;

public class DAOFactory {
private DAOFactory()
{
	
}
public static InstagramWebDAOInterface createObject(String nn)
{
	InstagramWebDAOInterface id=null;
	if(nn.equals("admindao"))
		id=new InstagramWebDAO();
	return id;
}
}
