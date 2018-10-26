import javax.annotation.Resource;

import org.junit.Test;

import com.winchampion.credit.pure.pointcut.Sleepable;
import com.winchampion.credit.pure.test.HelloWorld;


public class AopJunit extends ServiceBaseTest {
	
	@Resource
	private HelloWorld helloWorld;
	@Resource(name = "human")
	private Sleepable human;//jdk动态代理注入
	
	@Test
	public void test1(){
		helloWorld.hello();
	}
	
	@Test
	public void test2(){
		human.sleep(); 
	}
}
