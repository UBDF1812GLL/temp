package dao.inter;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import entity.User;

@Mapper
public interface IUserDao {
	
	void addUser(User user);
	
	void deleteUser(int id);
	
	User findById(int id);
	
	List<User> findAll();

}
