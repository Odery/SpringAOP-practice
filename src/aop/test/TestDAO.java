package aop.test;

import org.springframework.stereotype.Component;

@Component
public class TestDAO {

    public void setSomething() {
        System.out.println("Setting something in " + getClass());
    }
}
