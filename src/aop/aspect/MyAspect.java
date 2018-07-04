package aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Order(1)
@Component
public class MyAspect {

    private static Logger logger = Logger.getLogger(MyAspect.class.getName());
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_BLUE = "\u001B[34m";

    @Before("aop.aspect.PointcutAspect.ifMarker()")
    public void beforeSet(JoinPoint joinPoint) {
        logger.info(ANSI_BLUE + ">>>>>>Setting some value in " + joinPoint.getSignature() + ANSI_RESET);
    }

    @Before("aop.aspect.PointcutAspect.ifSetting() && aop.aspect.PointcutAspect.ifComponent()")
    public void beforeSettingGeneral() {
        logger.info(ANSI_BLUE + ">>>>>>Setting some value somewhere in app!" + ANSI_RESET);
    }

    @Before("@within(aop.test.ClassRetAnnotation)")
    public void within() {
        logger.info(ANSI_BLUE + ">>>>>>within" + ANSI_RESET);
    }

    @Before("@target(aop.test.RuntimeRetAnnotation)")
    public void target() {
        logger.info(ANSI_BLUE + ">>>>>>target" + ANSI_RESET);
    }

}
