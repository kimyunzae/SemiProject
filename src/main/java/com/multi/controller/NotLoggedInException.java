package com.multi.controller;

public class NotLoggedInException extends Exception {
	public NotLoggedInException() {
		super();
	}

	public NotLoggedInException(String message) {
		super(message);
	}
}
