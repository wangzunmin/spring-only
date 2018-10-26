import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by zhangfz on 2017/3/19.
 */
public class TestConsumer{

   
    @SuppressWarnings({ "unused", "resource" })
	public static void main(String[] args) {
    	ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("config/consumer.xml");
	}
}

