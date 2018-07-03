package aop.dao;


import org.springframework.stereotype.Component;

@Component("customerDAO")
public class CustomerDAO implements MyMarker {

    public void setCustomer(String name, String lastName) {
        System.out.println(getClass() + " is setting " + name + " " + lastName + "\n");
    }
}
