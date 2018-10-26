import org.junit.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

import com.winchampion.credit.pure.aop.MyInvocationHandler;
import com.winchampion.credit.pure.aop.UserService;
import com.winchampion.credit.pure.aop.UserServiceImpl;


public class SpringTest {

	@SuppressWarnings("unused")
	@Test
	public void beanTest(){
		ClassPathResource classPathResource = new ClassPathResource("spring-context.xml");
		
	}
	
	@Test
	public void testProxy(){
		// 实例化目标对象  
        UserService userService = new UserServiceImpl();  
          
        // 实例化InvocationHandler  
        MyInvocationHandler invocationHandler = new MyInvocationHandler(userService);  
          
        // 根据目标对象生成代理对象  
        UserService proxy = (UserService) invocationHandler.getProxy();  
          
        // 调用代理对象的方法  
        proxy.add();  
	}
	
	/**
	 * 编程式使用ioc容器
	 */
	@Test
	public void testBeanFactory(){
		//replace @See XmlBeanFactory
		ClassPathResource classPathResource = new ClassPathResource("spring-context.xml");
		DefaultListableBeanFactory defaultFactory = new DefaultListableBeanFactory();
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(defaultFactory);
		reader.loadBeanDefinitions(classPathResource);
	}
}
