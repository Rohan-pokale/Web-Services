package com.rohan.Controller;

import com.rohan.Model.Student;
import com.rohan.Service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/students")
public class StudentController {

    private  StudentService studentService;



//    @RequestMapping(method = RequestMethod.POST)
    @PostMapping
    public String addStudent(@RequestParam("name") String name, @RequestParam("courseName") String courseName, @RequestParam("address") String address) {

        Student student = new Student();
        student.setName(name);
        student.setCourseName(courseName);
        student.setAddress(address);

        studentService.addStudent(student);
        return "Student added successfully";
    }

//    @RequestMapping(value = "/update",method = RequestMethod.POST)
    @PutMapping
    public String updateStudent(@RequestBody Student student) {
        studentService.updateStudent(student);
        return "student updated successfully";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteStudent(@PathVariable("id") int id) {
        studentService.deleteStudent(id);
        return "Student deleted successfully";
    }

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable("id") int id) {
        return studentService.getStudent(id);
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

}
