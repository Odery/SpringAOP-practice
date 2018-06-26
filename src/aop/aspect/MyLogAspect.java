package aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyLogAspect {

    @Pointcut("execution(* set*(..))")
    public void beforeSetting() {
    }

    @Pointcut("within(aop.dao.*)")
    public void beforeInDao() {
    }

    @Before("beforeSetting() && beforeInDao()")
    public void beforeSettingInDao() {
        System.out.println("Setting some value in aop.dao package!");
    }
}
