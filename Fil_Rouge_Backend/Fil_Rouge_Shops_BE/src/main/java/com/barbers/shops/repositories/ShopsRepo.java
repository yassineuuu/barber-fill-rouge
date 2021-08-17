package com.barbers.shops.repositories;

import com.barbers.shops.entities.BarberShop;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ShopsRepo extends CrudRepository<BarberShop, Long> {
    BarberShop findShopById(Long id);
    List<BarberShop> findByNomLike(String nom);
}
