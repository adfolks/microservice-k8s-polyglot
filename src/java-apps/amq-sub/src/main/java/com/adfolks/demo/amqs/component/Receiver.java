package com.adfolks.demo.amqs.component;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;

@Component
public class Receiver {
    @JmsListener(destination = "email")
    public void receiveMessage(Message message) throws JMSException {
        if(message instanceof TextMessage){
            System.out.println(((TextMessage)message).getText());
        }
    }
}
