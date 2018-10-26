
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.ClassPathResource;

import com.winchampion.credit.pure.circle.A;
import com.winchampion.credit.pure.test.HelloWorld;
import com.winchampion.credit.pure.validation.PersonControl;

public class PersonFactoryTest extends ServiceBaseTest {
	 @Autowired
	 private ApplicationContext context;
	 
	 
	 @Test
	 public void doGetPerson(){
//		 Person person = (Person)context.getBean("personFactory");
//		 System.out.println(person.toString());
//		 Element bean = (Element)context.getBean("element");
//		 System.out.println(bean.getName());
//		 Object bean = context.getBean("&personFactory");
//		 System.out.println(bean.getClass());
		A a =  (A)context.getBean("a");
		a.printA();
	 }
	 
	 
	 @Test
	 public void validateTest(){
		 PersonControl bean = (PersonControl)context.getBean("PersonControl");
		 bean.savePerson(new com.winchampion.credit.pure.validation.Person(3, "qqq") , "sss" , 100 , "243970446@qq.com"); 
	 }
	 
	 @Test
	 public void xmlBeanFactory(){
		 XmlBeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("spring-context.xml"));
		 HelloWorld bean = (HelloWorld)beanFactory.getBean("helloWorldAlias");//alias
		 bean.hello();
	 }
}
