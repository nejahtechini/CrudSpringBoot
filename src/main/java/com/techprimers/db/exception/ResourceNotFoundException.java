package com.techprimers.db.exception;

import org.springframework.stereotype.Component;


public class ResourceNotFoundException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer resourceId;

    public ResourceNotFoundException(Integer id, String message) {
        super(message);
        this.resourceId = id;
    }
}
