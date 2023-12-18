package springboot.studentJPA;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springboot.entity.Student;

import java.util.List;

//@RepositoryRestResource(path="stud")
@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
    public List<Student> findByGrade(Double grade);
    public List<Student> findAllByOrderByGrade();

    public List<Student> findAllByOrderByGradeDesc();
}
