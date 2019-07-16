package service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.inter.IAccountDao;
import entity.Account;
import service.inter.IAccountService;

@Service
public class AccountServiceDaoImpl implements IAccountService{

	@Autowired
	private IAccountDao actDao;
	
	@Override
	public void openAccount(Account act) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cancelAccount(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean transfer(int fromID, int toID, double money) {
		// TODO Auto-generated method stub
		return false;
	}

	
}
