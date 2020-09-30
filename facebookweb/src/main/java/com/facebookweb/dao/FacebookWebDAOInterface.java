package com.facebookweb.dao;

import java.util.List;

import com.facebookweb.entity.FacebookUser;
import com.facebookweb.entity.FacebookWebUser;
import com.facebookweb.entity.IrctcUser;

public interface FacebookWebDAOInterface {

	int registerDAO(FacebookUser ff);

	boolean loginDAO(FacebookUser ff);

	List<FacebookUser> FriendListDAO(FacebookUser ff);

	boolean validateEmailDAO(FacebookUser ff);

	

	List<FacebookUser> generateAddressDAO(FacebookUser ff);

	List<String> generateCountryDAO();

	List<String> countryDAO();

	List<String> StateDao(FacebookWebUser ff);

	List<String> CityDao(FacebookWebUser ff);

	List<IrctcUser> sourceDao();

}
