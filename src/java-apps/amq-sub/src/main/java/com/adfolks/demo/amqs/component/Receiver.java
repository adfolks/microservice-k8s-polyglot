package com.adfolks.demo.amqs.component;

import in.zycon.demo.hawks.models.Email;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;

@Component
public class Receiver {
    @JmsListener(destination = "test")
    public void receiveMessage(Message message) throws JMSException {
        if(message instanceof TextMessage){
            System.out.println(((TextMessage)message).getText());
        }
    }
    @JmsListener(destination = "email")
    public void receiveEmail(Email email) throws JMSException {
        System.out.println(email);
    }
}
