package springboot.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springboot.ExceptionHandler.GenErrorResponse;
import springboot.ExceptionHandler.GenException;
import springboot.entity.Employee;
import springboot.service.EmployeeServiceI;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;
@RestController
public class RestControllers {
        public SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
        @Autowired
        EmployeeServiceI employeeService;
        @RequestMapping(value = "/", method = RequestMethod.GET)
        public String indexMethod() {
            return "http://localhost:8081/rest";
        }
        @RequestMapping(value = "/employees", method = RequestMethod.GET)
        public List<Employee> findAll() {

            return employeeService.findAll();
        }
        @RequestMapping(value = "/employees/{employeeId}", method = RequestMethod.GET)
        public Employee find(@PathVariable long employeeId) {
            System.out.println("EmployeeId..."+employeeId);
            Employee employee = employeeService.find(employeeId);
            int c=1/0;
            if(employee == null ) {
                throw new GenException("Employee ID "+employeeId+" Not Found");
            }
            return employee;
        }
        @RequestMapping(value = "/employees", method = RequestMethod.POST)
        public Employee save(@RequestBody Employee employee) {
            return employeeService.persist(employee);
        }

        @RequestMapping(value = "/employees", method = RequestMethod.PUT)
        public Employee update(@RequestBody Employee employee) {
            return employeeService.persist(employee);
        }
        @ExceptionHandler
        public ResponseEntity<GenErrorResponse> handleEmpleNotFoundException(GenException exception) {
            GenErrorResponse response = new GenErrorResponse(404,exception.getMessage(), new Timestamp(System.currentTimeMillis()));
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }


}
