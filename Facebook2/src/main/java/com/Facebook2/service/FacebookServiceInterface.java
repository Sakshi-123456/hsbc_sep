package com.Facebook2.service;

import java.util.List;

import com.Facebook2.entity.FacebookUser;

public interface FacebookServiceInterface {

FacebookUser signInService(FacebookUser fu) ;

int deleteProfileService(FacebookUser fu);

List<FacebookUser> searchProfileService(FacebookUser fu) ;

FacebookUser viewProfileService(FacebookUser fu) ;

int editProfileByNameService(FacebookUser ff) ;

int editProfileByPasswordService(FacebookUser fu1) ;

int editProfileByAddressService(FacebookUser fu1) ;

int signUpService(FacebookUser fu) ;

}
