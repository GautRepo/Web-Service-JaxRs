package com.nt.testConsumer;

import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
@EnableJms
public class Consumer1 {
	
	@JmsListener(destination = "My-queue")
	private void getMsgFromMOM(String message) {
		System.out.println(message);
	}

}
