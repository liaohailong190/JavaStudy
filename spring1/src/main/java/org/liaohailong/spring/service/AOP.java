package org.liaohailong.spring.service;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

//@Component //添加到容器中去
//@Aspect // 标示为切面
public class AOP {
	/**
	 * 开启事务
	 */
	// 前置通知
	//@Before("execution(* org.liaohailong.spring.service.UserService.add(..))")
	public void begin() {
		System.out.println("事务开启");
	}

	/**
	 * 提交事务
	 */
	//@After("execution(* org.liaohailong.spring.service.UserService.add(..))")
	public void commit() {
		System.out.println("事务提交");
	}

	//@AfterThrowing("execution(* org.liaohailong.spring.service.UserService.add(..))")
	public void error() {
		System.out.println("事务异常");
	}

	//@AfterReturning("execution(* org.liaohailong.spring.service.UserService.add(..))")
	public void run() {
		System.out.println("事务结束，返回！");
	}

	//@Around("execution(* org.liaohailong.spring.service.UserService.add(..))")
	public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		System.out.println("事务环绕，是否允许放行 before");
		proceedingJoinPoint.proceed();
		System.out.println("事务环绕，是否允许放行 after");
	}
}
