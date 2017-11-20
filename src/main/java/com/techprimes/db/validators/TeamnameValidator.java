package com.techprimes.db.validators;




	import javax.validation.ConstraintValidator;
	import javax.validation.ConstraintValidatorContext;

	public class TeamnameValidator implements ConstraintValidator<Teamname, String> {
	    public void initialize(Teamname constraintAnnotation) {

	    }

	    public boolean isValid(String value, ConstraintValidatorContext context) {
	        if ("teamname".equalsIgnoreCase(value)) {
	            return false;
	        }
	        return true;
	    }

	
	
}
