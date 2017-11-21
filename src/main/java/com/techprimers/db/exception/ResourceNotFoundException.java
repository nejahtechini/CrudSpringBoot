package com.techprimers.db.exception;

import org.springframework.stereotype.Component;


public class ResourceNotFoundException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer resourceId;
	private String resourceName;

    public ResourceNotFoundException(Integer id, String message) {
        super(message);
        this.resourceId = id;
    }
    
    public ResourceNotFoundException(String name, String message) {
        super(message);
        this.resourceName = name;
    }
}
