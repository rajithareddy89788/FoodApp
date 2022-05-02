package com.mouritech.onlinefoodorderapplication.dto;

import java.util.List;

public class PlaceOrderDto1 {
	private String shippingAddress;
	private String paymentMode;
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
	
	public PlaceOrderDto1(String shippingAddress,String paymentMode,
			List<com.mouritech.onlinefoodorderapplication.dto.PlaceOrderDto> placeOrderDto) {
		super();
		this.shippingAddress = shippingAddress;
		this.paymentMode=paymentMode;
		PlaceOrderDto = placeOrderDto;
	}
	public PlaceOrderDto1() {
		// TODO Auto-generated constructor stub
	}
	public String getPaymentMode() {
		return paymentMode;
	}
	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}
	

}
