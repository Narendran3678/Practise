package SpringRestTemplate.controllers;

import SpringRestTemplate.entity.Student;
import SpringRestTemplate.openfeignclient.RestOpenFeign;
import SpringRestTemplate.webclient.RestWebclient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/")
public class RestControllers {
    @Autowired
    private RestOpenFeign restProxy;
    @Autowired
    private RestWebclient restWebclient;

    public RestControllers() {}

    //http://localhost:8082/rest/feign/stud-grade?grade=87.3
    @GetMapping("/feign/stud-grade")
    public List<Student> getStudentByGrade(@RequestParam("grade") Double grade) {
        System.out.println("Grade...."+grade);
        return restProxy.getStudentByGrade(grade);
    }
    //http://localhost:8082/rest/feign/studentsbygrade
    @GetMapping("/feign/studentsbygrade")
    public List<Student> getStudentByGrade() {
        return restProxy.studentsbygrade();
    }

    @RequestMapping("/feign/savestudent")
    public Student createStudent() {
        String studentName ="Student_"+new Random().nextInt();
        Student student = new Student(studentName,studentName,studentName+"@gmail.com");
        student.setGrade(80);
        return restProxy.saveStudent(student);
    }

    @GetMapping("/webclient/studentsbygrade")
    public List<Student> getStudentByGradeWebClient() {
        return restWebclient.getStudentList();
    }
    @GetMapping("/webclient/stud-grade")
    public List<Student> getStudentByGradeWebClient(@RequestParam("grade") Double grade) {
        return restWebclient.getStudentListByGrade(grade);
    }

    @RequestMapping("/webclient/savestudent")
    public Student createStudentByWebClient() {
        String studentName ="Student_"+new Random().nextInt();
        Student student = new Student(studentName,studentName,studentName+"@gmail.com");
        student.setGrade(80);
        return restWebclient.saveStudent(student);
    }
}
