package SpringRestTemplate.openfeignclient;

import SpringRestTemplate.config.SpringConfiguration;
import SpringRestTemplate.entity.Student;
import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.*;

@FeignClient(name="students",url="http://localhost:8081/rest/",configuration = SpringConfiguration.class)
public interface RestOpenFeign {

    @RequestMapping(method = RequestMethod.GET,value="/stud-grade")
    @Headers(value="Content-Type: application/json")
    public List<Student> getStudentByGrade(@RequestParam("grade") Double grade);

    @RequestMapping(method = RequestMethod.GET,value="/studentsbygrade")
    public List<Student> studentsbygrade();

    @RequestMapping(method = RequestMethod.POST,value="/students")
    @Headers(value="Content-Type: application/json")
    public Student saveStudent(@RequestBody Student student);
}
