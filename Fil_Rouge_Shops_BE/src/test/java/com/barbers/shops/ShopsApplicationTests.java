package com.barbers.shops;

import com.barbers.shops.entities.BarberShop;
import com.barbers.shops.repositories.ShopsRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ShopsApplicationTests {

    @Autowired
    private ShopsRepo shopsRepo;

    @Test
    void contextLoads() {
        BarberShop user = new BarberShop("yassine's", "Ain Chok");
        shopsRepo.save(user);
        System.out.println(user.toString());
    }

}
