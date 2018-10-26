import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.winchampion.credit.pure.activeMq.producer.ActiveMQProducer;

/**
 * Created by zhangfz on 2017/3/19.
 */
public class TestProducer{
	

   
    @Test
    public void send(){
    	ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("config/producer.xml");
    	ActiveMQProducer activeMQProducer = (ActiveMQProducer)applicationContext.getBean("activeMQProducer");
    	for(int i =0;i<1000;i++){
    		activeMQProducer.sendMessage("producer produce msg: the message come from Spring!" + i);
    	}
    	applicationContext.close();
    }
}
