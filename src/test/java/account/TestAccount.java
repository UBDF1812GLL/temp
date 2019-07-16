package account;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import config.TestConfig;
import dao.inter.IAccountDao;
import entity.Account;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=TestConfig.class)
public class TestAccount {
	
	@Autowired
	private IAccountDao actDao;
	
	/*@Test
	public void testFindAll() {
		List<Account> acts = actDao.findAll();
		for(Account acount: acts) {
			System.out.println(acount);
		}
	}*/
	
	@Test
	public void save() {
		Account acc = new Account();
		acc.setActNo("rdhfgs");
		acc.setPassword("67664");
		acc.setBalance(57737);
		acc.setCreateDate(new Date());
		System.out.println(acc);
		actDao.saveOrUpdate(acc);
		
	}

}
