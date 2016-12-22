package com.example.data;

import java.io.Serializable;

public class Order implements Serializable {
	private String userName;
	private Dish dish;

	public Order() {
		this("", new Dish());
	}

	public Order(String userName, Dish dish) {
		this.userName = userName;
		this.dish = dish;
	}

	public String getUserName() {
		return userName;
	}

	public Dish getDish() {
		return dish;
	}
}
