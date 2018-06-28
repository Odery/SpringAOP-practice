package aop.config;

import aop.dao.CustomerDAO;
import aop.test.TestDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(SpringConfiguration.class);

        CustomerDAO customerDAO = context.getBean("customerDAO", CustomerDAO.class);
        TestDAO testDAO = context.getBean("testDAO", TestDAO.class);

        customerDAO.setCustomer();
        testDAO.setSomething();
        context.close();
    }
}

