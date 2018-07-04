package aop.config;

import aop.dao.CustomerDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.logging.Logger;

public class Main {

    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_BLACk = "\u001B[1m";
    private static Logger logger = Logger.getLogger(Main.class.getName());
    
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(SpringConfiguration.class);

        CustomerDAO customerDAO = context.getBean("customerDAO", CustomerDAO.class);
//        TestDAO testDAO = context.getBean("testDAO", TestDAO.class);
//
//        customerDAO.setCustomer("Steve", "Rogers");
//        customerDAO.setCustomer("Roger", "Smith");
//        logger.info(ANSI_BLACk + customerDAO.getList() + ANSI_RESET);
//
//        testDAO.test(true);
//        try {
//            testDAO.throwExc();
//        } catch (Exception exc) {
//            logger.info(exc.getMessage() + "\n");
//        }

        logger.info(ANSI_BLACk + customerDAO.getName(true) + ANSI_RESET);
        context.close();
    }
}

