package com.StudentMicroservices;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Integer> {

    @Query(value = "select * from student where marks = (select Max(marks) from student)",nativeQuery = true)
    public List<Student> getHighestMarksStudent();

    @Query(value = "SELECT * FROM student WHERE marks >= (SELECT AVG(marks) FROM student)",nativeQuery = true)
    public List<Student> getStudentAboveAverage();

    @Query(value = "select * from student where marks = (select Min(marks) from student)",nativeQuery = true)
    public List<Student> getMinimumMarkStudent();

    @Query(value = "SELECT * FROM student WHERE name IN (SELECT DISTINCT name FROM student)",nativeQuery = true)
    public List<Student> getDistinctStudents();

    @Query(value = "SELECT * FROM student WHERE (branch, name) IN (SELECT branch, MIN(name) FROM student GROUP BY branch)",nativeQuery = true)
    public List<Student> getDistinctBranch();

}
