package aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Order(1)
@Component
public class MyAspect {

    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_BLUE = "\u001B[34m";

    @Before("aop.aspect.PoincutAspect.ifMarker()")
    public void beforeSet() {
        System.out.println(ANSI_BLUE + ">>>>>>Setting some value in aop.dao package!" + ANSI_RESET);
    }

    @Before("aop.aspect.PoincutAspect.ifSetting() && aop.aspect.PoincutAspect.ifComponent()")
    public void beforeSettingGeneral() {
        System.out.println(ANSI_BLUE + ">>>>>>Setting some value somewhere in app!" + ANSI_RESET);
    }

    @Before("@within(aop.test.ClassRetAnnotation)")
    public void within() {
        System.out.println(ANSI_BLUE + ">>>>>>within" + ANSI_RESET);
    }

    @Before("@target(aop.test.RuntimeRetAnnotation)")
    public void target() {
        System.out.println(ANSI_BLUE + ">>>>>>target" + ANSI_RESET);
    }

}
