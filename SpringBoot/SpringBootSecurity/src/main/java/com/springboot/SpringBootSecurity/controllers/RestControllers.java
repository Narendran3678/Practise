package com.springboot.SpringBootSecurity.controllers;
import org.springframework.web.bind.annotation.*;
import java.text.SimpleDateFormat;

@RestController
public class RestControllers {
        public SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
        @RequestMapping(value = "/", method = RequestMethod.GET)
        public String indexMethod() {
            return "http://localhost:8081/security";
        }
        @RequestMapping(value = "/employees", method = RequestMethod.GET)
        public String findAll() {
            return "Find All Employee";
        }

        @RequestMapping(value = "/employees/{employeeId}", method = RequestMethod.GET)
        public String find(@PathVariable long employeeId) {
            return "Employee Find ["+employeeId+"]";
        }
}
