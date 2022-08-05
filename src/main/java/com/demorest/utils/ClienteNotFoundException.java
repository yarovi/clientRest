package com.demorest.utils;

public class ClienteNotFoundException extends RuntimeException{

	public ClienteNotFoundException() {
		super("Not Found");
	}
}
