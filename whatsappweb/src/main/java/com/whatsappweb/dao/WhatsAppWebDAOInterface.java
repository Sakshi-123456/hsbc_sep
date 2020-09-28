package com.whatsappweb.dao;

import com.whatsappweb.entity.WhatsAppWebUser;

public interface WhatsAppWebDAOInterface {

	int registerDAO(WhatsAppWebUser ff);

	boolean loginDAO(WhatsAppWebUser ff);

}
