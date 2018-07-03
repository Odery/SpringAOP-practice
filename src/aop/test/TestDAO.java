package aop.test;

import org.springframework.stereotype.Component;

@Component
@ClassRetAnnotation
public class TestDAO {

    public void test(boolean isTesting) {
        System.out.println(isTesting ? "Testing..." : "Waiting for testing...");
    }

    public void throwExc() throws Exception {
        throw new Exception("WooBaDooBaDoo its an Exc!");
    }
}
