package com.mouritech.onlinefoodorderapplication.dto;

public class ItemDto {

	private String itemName;

	private int itemPrice;

	private String itemDescription;

	private String restaurantName;

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

	public String getItemDescription() {
		return itemDescription;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	public ItemDto(String itemName, int itemPrice, String itemDescription, String restaurantName) {
		super();
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.itemDescription = itemDescription;

		this.restaurantName = restaurantName;
	}

	public ItemDto() {
		super();
		// TODO Auto-generated constructor stub
	}

}
