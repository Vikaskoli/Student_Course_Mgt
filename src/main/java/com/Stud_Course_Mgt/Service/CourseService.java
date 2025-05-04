package com.Stud_Course_Mgt.Service;

import com.Stud_Course_Mgt.Model.Course;
import com.Stud_Course_Mgt.Repository.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepo courseRepo;
    public Course saveCourse(Course course){
        return courseRepo.save(course);
    }
    public List<Course> getAllCourses(){
        return courseRepo.findAll();
    }
    public Course getCourseById(Long id){
        return courseRepo.findById(id)
                .orElseThrow(()-> new RuntimeException("Course not found with id :"+id));
    }
    public void deleteCourse(Long id){
        courseRepo.deleteById(id);
    }

    public Course updateCourse(Course course, Long id){
        Course existingCourse = courseRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Course Not found.."));

        // 🔄 Update fields
        existingCourse.setName(course.getName());
        existingCourse.setDescription(course.getDescription());
        existingCourse.setCredits(course.getCredits());

        return courseRepo.save(existingCourse);
    }


}
