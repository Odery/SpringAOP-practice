package aop.dao;


import aop.Tess;
import org.springframework.stereotype.Component;

@Component
@Tess
public class CustomerDAO {

    public void setCustomer() {
        System.out.println(getClass() + " is setting Customer");
    }
}
