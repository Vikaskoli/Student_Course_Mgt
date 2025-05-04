package com.Stud_Course_Mgt.Controller;

import com.Stud_Course_Mgt.Model.Enrollment;
import com.Stud_Course_Mgt.Service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EnrollmentController {

    @Autowired
    private EnrollmentService enrollmentService;

    @PostMapping("/enroll/{studentId}/{courseId}")
    public ResponseEntity<Enrollment> newEnrollment(@PathVariable Long studentId, @PathVariable Long courseId){
        Enrollment enrollments = enrollmentService.enrollStudentInCourse(studentId, courseId);
        return new ResponseEntity<>(enrollments, HttpStatus.CREATED);
    }

    @GetMapping("/enrollments")
    public ResponseEntity<List<Enrollment>> getEnrollments(){
        List<Enrollment> allEnrollments = enrollmentService.getAllEnrollments();
        return new ResponseEntity<>(allEnrollments, HttpStatus.OK);

    }

    @GetMapping("/enroll/{id}")
    public ResponseEntity<Enrollment> getEnrollment(@PathVariable Long id){
        Enrollment enrollment = enrollmentService.getEnrollment(id);
        return  new ResponseEntity<>(enrollment,HttpStatus.OK);
    }

    @DeleteMapping("/enroll/{id}")
    public ResponseEntity<Void> deleteEnrollment(@PathVariable Long id){
        enrollmentService.deleteEnrollment(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
