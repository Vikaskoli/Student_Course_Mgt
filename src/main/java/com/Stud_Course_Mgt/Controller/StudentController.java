package com.Stud_Course_Mgt.Controller;

import com.Stud_Course_Mgt.Model.Student;
import com.Stud_Course_Mgt.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {
    @Autowired
    private StudentService studentService;

    /*
    What kind of HTTP request is this? → POST
    How do we map that in Spring? → @PostMapping

    ===>method signature
    What is the method name? → createStudent (clear and descriptive)
    What input will it take? → A Student object from the request body
    What should it return? → ResponseEntity<Student> for status + data
    */
    @PostMapping("/student")
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        //Call studentService.saveStudent(student) to save it.
        Student savedStudent = studentService.saveStudent(student);

        //What do we return? → The saved Student object
        //With which status? → 201 Created (because we're creating a resource)
        //This wraps both:The savedStudent data ✅ and HTTP status code 201 ✅
        return new ResponseEntity<>(savedStudent, HttpStatus.CREATED);
    }

    //What will the method return? → A list of students
    //What should the HTTP response be? → A ResponseEntity<List<Student>>

    @GetMapping("/students")
    public ResponseEntity<List<Student>> getAllStudents(){
        List<Student> allStudents = studentService.getAllStudents();
        return new ResponseEntity<>(allStudents,HttpStatus.OK);
    }


    //@PathVariable Long id: This binds the id from the URL to the method’s parameter id.
    @GetMapping("/student/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id){
        Student studentById = studentService.getStudentById(id);
        return new ResponseEntity<>(studentById,HttpStatus.OK);
    }

    @DeleteMapping("/student/{id}")
    public  ResponseEntity<Void> deleteStudent(@PathVariable Long id){
        studentService.deleteStudent(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
