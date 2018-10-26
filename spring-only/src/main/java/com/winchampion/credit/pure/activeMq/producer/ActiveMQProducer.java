package com.winchampion.credit.pure.activeMq.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

/**
 * Created by zhangfz on 2017/3/19.
 */
//@Service("activeMQProducer")
public class ActiveMQProducer {

    private JmsTemplate jmsTemplate;

    public JmsTemplate getJmsTemplate() {
        return jmsTemplate;
    }

    @Autowired
    public void setJmsTemplate(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public void sendMessage(final String info) {
        jmsTemplate.send(new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
            	TextMessage message = session.createTextMessage(info);
            	System.out.println(message.getText());
                return message;
            }
        });
    }
}
