package org.liaohailong.spring.service;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

//@Component //���ӵ�������ȥ
//@Aspect // ��ʾΪ����
public class AOP {
	/**
	 * ��������
	 */
	// ǰ��֪ͨ
	//@Before("execution(* org.liaohailong.spring.service.UserService.add(..))")
	public void begin() {
		System.out.println("������");
	}

	/**
	 * �ύ����
	 */
	//@After("execution(* org.liaohailong.spring.service.UserService.add(..))")
	public void commit() {
		System.out.println("�����ύ");
	}

	//@AfterThrowing("execution(* org.liaohailong.spring.service.UserService.add(..))")
	public void error() {
		System.out.println("�����쳣");
	}

	//@AfterReturning("execution(* org.liaohailong.spring.service.UserService.add(..))")
	public void run() {
		System.out.println("������������أ�");
	}

	//@Around("execution(* org.liaohailong.spring.service.UserService.add(..))")
	public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		System.out.println("�����ƣ��Ƿ��������� before");
		proceedingJoinPoint.proceed();
		System.out.println("�����ƣ��Ƿ��������� after");
	}
}