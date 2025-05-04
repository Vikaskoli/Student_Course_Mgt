package com.Stud_Course_Mgt.Service;

import com.Stud_Course_Mgt.Model.Course;
import com.Stud_Course_Mgt.Model.Enrollment;
import com.Stud_Course_Mgt.Model.Student;
import com.Stud_Course_Mgt.Repository.CourseRepo;
import com.Stud_Course_Mgt.Repository.EnrollmentRepo;
import com.Stud_Course_Mgt.Repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnrollmentService {

    @Autowired
    private EnrollmentRepo enrollmentRepo;

    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    private CourseRepo courseRepo;

    //Enrolling a Student in a Course
    public Enrollment enrollStudentInCourse(Long studentId, Long courseId){


        // Check if already enrolled
        Optional<Enrollment> existingEnrollment =
                enrollmentRepo.findByStudentIdAndCourseId(studentId, courseId);

        if (existingEnrollment.isPresent()) {
            throw new RuntimeException("Student is already enrolled in this course.");
        }
        // Fetch student and course by their respective IDs

        Student student = studentRepo.findById(studentId)
                .orElseThrow(()->new RuntimeException("Student not found with id " + studentId));

        Course course = courseRepo.findById(courseId)
                .orElseThrow(()->new RuntimeException("Student not found with id " + studentId));

        //Create and save Enrollment
        Enrollment enrollment = new Enrollment();
        enrollment.setStudent(student);
        enrollment.setCourse(course);

        return enrollmentRepo.save(enrollment);

    }

    //Getting enrollments
    public List<Enrollment> getAllEnrollments(){
        return enrollmentRepo.findAll();
    }

    //Get Enrollment By ID
    public Enrollment getEnrollment(Long id){
        return enrollmentRepo.findById(id)
                .orElseThrow(()->new RuntimeException("Enrollment not found with id " + id));
    }

    //Delete enrollment
    public void deleteEnrollment(Long id){
        enrollmentRepo.deleteById(id);
    }
}
