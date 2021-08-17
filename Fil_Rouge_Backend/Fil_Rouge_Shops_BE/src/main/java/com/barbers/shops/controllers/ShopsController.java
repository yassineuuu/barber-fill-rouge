package com.barbers.shops.controllers;

import java.util.List;

import com.barbers.shops.entities.BarberShop;
import com.barbers.shops.repositories.ShopsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ShopsController {
	
	@Autowired
	private ShopsRepo shopsRepo;
	
	@RequestMapping("/allShops")
	public List<BarberShop> allShops(){
		
		List<BarberShop> shops = (List<BarberShop>) shopsRepo.findAll();
		return shops;
		
	}
	
	@PostMapping("/addShop")
	public BarberShop addShop(@RequestBody BarberShop body){
		shopsRepo.save(body);
		return body;
		
	}
	
	
	@GetMapping("/getShopByName/{nom}")
	public List<BarberShop> getShopByNom(@PathVariable String nom){
		List<BarberShop> shop = shopsRepo.findByNomLike("%"+nom+"%");
		return shop;
		
	}
	
	@GetMapping("/getShopById/{id}")
	public BarberShop getShopById(@PathVariable Long id){
		BarberShop shop = shopsRepo.findShopById(id);
		return shop;
		
	}
	
	
	@PutMapping("/updateShop/{id}")
	public BarberShop updateShop(@PathVariable Long id, @RequestBody BarberShop body){
		
		BarberShop shop = shopsRepo.findShopById(id);
		shop.setNom(body.getNom());
		shop.setAdresse(body.getAdresse());
		
		shopsRepo.save(shop);
		
		return shop;
		
	}
	
	@DeleteMapping("/deleteShop/{id}")
	public String deleteShop(@PathVariable Long id){
		
		BarberShop shop = shopsRepo.findShopById(id);

		shopsRepo.delete(shop);
		
		return "Done";
		
	}

	
	

}
