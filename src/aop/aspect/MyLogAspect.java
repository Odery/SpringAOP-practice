package aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyLogAspect {

    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_GREEN = "\u001B[32m";

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

    @Before("ifSetting() &&ifInDao() && ifMarker()")
    public void beforeSettingInDao() {
        System.out.println(ANSI_GREEN + ">>>>>>Setting some value in aop.dao package!" + ANSI_RESET);
    }

    @Before("ifSetting() && ifComponent()")
    public void beforeSettingGeneral() {
        System.out.println(ANSI_GREEN + ">>>>>>Setting some value somewhere in app!" + ANSI_RESET);
    }
}
