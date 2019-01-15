package org.liaohailong.service;

import org.liaohailong.dao.LogDao;
import org.liaohailong.dao.UserDao;
import org.liaohailong.transaction.TransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

@Service
public class UserService {
	@Autowired
	private UserDao userDao;
	@Autowired
	private LogDao logDao;
//	@Autowired
//	private TransactionManager transactionManager;

//	public void add() {
//		TransactionStatus transactionStatus = null;
//		try {
//			transactionStatus = transactionManager.begin();
//			userDao.add("吴彦祖", 35);
//			int i = 1 / 0;
//			userDao.add("彭于晏", 30);
//			transactionManager.commit(transactionStatus);
//		} catch (Exception e) {
//			if (transactionStatus != null)
//				transactionManager.rolBack(transactionStatus);
//		}
//		System.out.println("UserService add跑完了");
//	}

//	public void add() {
//		try {
//			userDao.add("吴彦祖", 35, "男");
//			int i = 1 / 0;
//			userDao.add("彭于晏", 30, "男");
//		} catch (Exception e) {
//			//手动回滚
//			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
//			System.out.println("执行异常，数据回滚!");
//		}
//	}

//	@Transactional
//	public void add() {
//		try {
//			userDao.add("吴彦祖", 35, "男");
//			int i = 1 / 0;
//			userDao.add("彭于晏", 30, "男");
//		} catch (Exception e) {
//			// 手动回滚
//			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
//			System.out.println("执行异常，数据回滚!");
//		}
//	}
	
	//REQUIRES 默认使用事务执行
	//REQUIRES_NEW 当前有事务的话，不用当前的事务，开启一个新的事务
	//SUPPORTS 支持当前事务，如果没有事务，就以非事务方式执行
	//MANDATORY 当前如果没有事务，就抛出异常
	//NOT_SUPPORTED 以非事务方式执行，如果当前有事务，就将事务先挂起
	//NEVER 以非事务方式执行，如果存在事务，就抛出异常
	// REQUIRES + REQUIRES_NEW 重要， 其他的略知即可。
	@Transactional(propagation = Propagation.NEVER)
	public void addLog() {
		logDao.add("UserService", "来自UserService的Log消息");
		userDao.add("彭于晏", 30, "男");
		int i = 1 / 0;
	}
}
