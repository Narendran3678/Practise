package springboot.studentJPA;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import springboot.entity.Student;

//@RepositoryRestResource(path="stud")
public interface StudentRepository extends JpaRepository<Student,Long> {
}
