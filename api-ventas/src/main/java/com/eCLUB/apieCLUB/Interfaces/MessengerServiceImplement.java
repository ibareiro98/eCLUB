package com.eCLUB.apieCLUB.Interfaces;

import org.springframework.beans.factory.annotation.Autowired;
import com.eCLUB.apieCLUB.messengerService.Publisher;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MessengerServiceImplement implements MessengerService{
    
    @Autowired
	private Publisher publisher;
	
	public void sendToRabbit(String message) {	
        log.info("Message '{}' will be send ... ", message);
		this.publisher.sendVentas(message);
	}
}