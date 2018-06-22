package aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyLogAspect {

    @Before("execution(public void addCustomer())")
    public void beforeAdding() {
        System.out.println(getClass() + "is logging some data before adding customer to DB");
    }
}
