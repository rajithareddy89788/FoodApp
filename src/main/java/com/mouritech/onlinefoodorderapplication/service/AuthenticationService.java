package com.mouritech.onlinefoodorderapplication.service;

import com.mouritech.onlinefoodorderapplication.entity.AuthenticationToken;
import com.mouritech.onlinefoodorderapplication.entity.Customer;
import com.mouritech.onlinefoodorderapplication.exceptions.AuthenticationFailException;

public interface AuthenticationService {
	 public void saveConfirmationToken(AuthenticationToken authenticationToken);
	    public AuthenticationToken getToken(Customer customer);
	    public Customer getCustomer(String token) ;
	    public void authenticate(String token) throws AuthenticationFailException ;
}
