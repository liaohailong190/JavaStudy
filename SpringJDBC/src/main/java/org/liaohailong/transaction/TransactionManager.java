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
	 * @return �������񣬷���״̬
	 */
	public TransactionStatus begin() {
		return dataSourceTransactionManager.getTransaction(new DefaultTransactionAttribute());
	}

	/**
	 * @param transactionStatus ִ����ϣ��ύ����
	 */
	public void commit(TransactionStatus transactionStatus) {
		dataSourceTransactionManager.commit(transactionStatus);
	}
	
	/**
	 * @param transactionStatus �����쳣���ع�����
	 */
	public void rolBack(TransactionStatus transactionStatus) {
		dataSourceTransactionManager.rollback(transactionStatus);
	}
}
