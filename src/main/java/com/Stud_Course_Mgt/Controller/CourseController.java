package com.Stud_Course_Mgt.Controller;

import com.Stud_Course_Mgt.Model.Course;
import com.Stud_Course_Mgt.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CourseController {
    @Autowired
    private CourseService courseService;
    //Get all courses
    @GetMapping("/courses")
    public ResponseEntity<List<Course>> getAllCourses(){
        List<Course> allCourses = courseService.getAllCourses();
        return new ResponseEntity<>(allCourses, HttpStatus.OK);
    }

    @PostMapping("/course")
    public ResponseEntity<Course> createCourse(@RequestBody Course course){
        Course saveCourse = courseService.saveCourse(course);
        return new ResponseEntity<>(saveCourse, HttpStatus.CREATED);
    }

    @GetMapping("/course/{id}")
    public ResponseEntity<Course> getCourse(@PathVariable Long id){
        Course courseById = courseService.getCourseById(id);
        return new ResponseEntity<>(courseById, HttpStatus.OK);
    }

    @DeleteMapping("/course/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable Long id){
        courseService.deleteCourse(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/course/{id}")
    public ResponseEntity<Course> updateCourse(@RequestBody Course course, @PathVariable Long id){
        Course updateCourse = courseService.updateCourse(course, id);
        return new ResponseEntity<>(updateCourse,HttpStatus.OK);
    }
}
