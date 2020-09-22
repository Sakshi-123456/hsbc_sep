package com.Facebook2.service;

import java.util.List;

import com.Facebook2.dao.FacebookDao;
import com.Facebook2.dao.FacebookDaoInterface;
import com.Facebook2.entity.FacebookUser;

public class FacebookService implements FacebookServiceInterface{
	private FacebookDaoInterface fd;
	public FacebookService()
	{
		fd=new FacebookDao();
	}
public FacebookUser signInService(FacebookUser fu) 
{
	FacebookUser fu1=fd.signInDao(fu);
	return fu1;
}
public int signUpService(FacebookUser fu) 
{
	int i=fd.signUpDao(fu);
	return i;
}
public int deleteProfileService(FacebookUser fu) {
	int i=fd.deleteProfileDao(fu);
	return i;
}
public List<FacebookUser> searchProfileService(FacebookUser fu) 
{
	List <FacebookUser> ll=fd.searchProfileDao(fu);
	return ll;
}
public FacebookUser viewProfileService(FacebookUser fu)
{
	FacebookUser fu1=fd.viewProfileDao(fu);
	return fu1;
}
public int editProfileByNameService(FacebookUser fu) 
{
	int i=fd.editProfileByNameDao(fu);
	return i;
	
}
public int editProfileByPasswordService(FacebookUser fu) 
{
	int i=fd.editProfileByPasswordDao(fu);
	return i;
	
}

public int editProfileByAddressService(FacebookUser fu) 
{
	int i=fd.editProfileByPasswordDao(fu);
	return i;
	
}
}
