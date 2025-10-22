package com.user.service.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;



@Aspect
@Component
@Order(1)
public class LoggingControllerAspect {

    public LoggingControllerAspect() {}

    @Before("com.user.service.aspect.AspectExpression.forAllControllers()")
    public void controllerBefore(JoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("=========================>>>>  Controller method = " + methodSignature);
    }
}
