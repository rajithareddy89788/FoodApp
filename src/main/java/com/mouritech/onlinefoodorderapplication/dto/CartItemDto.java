package com.mouritech.onlinefoodorderapplication.dto;

import javax.validation.constraints.NotNull;

import com.mouritech.onlinefoodorderapplication.entity.FoodCart;
import com.mouritech.onlinefoodorderapplication.entity.FoodCartItems;
import com.mouritech.onlinefoodorderapplication.entity.Items;

public class CartItemDto {
	 private long id;
	    private @NotNull Integer quantity;
	    private @NotNull Items  items;
	    public CartItemDto(FoodCartItems foodCartItems)
	    {
	    	this.id=foodCartItems.getCartItemId();
	    	this.quantity=foodCartItems.getQuantity();
	    	this.items=foodCartItems.getItems1();
	    	//this.items.getItemPrice(foodCartItems.ItemPrice());
	    }
	   
		public CartItemDto() {
			// TODO Auto-generated constructor stub
		}
		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		public Integer getQuantity() {
			return quantity;
		}
		public void setQuantity(Integer quantity) {
			this.quantity = quantity;
		}

		public Items getItems() {
			return items;
		}

		public void setItems(Items items) {
			this.items = items;
		}
		
		
}
