package com.mouritech.onlinefoodorderapplication.dto;

import java.util.List;

public class PlaceOrderDto1 {
	private String shippingAddress;
	//private PlaceOrderDto placeOrderDto;
	
	  private List<PlaceOrderDto> PlaceOrderDto;
	public String getShippingAddress() {
		return shippingAddress;
	}
	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
	
	public List<PlaceOrderDto> getPlaceOrderDto() {
		return PlaceOrderDto;
	}
	public void setPlaceOrderDto(List<PlaceOrderDto> placeOrderDto) {
		PlaceOrderDto = placeOrderDto;
	}
	
	public PlaceOrderDto1(String shippingAddress,
			List<com.mouritech.onlinefoodorderapplication.dto.PlaceOrderDto> placeOrderDto) {
		super();
		this.shippingAddress = shippingAddress;
		PlaceOrderDto = placeOrderDto;
	}
	public PlaceOrderDto1() {
		// TODO Auto-generated constructor stub
	}
	

}
