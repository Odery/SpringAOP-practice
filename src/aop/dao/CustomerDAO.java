package aop.dao;


import aop.Tess;
import org.springframework.stereotype.Component;

@Component
@Tess
public class CustomerDAO {

    public void setCustomer() {
        System.out.println(getClass() + " is setting Customer");
        setActualData();
    }

    private void setActualData() {
        System.out.println(getClass() + " is setting actual (private) data");
    }
}
