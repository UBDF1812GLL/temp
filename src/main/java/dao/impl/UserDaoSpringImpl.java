package dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import dao.inter.IUserDao;
import entity.User;

@Repository
public class UserDaoSpringImpl implements IUserDao{
	
	@Autowired
	private JdbcTemplate jt;

	@Override
	public void addUser(User user) {
		String sql = "insert into t_user(name,password,state) values(?,?,?)";
		jt.update(sql,new Object[] {user.getName(),user.getPassword(),user.getState()});
	}

	@Override
	public void deleteUser(int id) {
		jt.update("delete from t_user where id=?", new Object[] {id});
	}

	@Override
	public User findById(int id) {
		return jt.queryForObject("select * from t_user where id=?",new Object[] {id},new BeanPropertyRowMapper<User>(User.class));
	}

	@Override
	public List<User> findAll() {
		return jt.query("select * from t_user", new BeanPropertyRowMapper<User>(User.class));
	}

}
