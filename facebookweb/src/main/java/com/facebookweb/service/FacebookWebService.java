package com.facebookweb.service;

import java.util.List;

import com.facebookweb.dao.FacebookWebDAOInterface;
import com.facebookweb.entity.FacebookUser;
import com.facebookweb.entity.FacebookWebUser;
import com.facebookweb.entity.IrctcUser;
import com.facebookweb.utility.DAOFactory;

public class FacebookWebService implements FacebookWebServiceInterface {
	FacebookWebDAOInterface fd;
public FacebookWebService()
{
	fd=DAOFactory.createObject("admindao");
}
	
	public int registerService(FacebookUser ff) {
		// TODO Auto-generated method stub
		return fd.registerDAO(ff);
	}
	
	public boolean loginProfile(FacebookUser ff) {
		// TODO Auto-generated method stub
		return fd.loginDAO(ff);
	}
	
	public List<FacebookUser> FriendListService(FacebookUser ff) {
		// TODO Auto-generated method stub
		return fd.FriendListDAO(ff);
	}
	
	public boolean emailValidate(FacebookUser ff) {
		// TODO Auto-generated method stub
		return fd.validateEmailDAO(ff);
	}
	@Override
	public List<FacebookUser> generateAddress(FacebookUser ff) {
		// TODO Auto-generated method stub
		return fd.generateAddressDAO(ff);
	}
	@Override
	public List<String> generateCountry() {
		// TODO Auto-generated method stub
		return fd.generateCountryDAO();
	}

	@Override
	public List<String> Country() {
		// TODO Auto-generated method stub
		return fd.countryDAO();
	}

	@Override
	public List<String> State(FacebookWebUser ff) {
		// TODO Auto-generated method stub
		System.out.println(ff.getCountry());
		return fd.StateDao(ff);
	}

	@Override
	public List<String> City(FacebookWebUser ff) {
		// TODO Auto-generated method stub
		return fd.CityDao(ff);
	}

	@Override
	public List<IrctcUser> sourceService() {
		// TODO Auto-generated method stub
		return fd.sourceDao();
	}
	
	

}
