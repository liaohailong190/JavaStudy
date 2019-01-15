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
//			userDao.add("������", 35);
//			int i = 1 / 0;
//			userDao.add("������", 30);
//			transactionManager.commit(transactionStatus);
//		} catch (Exception e) {
//			if (transactionStatus != null)
//				transactionManager.rolBack(transactionStatus);
//		}
//		System.out.println("UserService add������");
//	}

//	public void add() {
//		try {
//			userDao.add("������", 35, "��");
//			int i = 1 / 0;
//			userDao.add("������", 30, "��");
//		} catch (Exception e) {
//			//�ֶ��ع�
//			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
//			System.out.println("ִ���쳣�����ݻع�!");
//		}
//	}

//	@Transactional
//	public void add() {
//		try {
//			userDao.add("������", 35, "��");
//			int i = 1 / 0;
//			userDao.add("������", 30, "��");
//		} catch (Exception e) {
//			// �ֶ��ع�
//			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
//			System.out.println("ִ���쳣�����ݻع�!");
//		}
//	}
	
	//REQUIRES Ĭ��ʹ������ִ��
	//REQUIRES_NEW ��ǰ������Ļ������õ�ǰ�����񣬿���һ���µ�����
	//SUPPORTS ֧�ֵ�ǰ�������û�����񣬾��Է�����ʽִ��
	//MANDATORY ��ǰ���û�����񣬾��׳��쳣
	//NOT_SUPPORTED �Է�����ʽִ�У������ǰ�����񣬾ͽ������ȹ���
	//NEVER �Է�����ʽִ�У�����������񣬾��׳��쳣
	// REQUIRES + REQUIRES_NEW ��Ҫ�� ��������֪���ɡ�
	@Transactional(propagation = Propagation.NEVER)
	public void addLog() {
		logDao.add("UserService", "����UserService��Log��Ϣ");
		userDao.add("������", 30, "��");
		int i = 1 / 0;
	}
}
