package com.mouritech.onlinefoodorderapplication.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.mouritech.onlinefoodorderapplication.entity.FoodCartItems;
import com.mouritech.onlinefoodorderapplication.repository.FoodCartItemsRepository;

public interface FoodCartItemsService {
	

	    public void addCartItems(FoodCartItems foodCartItems); 
	       

}
