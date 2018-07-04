package aop.dao;


import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("customerDAO")
public class CustomerDAO implements MyMarker {

    public void setCustomer(String name, String lastName) {
        System.out.println(getClass() + " is setting " + name + " " + lastName);
    }

    public List<String> getList() {

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Steve");
        arrayList.add("Roger");
        arrayList.add("Alien");

        return arrayList;
    }

    public String getName(boolean throwExc) {
        if (throwExc) {
            throw new RuntimeException("Electricity is down!");
        }
        return "Jumbo";
    }
}
