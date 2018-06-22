package aop.dao;

import org.springframework.stereotype.Component;

@Component
public class CustomerDAO {

    public void addCustomer() {
        System.out.println(getClass() + " is adding Customer to DB");
    }
}
