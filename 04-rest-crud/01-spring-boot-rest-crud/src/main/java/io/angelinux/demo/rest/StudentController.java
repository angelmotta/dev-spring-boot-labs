package io.angelinux.demo.rest;

import io.angelinux.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class StudentController {
    private  List<Student> studentsList;

    @PostConstruct
    private void postConstruct() {
        studentsList = new ArrayList<>();
        studentsList.add(new Student("Angel", "Motta"));
        studentsList.add(new Student("Jose", "Vega"));
        studentsList.add(new Student("Jossie", "Bartra"));
    }


    @GetMapping("/students")
    public List<Student> getStudents() {
        return studentsList;
    }

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {
        if (studentId >= studentsList.size() || studentId < 0) {
            throw new StudentNotFoundException("Not found Student id: " + studentId);
        }
        return studentsList.get(studentId);
    }

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException e) {
        StudentErrorResponse errorResponse = new StudentErrorResponse();
        errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
        errorResponse.setMessage(e.getMessage());
        errorResponse.setTimestamp(System.currentTimeMillis());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
}
