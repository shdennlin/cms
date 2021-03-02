package org.shdennlin.cms;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.shdennlin.cms.Product;

import javax.annotation.PostConstruct;
import java.util.*;

@SpringBootTest
public class test {
    @Test
    public void test1() {
        TempController temp = new TempController();
    }
}


class TempController {
    final List<Product> productDB = new ArrayList<>();

    void initDB() {
        productDB.add(new Product("B0001", "Android Development (Java)", 380));
        productDB.add(new Product("B0002", "Android Development (Kotlin)", 420));
        productDB.add(new Product("B0003", "Data Structure (Java)", 250));
        productDB.add(new Product("B0004", "Finance Management", 450));
        productDB.add(new Product("B0005", "Human Resource Management", 330));
    }

    TempController (){
        initDB();
        System.out.println("productDB = " + productDB);
        for(int i = 0; i< productDB.size(); i++){
            Product temp = productDB.get(i);
            System.out.print("temp.id = " + temp.getId());
            System.out.print("temp.name = " + temp.getPrice());
            System.out.print("temp.price = " + temp.getName());
            System.out.println();
        }
    }

}