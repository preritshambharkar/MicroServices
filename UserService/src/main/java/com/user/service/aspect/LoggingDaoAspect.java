package com.user.service.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class LoggingDaoAspect {

    public LoggingDaoAspect() {
    }

    @Before("com.user.service.aspect.AspectExpression.forAllDataAccessObject()")
    public void beforeDaoAspect(JoinPoint theJoinPoint) {
        MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();
        System.out.println("=========================>>>>  Dao method = " + methodSignature);
    }
}
