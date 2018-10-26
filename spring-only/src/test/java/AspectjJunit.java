import javax.annotation.Resource;

import org.junit.Test;

import com.winchampion.credit.pure.proxy.aspectj.App;


public class AspectjJunit extends ServiceBaseTest{
	
	@Resource
	private App app;
	
	@Test
	public void testss(){
		app.say();
	}
}
