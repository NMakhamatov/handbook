package ru.tsc.practice.audit;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.*;

//import static java.util.concurrent.Executors;

@Aspect
@Configuration
@Service
public class Audit {
//    @Autowired
    private static AuditDao auditDao;

    @Autowired
    public Audit(AuditDao auditDao) {
        Audit.auditDao = auditDao;
    }

    //    @Autowired
//    public  void setAuditDao(AuditDao auditDao) {
//        this.auditDao = auditDao;
//    }

    @Pointcut("execution(* ru.tsc.practice.employee.controller.EmployeeEntityControllerImpl.*(..))")
    public void employeeMethods(){}

    @Pointcut("execution(* ru.tsc.practice.audit.Audit.*(..))")
    public void aspectMethods(){}

    @Before(value = "employeeMethods() && !aspectMethods()")
    public void beforeAdvice(JoinPoint joinPoint){
        System.out.println("Before: " + joinPoint.getSignature());
        toDao.add(new AuditEntity(
                "127.0.0.1",
                new Date()
                ,joinPoint.getSignature().toString()
        ));
    }

    @After(value = "employeeMethods() && !aspectMethods()")
    public void afterCalling(JoinPoint joinPoint) {
        System.out.println("After: " + toDao.size());
    }

//    private volatile static Queue<AuditEntity> toDao = Collections.synchronizedList(new LinkedList<AuditEntity>());

    private volatile static BlockingQueue<AuditEntity> toDao = new LinkedBlockingQueue<>();

//    private volatile static Queue<AuditEntity> queue ;

    private static final ScheduledExecutorService shedule = Executors.newSingleThreadScheduledExecutor();

    static {
        shedule.scheduleWithFixedDelay(
                new PersistAudit()
                ,0
                ,3
                , TimeUnit.MINUTES
        );
    }

    static class PersistAudit implements Runnable {
            @Override
            public void run() {
                System.out.println("PersistAudit is started!\ntoDao size is : " + toDao.size());
                if (toDao.size() != 0) {
                    System.out.println("in run()");
                    while (!toDao.isEmpty()) {
                        auditDao.create(toDao.poll());
                    }
                }
                System.out.println("PersistAudit is done!");
            }
            private void persist(){
                for (AuditEntity entity : toDao) {
                    auditDao.create(entity);
                    System.out.println("Created entity in DB");
                }
            }
    }

}
