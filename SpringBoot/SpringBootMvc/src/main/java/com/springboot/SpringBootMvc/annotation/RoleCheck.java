package com.springboot.SpringBootMvc.annotation;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = RoleConstraintValidator.class)
@Target({ElementType.METHOD,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface RoleCheck {
    public String value() default "EMPLOYEE";
    public String message() default "Must Be Atleast Employee or Manager or Admin";
    public Class<?>[] groups() default {};
    public Class<? extends Payload>[] payload() default {};
}
