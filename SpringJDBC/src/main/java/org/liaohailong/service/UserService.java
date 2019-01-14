package org.liaohailong.service;

import org.liaohailong.dao.UserDao;
import org.liaohailong.transaction.TransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;

@Service
public class UserService {
	@Autowired
	private UserDao userDao;
	@Autowired
	private TransactionManager transactionManager;

	public void add() {
		TransactionStatus transactionStatus = null;
		try {
			transactionStatus = transactionManager.begin();
			userDao.add("Œ‚—Â◊Ê", 35);
			int i = 1 / 0;
			userDao.add("≈Ì”⁄ÍÃ", 30);
			transactionManager.commit(transactionStatus);
		} catch (Exception e) {
			if (transactionStatus != null)
				transactionManager.rolBack(transactionStatus);
		}
		System.out.println("UserService add≈‹ÕÍ¡À");
	}
}
