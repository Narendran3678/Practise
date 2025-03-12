package com.demo.springdemo.controllers;

import com.demo.springdemo.Constants;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.servlet.error.AbstractErrorController;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorControllers extends AbstractErrorController {
    private static final String ERROR_PATH=  "/error";

    @Autowired
    public ErrorControllers(ErrorAttributes errorAttributes) {
        super(errorAttributes);
    }
    /*
    @ExceptionHandler(NoHandlerFoundException.class)
    public String notFound() {
        return Constants.ERROR_JSP;
    }
    */
    @RequestMapping(ERROR_PATH)
    public String handleErrors(HttpServletRequest request) throws Exception {
        HttpStatus status = getStatus(request);
        System.out.println(status);
        if (status.equals(HttpStatus.NOT_FOUND))
            return Constants.ERROR_JSP;

        return Constants.ERROR_JSP;
    }

}
