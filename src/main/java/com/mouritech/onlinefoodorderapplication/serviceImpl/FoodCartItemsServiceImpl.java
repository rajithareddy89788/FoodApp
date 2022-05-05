package com.mouritech.onlinefoodorderapplication.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.mouritech.onlinefoodorderapplication.entity.FoodCartItems;

import com.mouritech.onlinefoodorderapplication.repository.FoodCartItemsRepository;

import com.mouritech.onlinefoodorderapplication.service.FoodCartItemsService;

@Service
public class FoodCartItemsServiceImpl implements FoodCartItemsService {

	@Autowired
	private FoodCartItemsRepository foodCartItemsRepository;

	@Override
	public void addCartItems(FoodCartItems foodCartItems) {
		foodCartItemsRepository.save(foodCartItems);

	}
}