package com.instagramweb.dao;

import com.instagramweb.entity.InstagramWebUser;

public interface InstagramWebDAOInterface {

	int registerDAO(InstagramWebUser ff);

	boolean loginDAO(InstagramWebUser ff);

}
