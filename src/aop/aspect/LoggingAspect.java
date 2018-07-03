package aop.aspect;

import org.aspectj.lang.JoinPoint;
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

    @Before("aop.aspect.PoincutAspect.ifMarker()")
    public void log(JoinPoint joinPoint) {
        System.out.println(ANSI_GREEN + ">>>>>>Logging " + joinPoint.getSignature() + ANSI_RESET);
    }
}
