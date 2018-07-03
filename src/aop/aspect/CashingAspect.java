package aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Order(3)
@Component
public class CashingAspect {

    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_YELLOW = "\u001B[33m";

    @Before("aop.aspect.PoincutAspect.ifMarker()")
    public void cash(JoinPoint joinPoint) {
        System.out.println(ANSI_YELLOW + ">>>>>>Cashing " + joinPoint.getSignature() + ". Values: "
                + Arrays.toString(joinPoint.getArgs()) + ANSI_RESET);
    }
}
