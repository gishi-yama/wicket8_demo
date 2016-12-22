package com.example.data;


import java.io.Serializable;

public class Dish implements Serializable {
	private String dishName;
	private int price;

	public Dish() {
		this("", 0);
	}

	public Dish(String dishName, int price) {
		this.dishName = dishName;
		this.price = price;
	}

	@Override
	public String toString() {
		return dishName + " " + price + "円";
	}
}
