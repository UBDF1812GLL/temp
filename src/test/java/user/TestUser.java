package user;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import config.AppConfig;
import config.TestConfig;
import dao.inter.IUserDao;
import entity.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=TestConfig.class)
public class TestUser {
	
	@Autowired
	private IUserDao userDao;
	
/*	@Test
	public void findAll(){
		List<User> users = userDao.findAll();
		for(User user : users) {
			System.out.println(user);
		}
	}*/
	
	@Test
	public void deleteUser() {
		userDao.deleteUser(3);
		List<User> users = userDao.findAll();
		for(User user : users) {
			System.out.println(user);
		}
	}	
	
/*	@Test
	public void findById() {
		User user = userDao.findById(3);
		System.out.println(user);
	}*/
	
	@Test
	public void addUser() {
		User user = new User("cvmgnfx","123456",1);
		userDao.addUser(user);
		List<User> users = userDao.findAll();
		for(User u : users) {
			System.out.println(u);
		}
	}

}
