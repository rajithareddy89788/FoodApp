package com.mouritech.onlinefoodorderapplication.entity;



import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;

//import javax.persistence.CascadeType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

//import org.hibernate.annotations.OnDelete;
//import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "foodcartitems")
public class FoodCartItems {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cartItemId")
	 private long cartItemId;
	
	@Column(name = "quantity")
	private int quantity;
	
//	@Column(name = "itemprice")
//	private int itemPrice;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "cartid")
	 @JsonIgnore
	private FoodCart foodCart;
	
	private boolean isActive;
   
   
	
	public Items getItems1() {
		return items1;
	}

	public void setItems1(Items items1) {
		this.items1 = items1;
	}
	@ManyToOne(fetch = FetchType.EAGER, cascade=CascadeType.MERGE)
	@JoinColumn(name = "itemid")
	 @JsonIgnore
	
	
	private Items items1;
	
	 @ManyToOne(fetch = FetchType.EAGER)
		@JoinColumn(name = "customer_id")
		 @JsonIgnore
		private Customer customer;
	
	public long getCartItemId() {
		return cartItemId;
	}
	
	

	public void setCartItemId(long cartItemId) {
		this.cartItemId = cartItemId;
	}
	
	public FoodCart getFoodCart() {
		return foodCart;
	}
	public void setFoodCart(FoodCart foodCart) {
		this.foodCart = foodCart;
	}
//	public Items getItems() {
//		return items;
//	}
//	public void setItems(Items items) {
//		this.items = items;
//	}
	
	public FoodCartItems( FoodCart foodCart) {
		super();
		
		this.foodCart = foodCart;
		
	}

	public FoodCartItems() {
		// TODO Auto-generated constructor stub
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

//	public int getItemPrice() {
//		return itemPrice;
//	}
//
//	public void setItemPrice(int itemPrice) {
//		this.itemPrice = itemPrice;
//	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	
	
	
		
		

			}

