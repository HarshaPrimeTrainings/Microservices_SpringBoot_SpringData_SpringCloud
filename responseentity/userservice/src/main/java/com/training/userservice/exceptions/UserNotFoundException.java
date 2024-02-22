package com.training.userservice.exceptions;

public class UserNotFoundException extends RuntimeException{

	UserNotFoundException(String exceptionMsg){
		super(exceptionMsg);
	}
}
