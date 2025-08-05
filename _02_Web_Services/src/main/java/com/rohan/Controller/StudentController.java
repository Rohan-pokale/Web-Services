package com.rohan.Controller;

import com.rohan.Model.Student;
import com.rohan.Service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/student")
public class StudentController {

    StudentService studentService;

    @PostMapping
    public ResponseEntity<Student> addStudent(@RequestBody Student student){
        studentService.addStudent(student);
//        return ResponseEntity.ok().build();
        return  new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Student> UpdateStudent(@RequestBody Student student){
        studentService.UpdateStudent(student);
        return  new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable("id") int id){
        studentService.deleteStudent(id);
    }

    @GetMapping("/id")
    public Student getStudent(@PathVariable("id") int id){
        return studentService.getStudent(id);
    }

    @GetMapping
    public List<Student> getStudents(){
        return studentService.getStudents();
    }

}
