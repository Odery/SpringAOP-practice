package aop.test;

import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
@ClassRetAnnotation
public class TestDAO {

    private static Logger logger = Logger.getLogger(TestDAO.class.getName());

    public void test(boolean isTesting) {
        logger.info(isTesting ? "Testing..." : "Waiting for testing...");
    }

    public void throwExc() throws Exception {
        throw new Exception("WooBaDooBaDoo its an Exc!");
    }
}
