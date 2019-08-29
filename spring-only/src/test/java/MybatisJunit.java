import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;

import com.winchampion.credit.pure.transaction.entity.User1;
import com.winchampion.credit.pure.transaction.propagation.PropagationOne;
import com.winchampion.credit.pure.transaction.propagation.PropagationThree;
import com.winchampion.credit.pure.transaction.propagation.PropagationTwo;
import com.winchampion.credit.pure.transaction.propagation.Propagationfour;
import com.winchampion.credit.pure.transaction.service.User1Service;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/mybatis-spring/spring-context.xml"})//这里测试地方用的却是正式环境的配置文件
@TestExecutionListeners({
	DependencyInjectionTestExecutionListener.class,
    DirtiesContextTestExecutionListener.class
    })
public class MybatisJunit {
	
	@Autowired
	private User1Service user1Service;
	
	@Autowired
	private PropagationOne propagationOne;
	@Autowired
	private PropagationTwo propagationTwo;
	@Autowired
	private PropagationThree propagationThree;
	@Autowired
	private Propagationfour propagationfour;
	
	
	
	

	@Test
	public void test1(){
		User1 record = new User1();
		record.setName("tom");
		user1Service.insert(record);
	}
	
	@Test
	public void propagationOne(){
		propagationOne.notransaction_exception_required_required();
//		propagationOne.notransaction_required_required_exception();
	}
	
	@Test
	public void propagationTwo(){
		propagationTwo.notransaction_exception_required_required();
//		propagationTwo.notransaction_required_required_exception();
	}
	
	@Test
	public void propagationThree(){
//		propagationThree.notransaction_exception_required_new();
		propagationThree.notransaction_required_new_exception();
	}
	
	
	@Test
	public void propagationfour(){
		propagationfour.notransaction_exception_required_new();
//		propagationfour.notransaction_required_new_exception();
		//版本回退标志
	}
	
	
}
