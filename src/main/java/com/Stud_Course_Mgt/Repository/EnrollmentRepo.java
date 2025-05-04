package com.Stud_Course_Mgt.Repository;

import com.Stud_Course_Mgt.Model.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EnrollmentRepo extends JpaRepository<Enrollment, Long > {

    Optional<Enrollment> findByStudentIdAndCourseId(Long studentId, Long courseId);

}
