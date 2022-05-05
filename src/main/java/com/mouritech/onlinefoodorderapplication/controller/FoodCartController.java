package com.mouritech.onlinefoodorderapplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mouritech.onlinefoodorderapplication.common.APIResponse;
import com.mouritech.onlinefoodorderapplication.dto.AddToCartDto;
import com.mouritech.onlinefoodorderapplication.dto.CartDto;
import com.mouritech.onlinefoodorderapplication.entity.Customer;
import com.mouritech.onlinefoodorderapplication.exceptions.AuthenticationFailException;
import com.mouritech.onlinefoodorderapplication.exceptions.CartItemNotExistException;

import com.mouritech.onlinefoodorderapplication.service.AuthenticationService;

import com.mouritech.onlinefoodorderapplication.service.FoodCartService;

import io.swagger.annotations.Api;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/foodcart")
@Api(value = "")
public class FoodCartController {
	@Autowired
	private FoodCartService foodCartService;
	@Autowired
	private AuthenticationService authenticationService;

	@PostMapping("/add")
	public ResponseEntity<APIResponse> placeCart(@RequestBody List<AddToCartDto> dto1,
			@RequestParam("token") String token) {
		authenticationService.authenticate(token);

		Customer customer = authenticationService.getCustomer(token);

		// Items product = itemService.getProductById(dto1.get(0).getItemId());
		foodCartService.addFoodCart(dto1, customer);
		return new ResponseEntity<>(new APIResponse(true, "added to the cart successfully"), HttpStatus.CREATED);
	}

	@GetMapping("/listofcartitems")
	public ResponseEntity<CartDto> getCartItems(@RequestParam("token") String token)
			throws AuthenticationFailException {
		authenticationService.authenticate(token);
		Customer customer = authenticationService.getCustomer(token);
		CartDto cartDto = foodCartService.listCartItems(customer);
		return new ResponseEntity<CartDto>(cartDto, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{cartItemId}")
	public ResponseEntity<APIResponse> deleteCartItem(@PathVariable("cartItemId") long cartItemId,
			@RequestParam("token") String token) throws AuthenticationFailException, CartItemNotExistException {
		authenticationService.authenticate(token);
		long userId = authenticationService.getCustomer(token).getCustomerId();
		foodCartService.deleteCartItem(cartItemId, userId);
		return new ResponseEntity<APIResponse>(new APIResponse(true, "Item has been removed"), HttpStatus.OK);
	}

}
