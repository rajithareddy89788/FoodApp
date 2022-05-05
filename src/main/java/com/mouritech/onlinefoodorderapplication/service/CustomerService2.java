package com.mouritech.onlinefoodorderapplication.service;

import com.mouritech.onlinefoodorderapplication.dto.ResponseDto;
import com.mouritech.onlinefoodorderapplication.dto.SignInDto;
import com.mouritech.onlinefoodorderapplication.dto.SignInResponseDto;
import com.mouritech.onlinefoodorderapplication.dto.SignupDto;
import com.mouritech.onlinefoodorderapplication.exceptions.CustomException;

public interface CustomerService2 {

	public ResponseDto signUp(SignupDto signupDto) throws CustomException;

	public SignInResponseDto signIn(SignInDto signInDto) throws CustomException;

}
