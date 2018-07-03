package aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Order(2)
@Component
public class LoggingAspect {

    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_GREEN = "\u001B[32m";

    @Before("aop.aspect.PointcutAspect.ifMarker()")
    public void log(JoinPoint joinPoint) {
        System.out.println(ANSI_GREEN + ">>>>>>Logging " + joinPoint.getSignature() + ANSI_RESET);
    }

    @AfterThrowing(pointcut = "aop.aspect.PointcutAspect.ifExcIsThrown()", throwing = "exc")
    public void afterExc(JoinPoint joinPoint, Throwable exc) {
        System.out.println(ANSI_GREEN + exc + "is being logged!" + ANSI_RESET);
    }
}
