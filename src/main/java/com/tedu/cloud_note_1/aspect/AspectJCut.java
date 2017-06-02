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
@Aspect //¶¨ÒåÇÐÃæÀà
public class AspectJCut {
	ppppppp
	private static Logger logger = LoggerFactory.getLogger(AspectJCut.class);
	//hhh
	@Pointcut("execution(* com.tedu.cloud_note_1.controller..*(..))")
	public void Test(){}
	
	@Before("Test()")
	public void before(){
		logger.info("Ç°ÖÃÍ¨Öª");
	}
	
	@SuppressWarnings("unchecked")
	@Around("Test()")
	public NoteResult<User> around(ProceedingJoinPoint  join){
		logger.info("Ç°ÖÃÍ¨Öª");
		NoteResult<User> rvt = null;
		try {
			 rvt=(NoteResult<User>) join.proceed();
			System.out.println(rvt.getStatus());
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.info("ºóÖÃÍ¨Öª");
		return rvt;
	}
	
	@After("Test()")
	public void after(){
		logger.info("ºóÖÃÍ¨Öª");
	}
	
}
