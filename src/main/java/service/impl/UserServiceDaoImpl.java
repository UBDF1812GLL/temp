package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.inter.IUserDao;
import entity.User;
import service.inter.IUserService;

@Service
public class UserServiceDaoImpl implements IUserService{
	
	@Autowired
	private IUserDao userDao;

	@Override //--业务方法
	@Transactional //-- 如果业务处理标注表示是否告诉Spring框架需要事务处理
	public void testTransactionManager() {
		//-- step1
		User user = new User("dinsf","efsd",0);
		userDao.addUser(user);
		List<User> users = userDao.findAll();
		for(User u : users) {
			System.out.println(u);
		}
		
		//--construtor exception
		int i= 3/0;
		//--throw new RuntimeException();
		
		//-- step2
		userDao.deleteUser(10);
	}
	

	@Override
	public void addUser(User user) {
		
	}

	@Override
	public void deleteUser(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void findById(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
