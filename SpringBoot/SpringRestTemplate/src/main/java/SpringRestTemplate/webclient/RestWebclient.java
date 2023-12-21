package SpringRestTemplate.webclient;

import SpringRestTemplate.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import java.util.*;
@Service
public class RestWebclient {
    @Autowired
    private WebClient webClient;

    public List<Student> getStudentList() {
        return webClient.get().uri("http://localhost:8081/rest/studentsbygrade")
                .header("NotificationType","WebClient").retrieve().bodyToMono(List.class).block();
    }

    public List<Student> getStudentListByGrade(Double grade) {
        return WebClient.create("http://localhost:8081").get().uri( uriBuilder ->
                         uriBuilder.path("/rest/stud-grade").queryParam("grade",grade).build()
        ).retrieve().bodyToMono(List.class).block();
    }
    public Student saveStudent(Student student) {
        return webClient.post().uri( "http://localhost:8081/rest/students")
                .header("NotificationType","WebClient")
                .body(Mono.just(student),Student.class)
                .retrieve().bodyToMono(Student.class).block();
    }
}
