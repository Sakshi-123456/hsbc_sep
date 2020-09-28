package com.instagramweb.service;


import com.instagramweb.dao.InstagramWebDAOInterface;
import com.instagramweb.entity.InstagramWebUser;
import com.instagramweb.utility.DAOFactory;

public class InstagramWebService implements InstagramWebServiceInterface {
	InstagramWebDAOInterface wd;
	public InstagramWebService()
	{
		wd=DAOFactory.createObject("admindao");
	}
	public int registerService(InstagramWebUser ff) {
		// TODO Auto-generated method stub
		return wd.registerDAO(ff);
	}
	@Override
	public boolean loginProfile(InstagramWebUser ff) {
		// TODO Auto-generated method stub
		return wd.loginDAO(ff);
	}

}
