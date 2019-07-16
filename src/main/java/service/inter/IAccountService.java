package service.inter;

import entity.Account;

public interface IAccountService {
	
	//--1.开户
	void openAccount(Account act);
	//--2.销户
	void cancelAccount(int id);
	//--3.转账
	boolean transfer(int fromID,int toID,double money);
	//--4.存钱

}
