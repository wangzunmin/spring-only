import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/spring-context.xml"})//这里测试地方用的却是正式环境的配置文件
@TestExecutionListeners({
	DependencyInjectionTestExecutionListener.class,
    DirtiesContextTestExecutionListener.class
    })
public abstract class ServiceBaseTest {

	protected Logger logger=Logger.getLogger(ServiceBaseTest.class);
	
	@Test
	public void testAppContext() {
		logger.info("测试Service业务层   start 采用spring junit 框架 数据可以回滚>>>>>>>>>");
	}
	
}