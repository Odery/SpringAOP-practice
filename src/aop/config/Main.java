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

        customerDAO.setCustomer("Steve", "Rogers");
        customerDAO.setCustomer("Roger", "Smith");
        System.out.println(customerDAO.getList());

        testDAO.test(true);
        try {
            testDAO.throwExc();
        } catch (Exception exc) {
            System.err.println(exc.getMessage() + "\n");
        }
        context.close();
    }
}

