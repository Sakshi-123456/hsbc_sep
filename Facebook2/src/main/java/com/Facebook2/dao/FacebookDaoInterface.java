package com.Facebook2.dao;

import java.util.List;

import com.Facebook2.entity.FacebookUser;

public interface FacebookDaoInterface {

	FacebookUser signInDao(FacebookUser fu) ;

	int deleteProfileDao(FacebookUser fu) ;

	List<FacebookUser> searchProfileDao(FacebookUser fu) ;

	FacebookUser viewProfileDao(FacebookUser fu) ;

	int editProfileByNameDao(FacebookUser fu) ;

	int editProfileByPasswordDao(FacebookUser fu) ;

	int signUpDao(FacebookUser fu) ;

}
