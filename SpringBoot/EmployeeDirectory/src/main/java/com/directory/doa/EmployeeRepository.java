package com.directory.doa;

import com.directory.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    public List<Employee> findAllByOrderByFirstName();
    public Page<Employee> findAll(Pageable pageable);

    @Query(value="select e.* from employee e where e.age>=:age",nativeQuery = true)
    public List<Employee> findByAage(@Param("age") Integer age);

    @Transactional
    @Modifying
    @Query("Update Employee set salary=salary+100 where age>=?1")
    public Integer updateSalary(Integer age);

    public List<Employee> findByLastName(@Param("lastName") String lastName);

    @Transactional
    @Modifying
    public Integer updateByLastName(@Param("lastName") String lastName);
}
