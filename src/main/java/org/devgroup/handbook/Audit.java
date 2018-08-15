package org.devgroup.handbook;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class Audit {

    @Pointcut("execution(* org.devgroup.handbook..*(..))")
    public void anyExec(){}

    @Pointcut("execution(* org.devgroup.handbook.Audit.*(..))")
    public void aspectMethods(){}

    @Before(value = "anyExec() && !aspectMethods()")
    public void beforeAdvice(JoinPoint joinPoint){
        System.out.println("Before: " + joinPoint.getSignature());
    }

    @After(value = "anyExec() && !aspectMethods()")
    public void afterCalling(JoinPoint joinPoint) {
        System.out.println("After " + joinPoint.getSignature());
    }
}
