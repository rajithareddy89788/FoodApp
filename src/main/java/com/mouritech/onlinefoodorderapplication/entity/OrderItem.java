package com.mouritech.onlinefoodorderapplication.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "orderitems")
public class OrderItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "quantity")
	private @NotNull int quantity;

	@Column(name = "itemName")
	private @NotNull String itemName;

	@Column(name = "price")
	private @NotNull int price;

	@Column(name = "created_date")
	private Date createdDate;

	private double total;

	@ManyToOne
	@JoinColumn(name = "order_id")
	@JsonIgnore
	private Order order;

	public OrderItem() {
	}

	public OrderItem(int quantity, int price, Date createdDate, Order order) {
		super();
		this.quantity = quantity;
		this.price = price;
		this.createdDate = createdDate;
		this.order = order;

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public OrderItem(int quantity, String itemName, int price, Date createdDate, Order order) {
		super();
		this.quantity = quantity;
		this.itemName = itemName;
		this.price = price;
		this.createdDate = createdDate;
		this.order = order;

	}

}
