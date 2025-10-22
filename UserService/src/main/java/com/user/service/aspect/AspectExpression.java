package com.user.service.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectExpression {

    public AspectExpression() {}

    @Pointcut("execution(* com.user.service.entities.*.set*(..))")
    public void setter() {}

    @Pointcut("execution(* com.user.service.entities.*.get*(..))")
    public void getter() {}

    @Pointcut("execution(* com.user.service.controllers.*.*(..)) && !(getter() || setter())")
    public void forAllControllers() {}

    @Pointcut("execution(* com.user.service.service.*.*(..)) && !(getter() || setter())")
    public void forAllService() {}

    @Pointcut("execution(* com.user.service.dao.*.*(..)) && !(getter() || setter()) && execution(* com.user.service.repositories.*.*(..))")
    public void forAllDataAccessObject() {}

}

