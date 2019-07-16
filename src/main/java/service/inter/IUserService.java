package service.inter;

import java.util.List;

import entity.User;

public interface IUserService {

	void addUser(User user);
	
	void deleteUser(int id);
	
	void findById(int id);
	
	List<User> findAll();
	
	void testTransactionManager(); //-- 测试事务
}
