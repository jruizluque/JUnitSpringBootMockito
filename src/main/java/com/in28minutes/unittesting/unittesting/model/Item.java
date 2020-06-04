package com.in28minutes.unittesting.unittesting.model;

public class Item {

	private int id;
	private String name;
	private int price;
	private int quantity;

	public Item(int id, String name, int price, int quantity) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}

	public int getQuantity() {
		return quantity;
	}

	@Override
	public String toString() {
		return String.format("Item [id=%s, name=%s, price=%s, quantity=%s]", id, name, price, quantity);
	}
	
}
