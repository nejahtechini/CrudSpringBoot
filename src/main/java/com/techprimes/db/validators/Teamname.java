package com.techprimes.db.validators;



	
	import javax.validation.Constraint;
	import javax.validation.Payload;
	import java.lang.annotation.*;

	@Documented
	@Constraint(validatedBy = TeamnameValidator.class)
	@Target( { ElementType.METHOD, ElementType.FIELD })
	@Retention(RetentionPolicy.RUNTIME)
	public @interface Teamname {

	    String message() default "{Teamname}";

	    Class<?>[] groups() default {};

	    Class<? extends Payload>[] payload() default {};

}
