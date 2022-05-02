package com.mouritech.onlinefoodorderapplication.serviceImpl;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.xml.bind.DatatypeConverter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.mouritech.onlinefoodorderapplication.config.MessageStrings;
import com.mouritech.onlinefoodorderapplication.dto.ResponseDto;
import com.mouritech.onlinefoodorderapplication.dto.SignInDto;
import com.mouritech.onlinefoodorderapplication.dto.SignInResponseDto;
import com.mouritech.onlinefoodorderapplication.dto.SignupDto;
import com.mouritech.onlinefoodorderapplication.entity.AuthenticationToken;
import com.mouritech.onlinefoodorderapplication.entity.Customer;
import com.mouritech.onlinefoodorderapplication.entity.FoodCartItems;
import com.mouritech.onlinefoodorderapplication.enums.ResponseStatus;

import com.mouritech.onlinefoodorderapplication.exceptions.AuthenticationFailException;
import com.mouritech.onlinefoodorderapplication.exceptions.CustomException;

import com.mouritech.onlinefoodorderapplication.repository.CustomerRepository1;
import com.mouritech.onlinefoodorderapplication.repository.FoodCartItemsRepository;
import com.mouritech.onlinefoodorderapplication.service.AuthenticationService;

import com.mouritech.onlinefoodorderapplication.service.CustomerService2;
import com.mouritech.onlinefoodorderapplication.service.FoodCartItemsService;
import com.mouritech.onlinefoodorderapplication.utils.Helper;

@Service
public class FoodCartItemsServiceImpl implements FoodCartItemsService {

	@Autowired
	private FoodCartItemsRepository foodCartItemsRepository;

	@Override
	public void addCartItems(FoodCartItems foodCartItems) {
		foodCartItemsRepository.save(foodCartItems);
		
	}
}