package aop.dao;


import org.springframework.stereotype.Component;

@Component("customerDAO")
public class CustomerDAO implements MyMarker {

    public void setCustomer() {
        System.out.println(getClass() + " is setting Customer\n");
    }
}
