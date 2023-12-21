package SpringRestTemplate.restTemplates;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;
import SpringRestTemplate.entity.Employee;
import SpringRestTemplate.entity.Student;

@Service
public class RestTemplateClient {
	private org.springframework.web.client.RestTemplate restTemplate;

	@Autowired
	public RestTemplateClient(org.springframework.web.client.RestTemplate restTemplate) {
		this.restTemplate=restTemplate;
	}
	
	public List<Employee> showEmployeeObject() {
		String url ="http://localhost:8081/rest/employees";
		List<Employee> employeeList = restTemplate.getForObject(url, List.class);
		return employeeList;
	}
	public List showEmployeeEntity() {
		String url ="http://localhost:8081/rest/employees";
		ResponseEntity<List> employeeEntity = restTemplate.getForEntity(url, List.class);
		System.out.println("ResponseStatus..."+employeeEntity.getStatusCode());
		System.out.println("ResponseStatus..."+employeeEntity.getHeaders());
		return employeeEntity.getBody();
	}
	public String addStudent() {
		String url ="http://localhost:8081/rest/students";
		String studentName ="Student_"+new Random().nextInt();
		Student student = new Student(studentName,studentName,studentName+"@gmail.com");
		student.setGrade(80);
		ResponseEntity<String> response =restTemplate.exchange(url, HttpMethod.POST,new HttpEntity<Student>(student),String.class);
		return response.getBody();
	}

}
