package ru.hogwarts.school.controller;

import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.dto.StudentDtoIn;
import ru.hogwarts.school.dto.StudentDtoOut;
import ru.hogwarts.school.service.StudentService;

@RestController
@RequestMapping("student")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public StudentDtoOut createStudent(@RequestBody StudentDtoIn studentDtoIn) {
        return studentService.createStudent(studentDtoIn);
    }

    @GetMapping("/{id}")
    public StudentDtoOut readeStudent(@PathVariable("id") long id) {
        return studentService.readStudent(id);
    }

    @PutMapping("/{id}")
    public StudentDtoOut updateStudent(@PathVariable("id") long id, @RequestBody StudentDtoIn studentDtoIn) {
        return studentService.updateStudent(id, studentDtoIn);
    }

    @DeleteMapping("/{id}")
    public StudentDtoOut deleteStudent(@PathVariable("id") long id) {
        return studentService.deleteStudent(id);
    }

}
