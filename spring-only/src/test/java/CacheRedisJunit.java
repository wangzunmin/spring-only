import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;

import com.winchampion.credit.pure.redis.test.RedisCacheDemoService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/redis/spring-redis-context.xml"})//这里测试地方用的却是正式环境的配置文件
@TestExecutionListeners({
	DependencyInjectionTestExecutionListener.class,
    DirtiesContextTestExecutionListener.class
    })
public class CacheRedisJunit{
	@Autowired
	private RedisCacheDemoService redisCacheDemoService;
	
	@Test
	public void cacheTest(){
		String string = redisCacheDemoService.getString();
		System.out.println(string);
	}
	
	@Test
	public void cacheTest2(){
		String string = redisCacheDemoService.saveString("str");
		System.out.println(string);
	}
	
	@Test
	public void cacheTest3(){
		redisCacheDemoService.removeString("str");
	}
}
