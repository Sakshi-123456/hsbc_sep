package com.facebookweb.service;

import java.util.List;

import com.facebookweb.entity.FacebookUser;
import com.facebookweb.entity.FacebookWebUser;
import com.facebookweb.entity.IrctcUser;

public interface FacebookWebServiceInterface {

	int registerService(FacebookUser ff);

	boolean loginProfile(FacebookUser ff);

	List<FacebookUser> FriendListService(FacebookUser fe);

	boolean emailValidate(FacebookUser ff);
    
	List<FacebookUser> generateAddress(FacebookUser ff);
	
	List<String> generateCountry();
	
	List<String> Country();
	
	List<String> State(FacebookWebUser ff);
	
	List<String> City(FacebookWebUser ff);
	
	List<IrctcUser> sourceService();
}
