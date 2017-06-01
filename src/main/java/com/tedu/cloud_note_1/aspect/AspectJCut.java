package com.tedu.cloud_note_1.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.tedu.cloud_note_1.entity.User;
import com.tedu.cloud_note_1.util.NoteResult;
@Component
@Aspect //定义切面类
public class AspectJCut {
	private static Logger logger = LoggerFactory.getLogger(AspectJCut.class);

	@Pointcut("execution(* com.tedu.cloud_note_1.controller..*(..))")
	public void Test(){}
	
	@Before("Test()")
	public void before(){
		logger.info("前置通知");
	}
	
	@SuppressWarnings("unchecked")
	@Around("Test()")
	public NoteResult<User> around(ProceedingJoinPoint  join){
		logger.info("前置通知");
		NoteResult<User> rvt = null;
		try {
			 rvt=(NoteResult<User>) join.proceed();
			System.out.println(rvt.getStatus());
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.info("后置通知");
		return rvt;
	}
	
	@After("Test()")
	public void after(){
		logger.info("后置通知");
	}
	
}
