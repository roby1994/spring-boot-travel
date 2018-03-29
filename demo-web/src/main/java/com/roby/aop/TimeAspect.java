package com.roby.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * Created by Tao Pingping on 2018/3/21.
 */

@Aspect
@Component
public class TimeAspect {

    @Around("execution(* com.roby.controller.FastjsonController..*(..))")
    public Object method(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("=====Aspect处理=======");
        Object[] args = pjp.getArgs();
        for (Object arg : args) {
            System.out.println("参数为:" + arg);
        }

        long start = System.currentTimeMillis();

        Object object = pjp.proceed();

        System.out.println("Aspect 耗时:" + (System.currentTimeMillis() - start));

        return object;
    }
}
