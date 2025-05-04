package com.Stud_Course_Mgt.Service;

import com.Stud_Course_Mgt.Model.Student;
import com.Stud_Course_Mgt.Repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepo studentRepo;

    //save student
    public Student saveStudent(Student student){
        return studentRepo.save(student);
    }

    //getting list of all Students
    public List<Student> getAllStudents(){
        return studentRepo.findAll();
    }

    //getting student by Id
    public Student getStudentById(Long id){
        return studentRepo.findById(id)
                .orElseThrow(()->new RuntimeException("Student not found with id :"+id));
    }

    //delete student
    public  void deleteStudent(Long id){
        studentRepo.deleteById(id);
    }
}
