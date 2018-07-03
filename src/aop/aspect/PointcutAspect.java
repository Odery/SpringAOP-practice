package aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class PointcutAspect {
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

    @Pointcut("execution(java.util.List get*())")
    public void getList() {
    }

    @Pointcut("execution(* *.*(..) throws Exception)")
    public void ifExcIsThrown() {
    }
}
