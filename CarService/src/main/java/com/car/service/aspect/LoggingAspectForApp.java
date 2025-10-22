package com.car.service.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class LoggingAspectForApp {

    Logger logger = Logger.getLogger(String.valueOf(LoggingAspectForApp.class));

    @Before("com.car.service.aspect.AspectExpression.forAppFlow()")
    public void beforeCall(JoinPoint theJoinPoint) {
        MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();
        logger.info("=========================>>>> In before calls to method = " + methodSignature);
        Object[] args = theJoinPoint.getArgs();
        for (Object arg: args) {
            logger.info("=========================>>>>  args = " + arg);
        }
    }

    @AfterReturning(pointcut="com.car.service.aspect.AspectExpression.forAppFlow()",
            returning="theResult")
    public void afterReturnCall(JoinPoint theJoinPoint, Object theResult) {
        MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();
        logger.info("=========================>>>> AfterReturning calls from to method = " + methodSignature);
        logger.info("=========================>>>> AfterReturning results = " + theResult);
    }
}






