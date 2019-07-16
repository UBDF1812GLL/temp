package dao.inter;

import java.sql.Connection;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import entity.Account;

public interface IAccountDao {
	
	void saveOrUpdate(Account act);
	void saveAccounts(List<Account> acts);
	
	void delete(int id);
	Account findById(int id);
	Account findByActNo(String actNo);
	List<Account> findAll();
	List<Account> findPaged(int offset,int pageSize);
	
	//void saveOrUpdate(Connection conn,Account act);
	
}
