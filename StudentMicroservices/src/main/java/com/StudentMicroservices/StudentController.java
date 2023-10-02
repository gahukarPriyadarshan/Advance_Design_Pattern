package com.StudentMicroservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.*;

@RestController
public class StudentController {

    int count = 0;
    @Autowired
    StudentRepository studentRepository;

    @GetMapping("/getMsg/{studentName}")
    public String getGreetings(@PathVariable String studentName) {
        Date date = new Date();
        String greeting = null;
        SimpleDateFormat time = new SimpleDateFormat("hh:mm:ss");
        String currentTime = time.format(date);
        SimpleDateFormat hour = new SimpleDateFormat("hh");
        SimpleDateFormat ampm = new SimpleDateFormat("aa");
        int hh = Integer.parseInt(hour.format(date));
        String aa = ampm.format(date);

        if ((hh >= 4 && hh < 12) && (aa.equals("AM"))) {
            greeting = "Good morning ";
        } else if ((hh >= 12 || hh < 4) && (aa.equals("PM"))) {
            greeting = "Good afternoon ";
        } else if ((hh >= 4 && hh < 8) && (aa.equals("PM"))) {
            greeting = "Good evening ";
        } else if ((hh >= 8 || hh < 4) && (aa.equals("PM")) || (hh >= 8 || hh < 4) && (aa.equals("AM"))) {
            greeting = "Good night ";
        } else {
            greeting = "Its mid night ";
        }
        return greeting + " " + studentName + " Time : " + currentTime;
    }

    @PostMapping("/createstudent")
    public Student createStudent(@RequestBody Student student) {
        return studentRepository.save(student);
    }

    @GetMapping("/maxmarks")
    public List<Student> maxMarks() {
        return studentRepository.getHighestMarksStudent();
    }

    @GetMapping("/minmarks")
    public List<Student> minMarks() {
        return studentRepository.getMinimumMarkStudent();
    }

    @GetMapping("/aboveaveragestudents")
    public List<Student> aboveAverageStudents() {
        return studentRepository.getStudentAboveAverage();
    }

    @GetMapping("/authorization/{userIN}/{passIN}")
    public String authorization(@PathVariable String userIN, @PathVariable String passIN) {
        String user = "vickey", pass = "rcoem";
        if (user.equals(userIN) && pass.equals(passIN)) {
            count = 0;
            return "Welcome " + user;
        } else {
            count++;
            if (count > 2) {
                return "max login limit reached";
            }
            return "Invalid UserName or Password";
        }
    }

    @DeleteMapping("deletestudent/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable int id) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isPresent()) {
            Student student = optionalStudent.get();
            studentRepository.delete(student);
            String message = "Student deleted successfully";
            return ResponseEntity.ok(message);
        } else {
            String errorMessage = "Student not found";
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/updatestudent/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable int id, @RequestBody Student student) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isPresent()) {
            Student existingStudent = optionalStudent.get();
            existingStudent.setAddress(student.getAddress());
            existingStudent.setName(student.getName());
            existingStudent.setMarks(student.getMarks());
            studentRepository.save(existingStudent);
            return ResponseEntity.ok(existingStudent);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("/updatestudentpatch/{id}")
    public ResponseEntity<Student> updateStudentPatch(@PathVariable int id, @RequestBody Student student) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isPresent()) {
            Student existingStudent = optionalStudent.get();
            existingStudent.setAddress(student.getAddress());
//            existingStudent.setName(student.getName());
//            existingStudent.setMarks(student.getMarks());
            studentRepository.save(existingStudent);
            return ResponseEntity.ok(existingStudent);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/distintbranch")
    public List<Student> distinctBranch() {
        return studentRepository.getDistinctBranch();
    }

    @GetMapping("/distintstudent")
    public List<Student> distinctStudent() {
        return studentRepository.getDistinctStudents();
    }



}