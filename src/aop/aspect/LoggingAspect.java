package aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Order(2)
@Component
public class LoggingAspect {

    private static Logger logger = Logger.getLogger(LoggingAspect.class.getName());
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_GREEN = "\u001B[32m";

    @Before("aop.aspect.PointcutAspect.ifMarker()")
    public void log(JoinPoint joinPoint) {
        logger.info(ANSI_GREEN + ">>>>>>Logging " + joinPoint.getSignature() + ANSI_RESET);
    }

    @AfterThrowing(pointcut = "aop.aspect.PointcutAspect.ifExcIsThrown()", throwing = "exc")
    public void afterExc(JoinPoint joinPoint, Throwable exc) {
        logger.info(ANSI_GREEN + exc + "is being logged!" + ANSI_RESET);
    }

    @Around("aop.aspect.PointcutAspect.ifComponent()")
    public Object afterFinally(ProceedingJoinPoint point) throws Throwable {

        long timeBefore = System.currentTimeMillis();

        Object result = null;

        try {
            result = point.proceed();
        } catch (RuntimeException exc) {
            logger.warning(exc.getMessage());
        }

        logger.info(ANSI_GREEN + ">>>>>>Method " + point.getSignature().toShortString() + " took: "
                + (timeBefore - System.currentTimeMillis()) + "ms " + ANSI_RESET);

        return result;
    }
}
