package com.techprimers.db.exception;

public class DuplicationCountryException  extends Exception{
	private String  name ;
	private String message ;
	public DuplicationCountryException(String name, String message) {
		this.name = name;
		this.message = message;
	}

}
