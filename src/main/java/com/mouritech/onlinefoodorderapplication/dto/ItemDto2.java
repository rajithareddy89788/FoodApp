package com.mouritech.onlinefoodorderapplication.dto;


import com.mouritech.onlinefoodorderapplication.entity.Items;
import com.mouritech.onlinefoodorderapplication.entity.Restaurant;

public class ItemDto2 {

	private String itemName;
	
	private int itemPrice;
	
	
	private String restaurantName;
	
	public ItemDto2(Items items)
	{
		this.itemName=items.getItemName();
		this.restaurantName=items.getRestaurant().getRestaurantName();
		this.itemPrice=items.getItemPrice();
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}

	

//	public int getItemQuantity() {
//		return itemQuantity;
//	}
//
//	public void setItemQuantity(int itemQuantity) {
//		this.itemQuantity = itemQuantity;
//	}

	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	public ItemDto2(String itemName, int itemPrice, String restaurantName) {
		super();
		this.itemName = itemName;
		this.itemPrice = itemPrice;
	
		//this.itemQuantity = itemQuantity;
		this.restaurantName = restaurantName;
	}

	public ItemDto2() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
