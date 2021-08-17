package com.barbers.shops.entities;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "barberShop")
public class BarberShop {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nom;
	private String adresse;
	
	public BarberShop(Long id, String nom, String adresse) {
		this.id = id;
		this.nom = nom;
		this.adresse = adresse;
	}
	
	public BarberShop(String nom, String adresse) {
		this.nom = nom;
		this.adresse = adresse;
	}

	public BarberShop() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	@Override
	public String toString() {
		return "BarberShop [id=" + id + ", nom=" + nom + ", adresse=" + adresse + "]";
	}
	
	
	
	
	

}
