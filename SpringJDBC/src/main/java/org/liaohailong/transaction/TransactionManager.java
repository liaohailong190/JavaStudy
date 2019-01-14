package org.liaohailong.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.interceptor.DefaultTransactionAttribute;

@Component
public class TransactionManager {
	@Autowired
	private DataSourceTransactionManager dataSourceTransactionManager;

	/**
	 * @return 开启事务，返回状态
	 */
	public TransactionStatus begin() {
		return dataSourceTransactionManager.getTransaction(new DefaultTransactionAttribute());
	}

	/**
	 * @param transactionStatus 执行完毕，提交事务
	 */
	public void commit(TransactionStatus transactionStatus) {
		dataSourceTransactionManager.commit(transactionStatus);
	}
	
	/**
	 * @param transactionStatus 发生异常，回滚事务
	 */
	public void rolBack(TransactionStatus transactionStatus) {
		dataSourceTransactionManager.rollback(transactionStatus);
	}
}
