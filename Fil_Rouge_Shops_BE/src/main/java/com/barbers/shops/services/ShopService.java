package com.barbers.shops.services;

import java.util.List;

import com.barbers.shops.entities.BarberShop;

public interface ShopService {
	
	List<BarberShop> allShops();
	BarberShop addShop(BarberShop body);
	

}
