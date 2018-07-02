package aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class PoincutAspect {
    @Pointcut("execution(* set*(..))")
    public void ifSetting() {
    }

    @Pointcut("within(aop.dao.*)")
    public void ifInDao() {
    }

    @Pointcut("this(aop.dao.MyMarker)")
    public void ifMarker() {
    }

    @Pointcut("@target(org.springframework.stereotype.Component)")
    public void ifComponent() {
    }

}
