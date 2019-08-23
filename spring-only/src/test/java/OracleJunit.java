import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;

import com.winchampion.credit.pure.oracle.entity.DueDate;
import com.winchampion.credit.pure.oracle.mapper.DueDateMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/mybatis-spring/spring-context.xml"})//这里测试地方用的却是正式环境的配置文件
@TestExecutionListeners({
	DependencyInjectionTestExecutionListener.class,
    DirtiesContextTestExecutionListener.class
    })
public class OracleJunit {

	@Autowired
	private DueDateMapper dueDateMapper;
	
	@Test
	public void oracleTest() {
//		int count = dueDateMapper.count();
//		System.out.println(count);
		List<DueDate> list = dueDateMapper.queryAll();
		System.out.println(list);
	}
}
