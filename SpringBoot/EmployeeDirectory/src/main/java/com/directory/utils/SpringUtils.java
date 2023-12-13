package com.directory.utils;

import com.directory.constants.SpringConstants;
import com.directory.entity.Roles;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import java.util.Arrays;
import java.util.List;

public class SpringUtils {
    public static List<Roles> getRoles() {
        return Arrays.asList(
                new Roles(SpringConstants.ROLES.ADMIN.getId(), SpringConstants.ROLES.ADMIN.toString() ),
                new Roles(SpringConstants.ROLES.MANAGER.getId(), SpringConstants.ROLES.MANAGER.toString() ),
                new Roles(SpringConstants.ROLES.EMPLOYEE.getId(), SpringConstants.ROLES.EMPLOYEE.toString() )
        );
    }
    public static String checkFormError(BindingResult bindingResult) {
        List<FieldError> fieldError = bindingResult.getFieldErrors();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{").append("\n");
        for (FieldError er : fieldError) {
            stringBuilder.append("\t").append("{").append("\n");
            stringBuilder.append("\t\t").append("'FieldErrorCode'").append(":").append(er.getCode()).append(",").append("\n");
            stringBuilder.append("\t\t").append("'FieldErrorField'").append(":").append(er.getField()).append(",").append("\n");
            stringBuilder.append("\t\t").append("'FieldErrorDescription'").append(":").append(er.getDefaultMessage()).append("\n");
            stringBuilder.append("\t").append("}").append("\n");
        }
        stringBuilder.append("}").append("\n");
        System.out.println(stringBuilder.toString());
        return stringBuilder.toString();
    }
}
