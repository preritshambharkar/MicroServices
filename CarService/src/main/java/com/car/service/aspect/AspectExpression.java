package com.car.service.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectExpression {

    public AspectExpression() {}

    @Pointcut("execution(* com.car.service.controllers.*.*(..))")
    public void forAllControllers() {}

    @Pointcut("execution(* com.car.service.service.*.*(..))")
    public void forAllServices() {}

    @Pointcut("execution(* com.car.service.dao.*.*(..))")
    public void forAllDataAccessObject() {}

    @Pointcut("forAllControllers() || forAllServices() || forAllDataAccessObject()")
    public void forAppFlow() {}

}
