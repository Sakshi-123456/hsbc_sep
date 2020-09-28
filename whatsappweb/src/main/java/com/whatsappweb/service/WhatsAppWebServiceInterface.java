package com.whatsappweb.service;

import com.whatsappweb.entity.WhatsAppWebUser;

public interface WhatsAppWebServiceInterface {

	int registerService(WhatsAppWebUser ff);

	boolean loginProfile(WhatsAppWebUser ff);

}
