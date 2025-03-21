package springboot.controllers;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springboot.ExceptionHandler.GenErrorResponse;
import springboot.ExceptionHandler.GenException;
import springboot.config.SpringConstants;
import springboot.entity.Employee;
import springboot.entity.Student;
import springboot.service.EmployeeServiceI;
import springboot.service.StudentServiceI;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;
@RestController
public class RestControllers {
        public SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
        @Autowired
        EmployeeServiceI employeeService;

        @Autowired
        StudentServiceI studentService;

        @GetMapping(value = "/")
        public String indexMethod() {
            return "http://localhost:8081/rest";
        }
        @GetMapping(value = "/employees")
        public List<Employee> findAll() {
            return employeeService.findAll();
        }
        @GetMapping(value = "/employees/{employeeId}")
        public Employee find(@PathVariable long employeeId) {
            System.out.println("EmployeeId..."+employeeId);
            Employee employee = employeeService.find(employeeId);
            if(employee == null ) {
                throw new GenException("Employee ID "+employeeId+" Not Found");
            }
            return employee;
        }
        @PostMapping(value = "/employees")
        public Employee save(@RequestBody Employee employee) {
            return employeeService.persist(employee);
        }

        @PutMapping(value = "/employees")
        public Employee update(@RequestBody Employee employee) {
            return employeeService.persist(employee);
        }
        @DeleteMapping(value = "/employees/{employeeId}")
        public boolean delete(@PathVariable long employeeId) {
            return employeeService.delete(employeeId);
        }
        @ExceptionHandler
        public ResponseEntity<GenErrorResponse> handleEmpleNotFoundException(GenException exception) {
            GenErrorResponse response = new GenErrorResponse(404,exception.getMessage(), new Timestamp(System.currentTimeMillis()));
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }

        @GetMapping(value = "/students")
        public List<Student> findAllStudent() {
        return studentService.findAll();
    }
        @PostMapping(value = "/students")
        public Student saveStudent(@RequestBody Student student) {
            System.out.println("Student..."+student);
            return studentService.persist(student);
        }
        @GetMapping(value = "/stud-grade")
        public List<Student> findByGrade(@RequestParam(name="grade") Double grade) {
            System.out.println("Grade Filter..."+grade);
            return studentService.findByGrade(grade);
        }
        @GetMapping(value = "/studentsbygrade")
        public List<Student> findAllOrderByGrade() {
            return studentService.findAllByOrderByGrade();
        }
}
