package springboot.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.entity.Student;
import springboot.studentJPA.StudentRepository;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentServiceI{
    private StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository =studentRepository;
    }


    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student find(long id) {
        if(studentRepository.findById(id).isPresent()) {
            return studentRepository.findById(id).get();
        }
        return null;
    }

    @Override
    public Student persist(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public boolean delete(long id) {
        if(studentRepository.findById(id).isPresent()) {
            Student student = studentRepository.findById(id).get();
            studentRepository.delete(student);
        }
        return true;
    }

    @Override
    public List<Student> findByGrade(Double grade) {

        return studentRepository.findByGrade(grade);
    }

    @Override
    public List<Student> findAllByOrderByGrade() {
        return studentRepository.findAllByOrderByGrade();
    }
}
