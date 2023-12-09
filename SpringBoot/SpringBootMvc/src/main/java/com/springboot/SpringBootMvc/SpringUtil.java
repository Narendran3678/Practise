package com.springboot.SpringBootMvc;

import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.List;

@Component
public class SpringUtil {
    public String checkFormError(BindingResult bindingResult) {
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
