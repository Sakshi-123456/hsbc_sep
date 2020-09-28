package com.instagramweb.service;

import com.instagramweb.entity.InstagramWebUser;

public interface InstagramWebServiceInterface {

	int registerService(InstagramWebUser ff);

	boolean loginProfile(InstagramWebUser ff);

}
