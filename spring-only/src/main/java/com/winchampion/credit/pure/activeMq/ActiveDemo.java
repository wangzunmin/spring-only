package com.winchampion.credit.pure.activeMq;

import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

public class ActiveDemo {
	public static void main(String[] args) throws JMSException {
		createConsumer();
	}
	
	/**
	 * 生产者
	 * @throws JMSException
	 */
	public static void createProduce() throws JMSException{
		//第一步：创建ConnectionFactory连接工厂
		ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(
				ActiveMQConnectionFactory.DEFAULT_USER,
				ActiveMQConnectionFactory.DEFAULT_PASSWORD,
				ActiveMQConnectionFactory.DEFAULT_BROKER_URL);
		//第二步：创建Connection
		Connection connection = activeMQConnectionFactory.createConnection();//应用程序和消息服务器之间的通信链路
		connection.start();
		//第三步：创建Session
		Session session = connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);//Session，用于发送和接受消息，而且是单线程的，支持事务的
		//第四步：创建Destination
		Destination destination = session.createQueue("queueB");//消息目标，就是消息发送和接受的地点，要么queue，要么topic
		//第五步：创建MessageProducer
		MessageProducer producer = session.createProducer(destination);
		//第六步：设置持久化方式. 如果非持久化 那么mq重启后导致消息丢失 
		producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
		//第七步：定义消息对象，并发送
		TextMessage textMessage = session.createTextMessage("Hello ActiveMq");
		producer.send(textMessage);
		//第八步：释放连接
		if(connection != null){
			connection.close();
		}
	}
	
	public static void createConsumer() throws JMSException{
		//第一步：创建ConnectionFactory连接工厂
			ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(
					ActiveMQConnectionFactory.DEFAULT_USER,
					ActiveMQConnectionFactory.DEFAULT_PASSWORD,
					ActiveMQConnectionFactory.DEFAULT_BROKER_URL);
			//第二步：创建Connection
			Connection connection = activeMQConnectionFactory.createConnection();//应用程序和消息服务器之间的通信链路
			connection.start();
			//第三步：创建Session
			Session session = connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);//Session，用于发送和接受消息，而且是单线程的，支持事务的
			//第四步：创建Destination
			Destination destination = session.createQueue("queueB");//消息目标，就是消息发送和接受的地点，要么queue，要么topic
			//第五步：创建MessageProducer
			MessageConsumer consumer = session.createConsumer(destination);
			consumer.setMessageListener(new MessageListener() {
				
				public void onMessage(Message message) {
					if(message instanceof TextMessage){
						String text;
						try {
							text = ((TextMessage) message).getText();
							System.out.println(text);
						} catch (JMSException e) {
							e.printStackTrace();
						}
					}
				}
			});
			//第八步：释放连接
			if(connection != null){
				connection.close();
			}
	}
}
