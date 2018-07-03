package aop.test;

import org.springframework.stereotype.Component;

@Component
@ClassRetAnnotation
public class TestDAO {

    public void test(boolean isTesting) {
        System.out.println(isTesting ? "Testing..." : "Waiting for testing...");
    }
}
