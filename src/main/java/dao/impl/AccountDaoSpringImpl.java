package dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import dao.inter.IAccountDao;
import entity.Account;

@Repository
public class AccountDaoSpringImpl implements IAccountDao{

	@Autowired
	private DataSource ds;
	
	@Autowired
	private JdbcTemplate jt;
	
	@Override
	public void saveOrUpdate(Account act) {
		if(act.getId() == 0) {
			String sql = "insert into t_account(actNo,password,enable,createDate,balance) "
					+ "values(?,?,?,?,?)";
			jt.update(sql, new Object[] {act.getActNo(),act.getPassword(),act.isEnable(),act.getCreateDate(),act.getBalance()});
		}else {
			String sql = "update t_account set actNo=?,password=?,enable=?,createDate=?,balance=? where id=?";
			jt.update(sql, new Object[] {act.getActNo(),act.getPassword(),act.isEnable(),act.getCreateDate(),act.getBalance()});
		}
		
	}

	@Override
	public void saveAccounts(List<Account> acts) {
		String sql = "inset into t_account(actNo,password,enable,createDate,balance) values(?,?,?,?,?)";
		List<Object[]> params = new ArrayList<Object[]>();
		for (Account act : acts) {
			Object[] o = new Object[5];
			o[0] = act.getActNo();
			o[1] = act.getPassword();
			o[2] = act.isEnable();
			o[3] = act.getCreateDate();
			o[4] = act.getBalance();
			params.add(o);
		}
		jt.batchUpdate(sql,params);
	}

	@Override
	public void delete(int id) {
		
		//-- jdbc实现
		
		/*try {
			Connection conn = ds.getConnection();
			Statement stat = conn.createStatement();
			String sql = "delete from t_account where id="+id;
			stat.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}*/
		
		//--jdbcTemplate
		jt.update("delete from t_account where id=?",new Object[]{id});
	}

	@Override
	public Account findById(int id) {
		return jt.queryForObject("select * from t_account where id=?",new Object[] {id},new BeanPropertyRowMapper<Account>(Account.class));
	}

	@Override
	public Account findByActNo(String actNo) {
		return jt.queryForObject("select * from t_account where actNo=?",new Object[] {actNo},new BeanPropertyRowMapper<Account>(Account.class));
	}

	@Override
	public List<Account> findAll() {
		return jt.query("select * from t_account",new BeanPropertyRowMapper<Account>(Account.class));
	}

	@Override
	public List<Account> findPaged(int offset, int pageSize) {
		return jt.query("select * from t_account limit ?,?", new Object[] {offset,pageSize},
				new BeanPropertyRowMapper<Account>(Account.class));
	}

}
