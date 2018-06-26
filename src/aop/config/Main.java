package aop.config;

import aop.dao.CustomerDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(SpringConfiguration.class);

        CustomerDAO customerDAO = context.getBean("customerDAO", CustomerDAO.class);
        customerDAO.setCustomer();

        context.close();
    }
}

