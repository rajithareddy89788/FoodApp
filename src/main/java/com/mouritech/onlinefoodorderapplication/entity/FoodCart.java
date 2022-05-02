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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

//import org.hibernate.annotations.OnDelete;
//import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "foodcart")
public class FoodCart {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cartId")
		private long cartId;
		
		private Date createdDate;
		//private String itemName;
		//private long itemId;
		 //@JsonIgnore
		@OneToMany(mappedBy = "foodCart", orphanRemoval = true, fetch = FetchType.LAZY)
		private List<FoodCartItems> items;
		
		 @ManyToOne(fetch = FetchType.EAGER)
			@JoinColumn(name = "customer_id")
			 @JsonIgnore
			private Customer customer;
		 
		 private boolean isActive;

		public Customer getCustomer() {
			return customer;
		}
		public void setCustomer(Customer customer) {
			this.customer = customer;
		}
		public long getCartId() {
			return cartId;
		}
		public void setCartId(long cartId) {
			this.cartId = cartId;
		}
		public Date getCreatedDate() {
			return createdDate;
		}
		public void setCreatedDate(Date createdDate) {
			this.createdDate = createdDate;
		}
		public List<FoodCartItems> getItems() {
			return items;
		}
		public void setItems(List<FoodCartItems> items) {
			this.items = items;
		}
		public FoodCart(Date createdDate, List<FoodCartItems> items) {
			super();
			this.createdDate = createdDate;
			this.items = items;
		}
		public FoodCart() {
			// TODO Auto-generated constructor stub
		}
		public boolean isActive() {
			return isActive;
		}
		public void setActive(boolean isActive) {
			this.isActive = isActive;
		}
		
		

			}

