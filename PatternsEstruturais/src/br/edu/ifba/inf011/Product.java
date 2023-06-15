package br.edu.ifba.inf011;

import java.util.Objects;

//ADAPTEE em um ADAPTER
public class Product {
	
	private String id;
	private String description;
	private Double price;
	private Double weight;
	
	
	public Product(String id, String description, Double price, Double weight) {
		super();
		this.id = id;
		this.description = description;
		this.price = price;
		this.weight = weight;
	}


	public String getId() {
		return id;
	}


	public String getDescription() {
		return description;
	}


	public Double getPrice() {
		return price;
	}


	public Double getWeight() {
		return weight;
	}
	
	
	

}
