package com.springboot.SpringBootMvc.annotation;
import com.springboot.SpringBootMvc.constants.ROLES;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
public class RoleConstraintValidator implements ConstraintValidator<RoleCheck,String> {
    private String defaultRoleValue ;
    @Override
    public void initialize(RoleCheck constraintAnnotation) {
        System.out.println("RoleConstraint...initialize...."+constraintAnnotation.value());
        this.defaultRoleValue=constraintAnnotation.value();
    }
    @Override
    public boolean isValid(String enteredValue, ConstraintValidatorContext context) {
        System.out.println("RoleConstraint...isValid...." +enteredValue+" Message ="+context.getDefaultConstraintMessageTemplate());
        context.disableDefaultConstraintViolation();
        context = context.buildConstraintViolationWithTemplate("Given Data is ["+enteredValue+"] Expected Least is ["+defaultRoleValue+"] or Role [MANAGER | ADMIN]").addConstraintViolation();

        boolean valid = false;
        for (ROLES roles : ROLES.values()) {
            if (roles.name().equals(enteredValue.toUpperCase())) {
                valid = true;
                break;
            }
        }
        return valid;
    }
}
