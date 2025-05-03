package model;

import java.text.NumberFormat;

public abstract class Product {

	NumberFormat nfMoeda = NumberFormat.getCurrencyInstance();

	private int id;
	private String name;
	private int type;
	private double price;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void view() {
		System.out.println("=========================================");
		System.out.println("          PRODUTO - DETALHES");
		System.out.println("=========================================");
		System.out.println("ID: " + id);
		System.out.println("Nome: " + name);
		System.out.println("Tipo: " + type);
		System.out.println("Preço: " + nfMoeda.format(price));
		System.out.println("=========================================");
	}

}
